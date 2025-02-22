package pokecube.core.ai.tasks.misc;

import java.util.Map;
import java.util.UUID;

import com.google.common.collect.Maps;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import pokecube.api.entity.pokemob.IPokemob;
import pokecube.api.entity.pokemob.ai.AIRoutine;
import pokecube.api.entity.pokemob.ai.GeneralStates;
import pokecube.core.ai.brain.BrainUtils;
import pokecube.core.ai.brain.MemoryModules;
import pokecube.core.ai.tasks.TaskBase;
import thut.api.maths.Vector3;

/**
 * This attempts to make the mob follow the owner around in the world. It
 * triggers if the owner gets too far away from the mob, and the mob is set to
 * follow.
 */
public class FollowOwnerTask extends TaskBase
{
    public static final UUID FOLLOW_SPEED_BOOST_ID = UUID.fromString("662A6B8D-DA3E-4C1C-1234-96EA6097278D");
    public static final AttributeModifier FOLLOW_SPEED_BOOST = new AttributeModifier(
            FollowOwnerTask.FOLLOW_SPEED_BOOST_ID, "following speed boost", 0.5F,
            AttributeModifier.Operation.MULTIPLY_TOTAL);

    private static final Map<MemoryModuleType<?>, MemoryStatus> mems = Maps.newHashMap();
    static
    {
        // Dont run if have a combat target
        FollowOwnerTask.mems.put(MemoryModules.ATTACKTARGET.get(), MemoryStatus.VALUE_ABSENT);
        // Don't run if have a target location for moves
        FollowOwnerTask.mems.put(MemoryModules.MOVE_TARGET.get(), MemoryStatus.VALUE_ABSENT);
    }

    public static double speedMult = 2;

    private LivingEntity theOwner;

    private PathNavigation petPathfinder;

    private final double speed;

    float maxDist;
    float minDist;

    Vector3 ownerPos = new Vector3();
    Vector3 v = new Vector3();
    Vector3 v1 = new Vector3();

    public FollowOwnerTask(final IPokemob entity, final float min, final float max)
    {
        super(entity, FollowOwnerTask.mems);
        this.minDist = min;
        this.maxDist = max;
        this.speed = 1;
        if (this.pokemob.getOwner() != null) this.ownerPos.set(this.pokemob.getOwner());
    }

    @Override
    public void reset()
    {
        this.ownerPos.set(this.theOwner);
        this.entity.setSprinting(false);

        final AttributeInstance iattributeinstance = this.entity.getAttribute(Attributes.MOVEMENT_SPEED);
        iattributeinstance.removeModifier(FollowOwnerTask.FOLLOW_SPEED_BOOST);

        this.theOwner = null;
    }

    @Override
    public void run()
    {
        if (this.theOwner == null)
        {
            this.theOwner = this.pokemob.getOwner();
            this.ownerPos.set(this.theOwner);
        }
        // Look at owner.
        if (BrainUtils.canSee(this.entity, this.theOwner)) BehaviorUtils.lookAtEntity(this.entity, this.theOwner);
        else if (!this.petPathfinder.isDone()
                && this.petPathfinder.getPath().getNextNodeIndex() < this.petPathfinder.getPath().getNodeCount() - 3)
        {
            double x, y, z;
            var node = this.petPathfinder.getPath().getNode(this.petPathfinder.getPath().getNextNodeIndex() + 1);
            x = node.x + 0.5;
            y = node.y + 0.5;
            z = node.z + 0.5;
            // Or look at path location
            BrainUtils.lookAt(this.entity, x, y, z);
        }
        final boolean hasTarget = this.entity.getBrain().hasMemoryValue(MemoryModuleType.WALK_TARGET);
        WalkTarget target = hasTarget ? this.entity.getBrain().getMemory(MemoryModuleType.WALK_TARGET).get() : null;
        if (target == null || target.getTarget().currentPosition().distanceToSqr(this.theOwner.position()) > 1)
            target = new WalkTarget(new EntityTracker(this.theOwner, false), (float) this.speed, 1);

        final boolean isSprinting = this.entity.isSprinting();
        final double ds2 = target.getTarget().currentPosition().distanceToSqr(this.entity.position());
        final boolean shouldSprint = isSprinting ? ds2 > 9 : ds2 > 64;
        if (shouldSprint != isSprinting) this.entity.setSprinting(shouldSprint);
        
        final AttributeInstance iattributeinstance = this.entity.getAttribute(Attributes.MOVEMENT_SPEED);
        iattributeinstance.removeModifier(FollowOwnerTask.FOLLOW_SPEED_BOOST);
        if (this.entity.isSprinting())
        {
            iattributeinstance.addTransientModifier(FollowOwnerTask.FOLLOW_SPEED_BOOST);
        }
        this.setWalkTo(target);
    }

    @Override
    protected boolean shouldNotRun(Mob mobIn)
    {
        return this.pokemob.getOwner() == null;
    }

    @Override
    public boolean shouldRun()
    {
        // In a battle, so no follow, do battle
        if (this.pokemob.inCombat()) return false;
        // if not allowed to follow, skip
        if (!this.pokemob.isRoutineEnabled(AIRoutine.FOLLOW)) return false;
        // if unable to move, skip
        if (!TaskBase.canMove(this.pokemob)) return false;
        // if set to stay, skip
        if (this.pokemob.getGeneralState(GeneralStates.STAYING)) return false;
        final LivingEntity owner = this.pokemob.getOwner();
        // Nothing to follow
        if (owner == null) return false;
        double dr2 = this.entity.distanceToSqr(owner);
        // close enough, so skip
        if (dr2 < this.minDist * this.minDist) return false;
        this.petPathfinder = this.entity.getNavigation();
        // Follow owner.
        return true;
    }

}