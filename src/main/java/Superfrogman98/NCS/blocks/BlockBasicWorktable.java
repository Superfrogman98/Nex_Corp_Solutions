package Superfrogman98.NCS.blocks;

import Superfrogman98.NCS.NexCorpSolutions;
import Superfrogman98.NCS.tile_entities.TileEntityBasicWorktable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class BlockBasicWorktable extends BlockBase implements ITileEntityProvider {

    public static final int GUI_ID = 1;
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockBasicWorktable(){
        super(Material.ROCK,"basic_worktable");
        GameRegistry.registerTileEntity(TileEntityBasicWorktable.class, this.name);
        this.setHarvestLevel("pickaxe",0);
        this.setHardness(5f);
        this.setResistance(3f);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    //for changing the direction of the render
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, placer)), 2);
    }

    public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity) {
        return EnumFacing.getFacingFromVector(
                (float) (entity.posX - clickedBlock.getX()),
                (float) (entity.posY - clickedBlock.getY()),
                (float) (entity.posZ - clickedBlock.getZ()));
    }

    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(FACING, EnumFacing.getFront(meta & 7));
    }
    @Override
    @Deprecated
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
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

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        TileEntityBasicWorktable te = (TileEntityBasicWorktable) world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
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
        if(!player.isSneaking()){
            player.openGui(NexCorpSolutions.instance, GUI_ID , world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

}
