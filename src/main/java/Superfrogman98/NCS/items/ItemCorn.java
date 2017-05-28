package Superfrogman98.NCS.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;
import Superfrogman98.NCS.NexCorpSolutions;

/**
 * Created by Superfrogman98 on 5/22/2017.
 */
public class ItemCorn extends ItemFood implements ItemModelProvider,ItemOreDict {

    public ItemCorn(){
        super(1, 0.6f, false);
        setUnlocalizedName("corn");
        setRegistryName("corn");
        setCreativeTab(NexCorpSolutions.creativeTab);
    }

    @Override
    public void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(this,0,"corn");
    }
    @Override
    public void initOreDict(){
        OreDictionary.registerOre("cropCorn",this);
    }


}
