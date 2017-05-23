package Superfrogman98.NCS.Blocks;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */

import Superfrogman98.NCS.Items.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import Superfrogman98.NCS.NexCorpSolutions;

public class BlockBase extends Block implements ItemModelProvider {

    protected String name;

    public BlockBase(Material material,String name){
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(NexCorpSolutions.creativeTab);

    }

    @Override
    public void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item,0,name);
    }
    @Override
    public BlockBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
