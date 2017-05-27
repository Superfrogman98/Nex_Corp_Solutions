package Superfrogman98.NCS.Items.Records;

import Superfrogman98.NCS.Items.ItemModelProvider;
import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nonnull;

/**
 * Created by Superfrogman98 on 5/27/2017.
 * registers custom records for the mod
 */
public class ItemModRecord extends ItemRecord implements ItemModelProvider {
    private final String file;
    protected String name;

    public ItemModRecord(String record, SoundEvent sound, String name){
        super(record, sound);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(NexCorpSolutions.creativeTab);
        file = "nex_corp_solutions:music." + record;
    }

    @Override
    public  void registerItemModel(Item item){
        NexCorpSolutions.proxy.registerItemRenderer(item,0,name);
    }

    @Nonnull
    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation(file);
    }

}
