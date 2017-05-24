package Superfrogman98.NCS.Items.Tools;

import net.minecraft.init.Blocks;

/**
 * Created by Superfrogman98 on 5/23/2017.
 * adds classes for tools that need restricted blocks to mine
 */
public class CustomToolClasses  {
    public static void init(){
        Blocks.COBBLESTONE.setHarvestLevel("sledgehammer", 0);
        Blocks.STONE.setHarvestLevel("sledgehammer", 0);
        Blocks.GRAVEL.setHarvestLevel("sledgehammer", 0);
    }
}
