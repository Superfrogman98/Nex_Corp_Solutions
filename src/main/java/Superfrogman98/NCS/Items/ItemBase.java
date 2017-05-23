package Superfrogman98.NCS.Items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import Superfrogman98.NCS.NexCorpSolutions;
/**
 * Created by Superfrogman98 on 5/20/2017.
 */
public class ItemBase extends Item implements ItemModelProvider {

    protected String name;

    public ItemBase(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(NexCorpSolutions.creativeTab);
    }

    @Override
    public  void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item,0,name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }

}
