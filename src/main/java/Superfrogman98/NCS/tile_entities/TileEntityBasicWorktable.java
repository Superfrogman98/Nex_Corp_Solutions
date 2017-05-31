package Superfrogman98.NCS.tile_entities;

import Superfrogman98.NCS.network.PacketRequestUpdateBasicWorktable;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

/**
 * Created by Superfrogman98 on 5/24/2017.
 */
public class TileEntityBasicWorktable extends TileEntity implements ISidedInventory {

    private ItemStack[] inventory;
    private String customName;
    public static int SIZE = 12;

    public TileEntityBasicWorktable(){
        this.inventory = new ItemStack[this.SIZE];
    }

    public String getCustomName(){
        return this.customName;
    }

    public void setCustomName(String customName){
        this.customName = customName;
    }

    @Override
    public String getName(){
        return this.hasCustomName() ? this.customName : "container.basic_worktable";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }
    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
        return false;
    }
    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        return false;
    }
    @Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        return side == EnumFacing.UP ? new int[0] : (side == EnumFacing.DOWN ? new int[0] : new int[0]);
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }
    @Override
    public int getSizeInventory() {
        return this.SIZE;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).stackSize <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }
    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory())
            return;
            if (stack != null && stack.stackSize > this.getInventoryStackLimit())
                stack.stackSize = this.getInventoryStackLimit();
            if (stack != null && stack.stackSize == 0)
                stack = null;
            this.inventory[index] = stack;
            this.markDirty();

    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index >= 8 && index <= 12){
            return stack.getItem().isDamageable();
        }else{
            return true;
        }
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getSizeInventory(); i++)
            this.setInventorySlotContents(i, null);
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }
        return compound;
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }
    }
    @Override
    public void onLoad(){
        if(worldObj.isRemote){
            NexCorpSolutions.network.sendToServer(new PacketRequestUpdateBasicWorktable(this));
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }


}
