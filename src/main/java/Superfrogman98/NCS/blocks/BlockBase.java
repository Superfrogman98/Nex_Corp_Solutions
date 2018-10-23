package Superfrogman98.NCS.blocks;


import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
    protected String name;

    public BlockBase(Material material, String name, CreativeTabs tab)
    {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
    }

    public void registerItemModel(Item itemBlock)
    {
        NexCorpSolutions.proxy.registerItemRenderer(itemBlock,0,name);
    }

    public Item createItemBlock()
    {
        return new ItemBlock(this).setRegistryName(getRegistryName());

    }
}
