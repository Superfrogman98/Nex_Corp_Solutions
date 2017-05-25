package Superfrogman98.NCS.Blocks.TileEntities.counter;

import Superfrogman98.NCS.Blocks.BlockBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Superfrogman98 on 5/24/2017.
 */
public class BlockCounter extends BlockBase implements ITileEntityProvider{

    public BlockCounter(){
        super(Material.ROCK, "counter");
        GameRegistry.registerTileEntity(TileEntityCounter.class, this.name);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TileEntityCounter();
    }

    private TileEntityCounter getTE(World world, BlockPos pos){
        return (TileEntityCounter) world.getTileEntity(pos);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote){//checks to be server side to count
            int counter = 0;
            if(side == EnumFacing.DOWN){
                counter = getTE(world, pos).decrement();
            }else if(side == EnumFacing.UP){
                counter = getTE(world, pos).increment();
            }else{
                counter = getTE(world, pos).getCounter();
                if(counter >= 1 && pos.getY()>1){
                    //world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(), counter + 1f, true);
                    for(int x = (counter-1)* -1; x<counter; x++){
                        for(int z = (counter-1)* -1; z<counter; z++){
                            if(counter >10){
                                world.destroyBlock(pos.add(x,-1,z),false);
                            }else{
                                world.destroyBlock(pos.add(x,-1,z),true);
                            }

                        }
                    }
                }
            }
            player.addChatComponentMessage(new TextComponentString(TextFormatting.GREEN + "Counter: " + counter));
        }
        return true;
    }
}
