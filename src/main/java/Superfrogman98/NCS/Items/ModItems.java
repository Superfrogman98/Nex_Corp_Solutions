package Superfrogman98.NCS.Items;

/**
 * Created by Superfrogman98 on 5/20/2017.
 */

import  net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {


    public static ItemBase plateCarbon;
    public static ItemBase rawCrystalHypon;
    public static ItemCornSeed cornSeed;
    public static ItemCorn corn;


    public static void init(){
        plateCarbon = register(new ItemOre("plate_carbon","plateCarbon"));
        rawCrystalHypon = register(new ItemOre("raw_crystal_hypon","crystalRawHypon"));
        cornSeed = register(new ItemCornSeed());
        corn = register(new ItemCorn());
        System.out.println("----------------------Items registered----------------------");
    }

    private static <T extends Item> T register(T item){
        GameRegistry.register(item);

        if(item instanceof ItemModelProvider){
            ((ItemModelProvider)item).registerItemModel(item);
        }
        if(item instanceof  ItemOreDict){
            ((ItemOreDict)item).initOreDict();
        }
        return item;

    }


}
