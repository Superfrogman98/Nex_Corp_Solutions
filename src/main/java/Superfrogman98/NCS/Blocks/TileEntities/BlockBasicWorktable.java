package Superfrogman98.NCS.Blocks.TileEntities;

import Superfrogman98.NCS.Blocks.BlockBase;
import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class BlockBasicWorktable extends BlockBase implements ITileEntityProvider {

    public static final int GUI_ID = 1;


    public BlockBasicWorktable(){
        super(Material.ROCK,"basic_worktable");
        GameRegistry.registerTileEntity(TileEntityBasicWorktable.class, this.name);
        this.setHarvestLevel("pickaxe",0);
    }

    //make the model render stuff behind it
    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    @Deprecated
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess world, BlockPos pos, EnumFacing side){
        return false;
    }

    @Override
    @Deprecated
    public boolean isBlockNormalCube(IBlockState blockState){
        return false;
    }
    //creates the tile entity
    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TileEntityBasicWorktable();
    }

    private TileEntityBasicWorktable getTE(World world, BlockPos pos){
        return (TileEntityBasicWorktable) world.getTileEntity(pos);
    }

    //interaction with the model
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote){
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if(!(te instanceof TileEntityBasicWorktable)){
            return false;
        }
        player.openGui(NexCorpSolutions.instance,GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

}
