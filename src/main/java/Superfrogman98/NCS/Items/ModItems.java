package Superfrogman98.NCS.Items;

/*
 * Created by Superfrogman98 on 5/20/2017.
 *registers  items for the mod
 */

import Superfrogman98.NCS.Items.Records.ItemRecordHIM;
import Superfrogman98.NCS.Items.Tools.ToolSledgeHammer;
import  net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    //items
    public static ItemBase plateCarbon;
    public static ItemBase rawCrystalHypon;
    //food, crops
    public static ItemCornSeed cornSeed;
    public static ItemCorn corn;
    //tools
    public static ToolSledgeHammer toolIronSledgeHammer;

    //records
    public static ItemRecordHIM himTheme;

    //materials


    public static void init(){
        plateCarbon = register(new ItemOre("plate_carbon","plateCarbon"));
        rawCrystalHypon = register(new ItemOre("raw_crystal_hypon","crystalRawHypon"));
        cornSeed = register(new ItemCornSeed());
        corn = register(new ItemCorn());
        himTheme =register(new ItemRecordHIM());
        toolIronSledgeHammer = register(new ToolSledgeHammer("iron_sledgehammer", Item.ToolMaterial.IRON, 3F));

        //System.out.println("----------------------Items registered----------------------");
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
