package mod.akkamaddi.ashenwheat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.ConfigHolder;
import mod.akkamaddi.ashenwheat.init.CreativeTabs;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModFeatures;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.akkamaddi.ashenwheat.init.ModOtherRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ashenwheat.MODID)
public final class Ashenwheat
{
    public static final String MODID = "ashenwheat";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Ashenwheat()
    {
        LOGGER.debug("Hello from Ashenwheat");

        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Deferred Registers (Does not need to be before Configs)
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModFeatures.MOD_FEATURES.register(modEventBus);
        ModOtherRegistry.GLM.register(modEventBus);
        
        // Register Configs (Does not need to be after Deferred Registers)
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.SERVER_SPEC);
       
    } // end ctor()
} // end class
