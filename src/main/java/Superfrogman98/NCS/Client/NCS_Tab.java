package Superfrogman98.NCS.Client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import Superfrogman98.NCS.NexCorpSolutions;
import Superfrogman98.NCS.Items.ModItems;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */
public class NCS_Tab extends CreativeTabs {

    public NCS_Tab(){
        super(NexCorpSolutions.modId);
    }

    @Override
    public Item getTabIconItem(){
        return ModItems.plateCarbon;
    }
}
