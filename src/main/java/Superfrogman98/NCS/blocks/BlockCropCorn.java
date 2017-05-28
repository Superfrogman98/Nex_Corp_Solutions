package Superfrogman98.NCS.blocks;

import Superfrogman98.NCS.items.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class BlockCropCorn extends BlockCrops {

    public BlockCropCorn() {
        setUnlocalizedName("crop_corn");
        setRegistryName("crop_corn");
    }

    @Override
    protected Item getSeed(){
        return ModItems.cornSeed;
    }

    @Override
    protected Item getCrop(){
        return ModItems.corn;
    }
}
