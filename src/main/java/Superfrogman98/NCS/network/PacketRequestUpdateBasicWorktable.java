package Superfrogman98.NCS.network;

import Superfrogman98.NCS.blocks.tile_entities.TileEntityBasicWorktable;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Superfrogman98 on 5/26/2017.
 * Request update from the server for the basic worktable data
 */
public class PacketRequestUpdateBasicWorktable implements IMessage {

    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdateBasicWorktable(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }

    public PacketRequestUpdateBasicWorktable(TileEntityBasicWorktable te) {
        this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PacketRequestUpdateBasicWorktable() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(dimension);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        dimension = buf.readInt();
    }

    public static class Handler implements IMessageHandler<PacketRequestUpdateBasicWorktable, PacketUpdateBasicWorktable> {

        @Override
        public PacketUpdateBasicWorktable onMessage(PacketRequestUpdateBasicWorktable message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(message.dimension);
            TileEntityBasicWorktable te = (TileEntityBasicWorktable) world.getTileEntity(message.pos);
            if (te != null) {
                return new PacketUpdateBasicWorktable(te);
            } else {
                return null;
            }
        }

    }

}
