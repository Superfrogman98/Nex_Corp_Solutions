package Superfrogman98.NCS;

/*
 * Created by Superfrogman98 on 5/20/2017.
 * code that is run only on client
 */

import Superfrogman98.NCS.blocks.tile_entities.TESR_BasicWorktable;
import Superfrogman98.NCS.blocks.tile_entities.TileEntityBasicWorktable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(NexCorpSolutions.modId);

    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        registerRenderers();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(NexCorpSolutions.modId + ":" + id, "inventory"));
    }

    @Override
    public void registerRenderers(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBasicWorktable.class, new TESR_BasicWorktable());
    }

}
