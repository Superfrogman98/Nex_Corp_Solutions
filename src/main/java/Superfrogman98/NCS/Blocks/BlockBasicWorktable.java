package Superfrogman98.NCS.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class BlockBasicWorktable extends BlockBase {

    public BlockBasicWorktable(){
        super(Material.ROCK,"basic_worktable");
    }

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

}
