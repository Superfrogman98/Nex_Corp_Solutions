package Superfrogman98.NCS.blocks;

/**
 * Created by Superfrogman98 on 5/21/2017.
 */

import Superfrogman98.NCS.items.ItemOreDict;
import  net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOre extends BlockBase implements ItemOreDict {

    private String oreName;

    public BlockOre(String name, String oreName, Float hardness, Float resistance){
        super(Material.ROCK,name);

        this.oreName = oreName;

        setHardness(hardness);
        setResistance(resistance);
    }

    @Override
    public void initOreDict(){
        OreDictionary.registerOre(oreName,this);
    }

    @Override
    public BlockOre setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}