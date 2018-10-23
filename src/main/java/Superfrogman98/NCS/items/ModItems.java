package Superfrogman98.NCS.items;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
    public static ItemBase plateCarbon;

    public static void init()
    {
        plateCarbon = new ItemBase("plate_carbon", NexCorpSolutions.CREATIVE_TAB);
    }


    public static void register(IForgeRegistry<Item> registry)
    {
        registry.registerAll
        (
                plateCarbon
        );
    }

}
