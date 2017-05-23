package Superfrogman98.NCS.Recipes;

import Superfrogman98.NCS.Blocks.ModBlocks;
import Superfrogman98.NCS.Items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class ModRecipes {

    public static void init(){

        //shapeless recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cornSeed),ModItems.corn); // corn into corn seed

        //shaped recipes


        //furnace recipe
        GameRegistry.addSmelting(ModBlocks.oreHypon, new ItemStack(ModItems.rawCrystalHypon),0.7f);
    }

}
