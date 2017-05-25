package Superfrogman98.NCS.Blocks.TileEntities.counter;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Superfrogman98 on 5/24/2017.
 */
public class TileEntityCounter extends TileEntity {

    private int counter = 0;

    public int decrement(){
        counter--;
        markDirty();  //tells minecraft to write to disk
        return counter;
    }
    public int increment(){
        counter++;
        markDirty(); //tells minecraft to write to disk
        return counter;
    }
    public int getCounter(){
        return counter;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger("counter",counter);
        return compound;
    }
}
