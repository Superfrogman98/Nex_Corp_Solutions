package Superfrogman98.NCS;

/**
 * Created by Superfrogman98 on 5/20/2017.
 */

import Superfrogman98.NCS.gui.basic_worktable.GuiProxyBasicWorktable;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import static Superfrogman98.NCS.NexCorpSolutions.instance;

public class CommonProxy {


    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiProxyBasicWorktable());

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void registerRenderers(){

    }


}
