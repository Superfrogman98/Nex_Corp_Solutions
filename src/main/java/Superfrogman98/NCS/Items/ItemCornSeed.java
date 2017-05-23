package Superfrogman98.NCS.Items;

import Superfrogman98.NCS.Blocks.ModBlocksCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import Superfrogman98.NCS.NexCorpSolutions;
/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class ItemCornSeed extends ItemSeeds implements ItemModelProvider {

    public ItemCornSeed(){
        super(ModBlocksCrops.cropCorn, Blocks.FARMLAND);
        setUnlocalizedName("corn_seeds");
        setRegistryName("corn_seeds");
        setCreativeTab(NexCorpSolutions.creativeTab);
    }

    @Override
    public void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item, 0,"corn_seeds");
    }
}
