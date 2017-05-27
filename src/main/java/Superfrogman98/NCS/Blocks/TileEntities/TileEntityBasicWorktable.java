package Superfrogman98.NCS.Blocks.TileEntities;

import Superfrogman98.NCS.Network.PacketRequestUpdateBasicWorktable;
import Superfrogman98.NCS.Network.PacketUpdateBasicWorktable;
import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraft.world.World;


/**
 * Created by Superfrogman98 on 5/24/2017.
 */
public class TileEntityBasicWorktable extends TileEntity {
    public static int SIZE = 9;

    public ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE){
        @Override
        protected void onContentsChanged(int slot){
            TileEntityBasicWorktable.this.markDirty();
            if(!worldObj.isRemote){
                //System.out.println("Basic worktable contents changed");
                NexCorpSolutions.network.sendToAllAround(new PacketUpdateBasicWorktable(TileEntityBasicWorktable.this), new NetworkRegistry.TargetPoint(worldObj.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
            }
        }
    };

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

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("items")){
            itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setTag("items",itemStackHandler.serializeNBT());
        return compound;
    }

    public boolean canInteractWith(EntityPlayer player){
        return !isInvalid() && player.getDistanceSq(pos.add(0.5D, 0.5D,0.5D)) <= 64D;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing){
        if( capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return true;
        }
        return super.hasCapability(capability, facing);
    }
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return (T) itemStackHandler;
        }
        return super.getCapability(capability,facing);
    }



}
