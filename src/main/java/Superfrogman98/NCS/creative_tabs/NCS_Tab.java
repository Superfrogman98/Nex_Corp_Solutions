package Superfrogman98.NCS.creative_tabs;

import Superfrogman98.NCS.NexCorpSolutions;
import Superfrogman98.NCS.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NCS_Tab extends CreativeTabs
{
    public NCS_Tab()
    {
        super("NCS");
        setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.plateCarbon);
    }

    @Override
    public boolean hasSearchBar()
    {
        return true;
    }
}
