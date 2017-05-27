package Superfrogman98.NCS;

/**
 * Created by Superfrogman98 on 5/20/2017.
 * A minecraft mod to add various processing machines
 */

//imports
import Superfrogman98.NCS.Blocks.ModBlocks;
import Superfrogman98.NCS.Blocks.ModBlocksCrops;
import Superfrogman98.NCS.Client.NCS_Tab;
import Superfrogman98.NCS.Items.ModItems;
import Superfrogman98.NCS.Items.Tools.CustomToolClasses;
import Superfrogman98.NCS.Network.PacketRequestUpdateBasicWorktable;
import Superfrogman98.NCS.Network.PacketUpdateBasicWorktable;
import Superfrogman98.NCS.Recipes.ModRecipes;
import Superfrogman98.NCS.World.ModWorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = NexCorpSolutions.modId, name = NexCorpSolutions.name, version = NexCorpSolutions.version, acceptedMinecraftVersions = "[1.10.2]")

public class NexCorpSolutions {

    public static final String modId = "nex_corp_solutions";
    public static final String name = "Nex Corp Solutions";
    public static final String version = "0.0.1";
    public static final NCS_Tab creativeTab = new NCS_Tab();
    public static SimpleNetworkWrapper network;

    //initialize proxy
    @SidedProxy(serverSide = "Superfrogman98.NCS.ServerProxy", clientSide = "Superfrogman98.NCS.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(modId)
    public static NexCorpSolutions instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event ) {
        System.out.println(name + " is loading!");
        proxy.preInit(event);
        ModBlocksCrops.init();
        ModItems.init();
        ModBlocks.init();
        GameRegistry.registerWorldGenerator(new ModWorldGen(),3);
        network = NetworkRegistry.INSTANCE.newSimpleChannel(modId);
        network.registerMessage(new PacketUpdateBasicWorktable.Handler(), PacketUpdateBasicWorktable.class, 0 , Side.CLIENT );
        network.registerMessage(new PacketRequestUpdateBasicWorktable.Handler(), PacketRequestUpdateBasicWorktable.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
        CustomToolClasses.init();
    }


}
