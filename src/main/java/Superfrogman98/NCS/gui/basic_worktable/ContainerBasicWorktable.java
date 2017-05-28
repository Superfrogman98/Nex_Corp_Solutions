package Superfrogman98.NCS.gui.basic_worktable;


import Superfrogman98.NCS.blocks.tile_entities.TileEntityBasicWorktable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Created by Superfrogman98 on 5/26/2017.
 */
public class ContainerBasicWorktable extends Container {

    private TileEntityBasicWorktable te;

    public ContainerBasicWorktable(IInventory playerInventory, TileEntityBasicWorktable te){
        this.te = te;
        addTileSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory){
        //slots for the main inventory
        for(int row = 0; row < 3; ++row){
            for(int col = 0; col <9 ; ++col){
                int x = 10 + col * 18;
                int y = row *18 + 70;
                this.addSlotToContainer(new Slot(playerInventory , col + (row*9) + 9,x,y));
            }
        }
        //slots for hotbar
        for(int row = 0; row < 9; ++row){
            int x = 10 + row*18;
            int y = 58 +70;
            this.addSlotToContainer(new Slot(playerInventory,row,x,y));
        }
    }

    private void addTileSlots(){
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 10;
        int y = 6;

        //add tiles slots
        int slotIndex = 0;
        for(int i = 0; i< itemHandler.getSlots(); i++){
            addSlotToContainer(new SlotItemHandler(itemHandler,slotIndex,x,y));
            slotIndex++;
            x += 18;
        }
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if(index < TileEntityBasicWorktable.SIZE){
                if(!this.mergeItemStack(itemStack1, TileEntityBasicWorktable.SIZE, this.inventorySlots.size(),true)){
                    return null;
                }
            }else if(!this.mergeItemStack(itemStack1,0,TileEntityBasicWorktable.SIZE, false)){
                return null;
            }
            if(itemStack1.stackSize == 0){
                slot.putStack(null);
            }else {
                slot.onSlotChange(null,null);
            }
        }
        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return te.canInteractWith(player);
    }


}
