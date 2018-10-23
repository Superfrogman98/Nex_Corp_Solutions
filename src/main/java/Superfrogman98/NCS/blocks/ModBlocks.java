package Superfrogman98.NCS.blocks;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{

    //ores
    public static BlockBase[] blocks =
        {
            new BlockOre("ore_hypon", NexCorpSolutions.CREATIVE_TAB, 3F, 5F)
        };

    public static void register(IForgeRegistry<Block> registry)
    {
        for(int i = 0; i<blocks.length; i++)
        {
            registry.register(blocks[i]);
        }
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        for(int i = 0; i<blocks.length; i++)
        {
            registry.register(blocks[i].createItemBlock());
        }

    }

    public static void registerModels()
    {
        for(int i = 0; i<blocks.length; i++)
        {
            blocks[i].registerItemModel(Item.getItemFromBlock(blocks[i]));
        }
    }

}
