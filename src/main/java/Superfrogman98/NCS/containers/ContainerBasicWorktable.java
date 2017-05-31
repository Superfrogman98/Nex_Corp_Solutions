package Superfrogman98.NCS.containers;


import Superfrogman98.NCS.tile_entities.TileEntityBasicWorktable;
import Superfrogman98.NCS.gui.elements.SlotTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Superfrogman98 on 5/26/2017.
 */
public class ContainerBasicWorktable extends Container {


    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 4,3);
    public IInventory craftResult;
    private final IInventory tableInventory;
    public World worldObj;

    public ContainerBasicWorktable(InventoryPlayer invPlayer, IInventory tableInventory){
        this.tableInventory = tableInventory;
        craftResult = new InventoryCraftResult();
        this.worldObj = invPlayer.player.getEntityWorld();
        addTileSlots();
        addPlayerSlots(invPlayer);
        //add crafting slot
       // this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 125, 31));
    }

    private void addPlayerSlots(InventoryPlayer playerInventory){
        //slots for the main inventory
        for(int row = 0; row < 3; ++row){
            for(int col = 0; col <9 ; ++col){
                int x = 8 + col * 18;
                int y = row *18 + 84;
                this.addSlotToContainer(new Slot(playerInventory , col + (row*9) + 9,x,y));
            }
        }
        //slots for hotbar
        for(int row = 0; row < 9; ++row){
            int x = 8 + row*18;
            int y = 58 +84;
            this.addSlotToContainer(new Slot(playerInventory,row,x,y));
        }
    }

    private void addTileSlots(){
        //System.out.println("Table Opened");
        int x = 26;
        int y = 18;

        //add 8 top slots
        int slotIndex = 0;
        for(int i = 0; i< 2; i++){
            for(int j = 0; j<4; j++){
                this.addSlotToContainer(new Slot(craftMatrix,slotIndex,x,y));
                if(tableInventory.getStackInSlot(slotIndex) != null){
                    this.getSlot(slotIndex).putStack(tableInventory.getStackInSlot(slotIndex));
                }
                slotIndex++;
                x += 18;
            }
            x=26;
            y += 18;
        }
        x = 26;
        y = 59;
        for(int i = 0; i<4; i++){
            addSlotToContainer(new SlotTool(craftMatrix,slotIndex,x,y));
            if(tableInventory.getStackInSlot(slotIndex) != null){
                this.getSlot(slotIndex).putStack(tableInventory.getStackInSlot(slotIndex));
            }
            slotIndex++;
            x += 18;
        }
    }
    //saves craft matrix to persistent inventory
    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
                tableInventory.setInventorySlotContents(i, craftMatrix.getStackInSlot(i));
            }
        }
        //System.out.println("Table Closed");
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
       return this.tableInventory.isUseableByPlayer(player);
    }


}
