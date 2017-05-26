package Superfrogman98.NCS.GUIs.BasicWorktable;

import Superfrogman98.NCS.Blocks.TileEntities.TileEntityBasicWorktable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Superfrogman98 on 5/26/2017.
 */
public class GuiProxyBasicWorktable implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityBasicWorktable) {
            return new ContainerBasicWorktable(player.inventory, (TileEntityBasicWorktable) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityBasicWorktable) {
            TileEntityBasicWorktable containerTileEntity = (TileEntityBasicWorktable) te;
            return new GuiBasicWorktable(containerTileEntity, new ContainerBasicWorktable(player.inventory, containerTileEntity));
        }
        return null;
    }
}