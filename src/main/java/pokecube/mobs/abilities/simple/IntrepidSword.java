package pokecube.mobs.abilities.simple;

import net.minecraft.world.entity.LivingEntity;
import pokecube.api.data.abilities.Ability;
import pokecube.api.data.abilities.AbilityProvider;
import pokecube.api.entity.pokemob.IPokemob;
import pokecube.api.entity.pokemob.PokemobCaps;
import pokecube.api.moves.utils.IMoveConstants;
import pokecube.core.moves.MovesUtils;

@AbilityProvider(name = "intrepid-sword")
public class IntrepidSword extends Ability
{
	@Override
    public void onAgress(IPokemob mob, LivingEntity target)
    {
        final IPokemob targetMob = PokemobCaps.getPokemobFor(target);
        if (targetMob != null) MovesUtils.handleStats2(mob, mob.getEntity(), IMoveConstants.ATTACK,
                IMoveConstants.RAISE);
    }
}
