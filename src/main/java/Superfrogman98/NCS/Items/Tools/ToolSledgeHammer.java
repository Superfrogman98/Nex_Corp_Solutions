package Superfrogman98.NCS.Items.Tools;

import Superfrogman98.NCS.Items.ItemModelProvider;
import Superfrogman98.NCS.NexCorpSolutions;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by Superfrogman98 on 5/23/2017.
 */
public class ToolSledgeHammer extends ItemTool implements ItemModelProvider{

    public ToolSledgeHammer(String name, ToolMaterial material, Float efficiency){
        super(material, Sets.newHashSet(new Block[]{}));
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setMaxDamage(material.getMaxUses()*2);
        this.efficiencyOnProperMaterial = efficiency;
        this.setHarvestLevel("sledgehammer",material.getHarvestLevel());
        this.setCreativeTab(NexCorpSolutions.creativeTab);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onBlockDrops(BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester().getHeldItemMainhand() != null ) { //checks that an item is held
            //event.getDrops().add(new ItemStack(Blocks.GRAVEL, 1,0));
            if (event.getHarvester().getHeldItemMainhand().getItem().getUnlocalizedName().contains("sledgehammer")) { //checks the registry name to have sledgehammer in it...what will this do to other mods?
                //determines what to overide if needed for different blocks drop, have to add in custom tool classes for them to be minable first
                if (event.getState().getBlock().getUnlocalizedName().equals(Blocks.COBBLESTONE.getUnlocalizedName())) {
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Blocks.GRAVEL, 1, 0));
                }else if (event.getState().getBlock().getUnlocalizedName().equals(Blocks.GRAVEL.getUnlocalizedName())) {
                    event.getDrops().clear();
                    event.getDrops().add(new ItemStack(Blocks.SAND, 1, 0));
                }

            }

        }
    }
    @Override
    public void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item, 0,this.getRegistryName().toString());
    }


}
