package Superfrogman98.NCS;

/*
 * Created by Superfrogman98 on 10/22/2018.
 * A minecraft mod to add various processing machines
 */

//imports

import Superfrogman98.NCS.blocks.ModBlocks;
import Superfrogman98.NCS.configs.ConfigNexCorpSolutions;
import Superfrogman98.NCS.creative_tabs.NCS_Tab;
import Superfrogman98.NCS.items.ModItems;
import Superfrogman98.NCS.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.logging.Logger;

@Mod(modid = NexCorpSolutions.MOD_ID, name = NexCorpSolutions.MOD_NAME, version = NexCorpSolutions.MOD_VERSION, acceptedMinecraftVersions = "[1.12]")

public class NexCorpSolutions
{

    public static final String MOD_ID = "nex_corp_solutions";
    public static final String MOD_NAME = "Nex Corp Solutions";
    public static final String MOD_VERSION = "0.0.1-mc1.12";

    public static final NCS_Tab CREATIVE_TAB = new NCS_Tab();

    @SidedProxy(clientSide = "Superfrogman98.NCS.proxies.ClientProxy", serverSide = "Superfrogman98.NCS.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static NexCorpSolutions instance;




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event )
    {
        System.out.println("--------PreInit: " + MOD_NAME + " --------");
        proxy.preInit(event);
        ConfigNexCorpSolutions.init(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("--------Init: " + MOD_NAME + " --------");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("--------PostInit: " + MOD_NAME + " --------");
        proxy.postInit(event);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
            ModBlocks.register(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event)
        {
            ModBlocks.registerModels();
        }

    }


}
