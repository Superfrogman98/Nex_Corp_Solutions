package Superfrogman98.NCS.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOre extends BlockBase
{
    public BlockOre(String name, CreativeTabs tab, Float hardness, Float resistance)
    {
        super(Material.ROCK, name,tab);
        setHardness(hardness);
        setResistance(resistance);
    }
}
