package Superfrogman98.NCS.configs;

import Superfrogman98.NCS.NexCorpSolutions;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ConfigNexCorpSolutions
{
    public static Configuration config;
    public static void init(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            config.load();

        }catch (Exception e)
        {
            System.out.println(NexCorpSolutions.MOD_NAME +" had a problem loading the config file");
        }
        finally
        {
            if (config.hasChanged())
            {
                config.save();
            }
        }
    }
}
