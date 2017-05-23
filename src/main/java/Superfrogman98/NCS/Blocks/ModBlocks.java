package Superfrogman98.NCS.Blocks;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */

import Superfrogman98.NCS.Items.ItemModelProvider;
import Superfrogman98.NCS.Items.ItemOreDict;
import Superfrogman98.NCS.Items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static BlockOreItemDrop oreHypon;
    public static BlockBasicWorktable basicWorktable;

    public static void init(){
        oreHypon = register(new BlockOreItemDrop("ore_hypon","oreHypon",5f,3f, ModItems.rawCrystalHypon,1,3));
        basicWorktable = register(new BlockBasicWorktable());
        System.out.println("----------------------Blocks registered----------------------");
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
