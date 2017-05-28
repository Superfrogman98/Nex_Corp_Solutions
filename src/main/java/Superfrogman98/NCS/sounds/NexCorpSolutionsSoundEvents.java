package Superfrogman98.NCS.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * Created by Superfrogman98 on 5/27/2017.
 * registers soundevents for the mod
 */
public class NexCorpSolutionsSoundEvents {

    public static final SoundEvent himTheme = getRegisteredSoundEvent("nex_corp_solutions:music.how_its_made");


    private static SoundEvent getRegisteredSoundEvent(String name) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(name));
    }

    private NexCorpSolutionsSoundEvents(){}


}
