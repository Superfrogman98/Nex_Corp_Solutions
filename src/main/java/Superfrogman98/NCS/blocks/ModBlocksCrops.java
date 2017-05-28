package Superfrogman98.NCS.blocks;

/**
 * Created by Superfrogman98 on 5/21/2017.
 * class for crops to be registered so that they can be put after items
 */

import Superfrogman98.NCS.items.ItemModelProvider;
import Superfrogman98.NCS.items.ItemOreDict;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocksCrops{

    public static BlockCropCorn cropCorn;

    public static void init(){
        cropCorn = register(new BlockCropCorn(),null);
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock){
        GameRegistry.register(block);
        if(itemBlock != null){
            GameRegistry.register(itemBlock);

            if(block instanceof ItemModelProvider){
                ((ItemModelProvider)block).registerItemModel(itemBlock);
            }
            if(block instanceof ItemOreDict){
                ((ItemOreDict)block).initOreDict();
            }
            if(itemBlock instanceof ItemOreDict){
                ((ItemOreDict)itemBlock).initOreDict();
            }
        }
        return block;
    }

    private static <T extends Block> T register(T block){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }

}
