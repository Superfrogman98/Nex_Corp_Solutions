package Superfrogman98.NCS.Blocks;

/**
 * Created by Superfrogman98 on 5/22/2017.
 * class for blocks that drop items upon breaking them
 */
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockOreItemDrop extends BlockOre {
    private Item drop;
    private int minDrops;
    private int maxDrops;


    public BlockOreItemDrop(String name, String oreName, Float hardness, Float resistance, Item drop, int minDrops, int maxDrops) {
        super( name, oreName, hardness, resistance);
        this.drop = drop;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
    }
    //tells the block what item to drop
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return this.drop;
    }

    //when fortune is used adds bonus items to dropping
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), minDrops, maxDrops);
    }

    //by default drops one item
    public int quantityDropped(Random random) {
        return minDrops;
    }
}
