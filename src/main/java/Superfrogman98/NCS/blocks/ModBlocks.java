package Superfrogman98.NCS.blocks;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{


    public static BlockOre oreHypon;

    public static void init()
    {
        oreHypon = new BlockOre("ore_hypon", NexCorpSolutions.CREATIVE_TAB, 3F, 5F);

    }

    public static void register(IForgeRegistry<Block> registry)
    {
        registry.registerAll
        (
                oreHypon
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        registry.registerAll
        (
            oreHypon.createItemBlock()
        );
    }

    public static void registerModels()
    {
            oreHypon.registerItemModel(Item.getItemFromBlock(oreHypon));
    }


}
