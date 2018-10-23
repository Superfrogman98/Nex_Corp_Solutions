package Superfrogman98.NCS.items;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
    //first item is used for creative tab displayed item
    public static ItemBase[] items =
        {
            new ItemBase("plate_carbon", NexCorpSolutions.CREATIVE_TAB)
        };



    public static void register(IForgeRegistry<Item> registry)
    {
        for(int i = 0; i<items.length; i++)
        {
            registry.register(items[i]);
        }
    }

}
