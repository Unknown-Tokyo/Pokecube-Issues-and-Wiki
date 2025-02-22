package pokecube.nbtedit.packets;

import org.apache.logging.log4j.Level;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import pokecube.nbtedit.NBTEdit;
import thut.core.common.handlers.PlayerDataHandler;
import thut.core.common.handlers.PlayerDataHandler.PlayerData;

/** Created by Jay113355 on 6/28/2016. */
public class PacketHandler
{
    public static final thut.core.common.network.PacketHandler INSTANCE = new thut.core.common.network.PacketHandler(
            new ResourceLocation(NBTEdit.MODID, "comms"), "0");

    /**
     * Sends a Entity's nbt data to the player for editing.
     *
     * @param player   The player to send the Entity data to.
     * @param entityId The id of the Entity.
     */
    public static void sendCustomTag(final ServerPlayer player, final int entityId, final String customType)
    {
        if (NBTEdit.proxy.checkPermission(player))
        {
            final Entity entity = player.getLevel().getEntity(entityId);

            if (entity != null && !(entity instanceof Player))
                NBTEdit.proxy.sendMessage(player, "\"Error- Target must be a player", ChatFormatting.RED);
            else if (entity != null)
            {
                final CompoundTag tag = new CompoundTag();
                final PlayerData data = PlayerDataHandler.getInstance().getPlayerData(entity.getStringUUID())
                        .getData(customType);
                if (data == null)
                    NBTEdit.proxy.sendMessage(player, "\"Error - Unknown DataType " + customType, ChatFormatting.RED);
                else
                {
                    data.writeToNBT(tag);
                    CustomNBTPacket.ASSEMBLER.sendTo(new CustomNBTPacket(entityId, customType, tag), player);
                }
            }
            else NBTEdit.proxy.sendMessage(player, "\"Error - Unknown EntityID #" + entityId, ChatFormatting.RED);

        }
    }

    /**
     * Sends a Entity's nbt data to the player for editing.
     *
     * @param player   The player to send the Entity data to.
     * @param entityId The id of the Entity.
     */
    public static void sendEntity(final ServerPlayer player, final int entityId)
    {
        if (NBTEdit.proxy.checkPermission(player))
        {
            final Entity entity = player.getLevel().getEntity(entityId);
            if (entity instanceof Player && entity != player)
            {
                NBTEdit.proxy.sendMessage(player, "Error - You may not use NBTEdit on other Players",
                        ChatFormatting.RED);
                NBTEdit.log(Level.WARN,
                        player.getName().getString() + " tried to use NBTEdit on another player, " + entity.getName());
            }
            if (entity != null)
            {
                final CompoundTag tag = new CompoundTag();
                entity.saveWithoutId(tag);
                EntityNBTPacket.ASSEMBLER.sendTo(new EntityNBTPacket(entityId, tag), player);
            }
            else NBTEdit.proxy.sendMessage(player, "\"Error - Unknown EntityID #" + entityId, ChatFormatting.RED);
        }
    }

    /**
     * Sends a TileEntity's nbt data to the player for editing.
     *
     * @param player The player to send the TileEntity to.
     * @param pos    The block containing the TileEntity.
     */
    public static void sendTile(final ServerPlayer player, final BlockPos pos)
    {
        if (NBTEdit.proxy.checkPermission(player))
        {
            final BlockEntity te = player.getLevel().getBlockEntity(pos);
            if (te != null)
            {
                final CompoundTag tag = te.saveWithFullMetadata();
                TileNBTPacket.ASSEMBLER.sendTo(new TileNBTPacket(pos, tag), player);
            }
            else NBTEdit.proxy.sendMessage(player,
                    "Error - There is no TileEntity at " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ(),
                    ChatFormatting.RED);
        }
    }

    public void initialize()
    {
        this.registerPackets();
    }

    public void registerPackets()
    {
        PacketHandler.INSTANCE.registerMessage(CustomNBTPacket.class, CustomNBTPacket::new);
        PacketHandler.INSTANCE.registerMessage(CustomRequestPacket.class, CustomRequestPacket::new);
        PacketHandler.INSTANCE.registerMessage(EntityNBTPacket.class, EntityNBTPacket::new);
        PacketHandler.INSTANCE.registerMessage(EntityRequestPacket.class, EntityRequestPacket::new);
        PacketHandler.INSTANCE.registerMessage(MouseOverPacket.class, MouseOverPacket::new);
        PacketHandler.INSTANCE.registerMessage(TileNBTPacket.class, TileNBTPacket::new);
        PacketHandler.INSTANCE.registerMessage(TileRequestPacket.class, TileRequestPacket::new);
    }
}
