package Superfrogman98.NCS.Items.Tools;

import Superfrogman98.NCS.Items.ItemModelProvider;
import Superfrogman98.NCS.Items.ModItems;
import Superfrogman98.NCS.NexCorpSolutions;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Random;
import java.util.Set;

/**
 * Created by Superfrogman98 on 5/23/2017.
 */
public class ToolSledgeHammer extends ItemTool implements ItemModelProvider{
    private String name;

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.STONE, Blocks.COBBLESTONE, Blocks.GRAVEL});

    public ToolSledgeHammer(String name, ToolMaterial material, Float efficiency){
        super(material, EFFECTIVE_ON);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setMaxDamage(material.getMaxUses()*2);
        this.efficiencyOnProperMaterial = efficiency;
        this.setHarvestLevel("sledgehammer",material.getHarvestLevel());
        this.setCreativeTab(NexCorpSolutions.creativeTab);
        this.attackSpeed = -3.0f;
        this.damageVsEntity = material.getDamageVsEntity() +3;
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("SilkTouch on hammers: "+ Enchantments.SILK_TOUCH.canApply(new ItemStack(this)));

    }

    @SubscribeEvent
    public void onBlockDrops(BlockEvent.HarvestDropsEvent event) {
        Random random = new Random();

        if (event.getHarvester() != null) { //checks that harvester is player
            EntityPlayer player = event.getHarvester();
            if (player.getHeldItemMainhand().getItem().getUnlocalizedName().contains("sledgehammer")) { //checks the registry name to have sledgehammer in it...what will this do to other mods?
                //determines what to overide if needed for different blocks drop, have to add in custom tool classes for them to be minable first
                int amtDropped = 1;
                if (event.getFortuneLevel() > 0) {
                    amtDropped = MathHelper.clamp_int(1 + random.nextInt(event.getFortuneLevel() + 1), 1, 3);
                }
                if (event.getState().getBlock().getUnlocalizedName().equals(Blocks.COBBLESTONE.getUnlocalizedName())) {
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Blocks.GRAVEL, amtDropped, 0));
                } else if (event.getState().getBlock().getUnlocalizedName().equals(Blocks.GRAVEL.getUnlocalizedName())) {
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Blocks.SAND, amtDropped, 0));
                }
            }
        }
    }
    @Override
    public void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item, 0,name);
    }


}
