package Superfrogman98.NCS.gui.elements;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Superfrogman98 on 5/30/2017.
 */
public class SlotTool extends Slot {

    public SlotTool(IInventory inventory,int par2, int par3, int par4){
        super(inventory, par2,par3,par4);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack){
        return itemStack.getItem().isDamageable();
    }

    @Override
    public int getSlotStackLimit(){
        return 1;
    }


}
