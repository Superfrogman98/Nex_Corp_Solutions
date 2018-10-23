package Superfrogman98.NCS.items;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    protected String name;

    public ItemBase(String name, CreativeTabs tab)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        this.registerItemModel();
    }

    private void registerItemModel()
    {
        NexCorpSolutions.proxy.registerItemRenderer(this,0,name);

    }


}
