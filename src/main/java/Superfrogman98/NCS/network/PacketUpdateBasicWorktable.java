package Superfrogman98.NCS.network;

import Superfrogman98.NCS.blocks.tile_entities.TileEntityBasicWorktable;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/**
 * Created by Superfrogman98 on 5/26/2017.
 * update the basic worktable data
 */
public class PacketUpdateBasicWorktable implements IMessage {
    private BlockPos pos;
    private ItemStack stack;

    public PacketUpdateBasicWorktable(BlockPos pos, ItemStack stack){
        this.pos = pos;
        this.stack = stack;
    }

    public PacketUpdateBasicWorktable(TileEntityBasicWorktable te){
        this(te.getPos(), te.itemStackHandler.getStackInSlot(0));
    }

    public PacketUpdateBasicWorktable(){}

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeItemStack(buf, stack);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        stack = ByteBufUtils.readItemStack(buf);
    }

    public static class Handler implements IMessageHandler<PacketUpdateBasicWorktable, IMessage> {

        @Override
        public IMessage onMessage(PacketUpdateBasicWorktable message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntityBasicWorktable te = (TileEntityBasicWorktable) Minecraft.getMinecraft().theWorld.getTileEntity(message.pos);
                te.itemStackHandler.setStackInSlot(0, message.stack);
            });
            return null;
        }

    }


}
