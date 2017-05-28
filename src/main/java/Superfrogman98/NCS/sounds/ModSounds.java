package Superfrogman98.NCS.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Superfrogman98 on 5/27/2017.
 * registers sounds for the mod
 */
public class ModSounds {

    public static void init(){
        String [] sounds = {
                "nex_corp_solutions:music.how_its_made"
        };

        for (String s : sounds) {
            ResourceLocation loc = new ResourceLocation(s);
            GameRegistry.register(new SoundEvent(loc), loc);
        }

    }
    private ModSounds(){}


}
