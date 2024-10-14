package mod.akkamaddi.ashenwheat;

import mod.akkamaddi.ashenwheat.config.AshenwheatClientConfig;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Ashenwheat.MODID)
public final class Ashenwheat
{
    public static final String MODID = "ashenwheat";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Ashenwheat(IEventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.debug("Hello from Ashenwheat");

        // Register Deferred Registers (Does not need to be before Configs)
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModFeatures.MOD_FEATURES.register(modEventBus);
        ModOtherRegistry.GLM.register(modEventBus);

        // register event listeners
        modEventBus.addListener(AshenwheatConfig::onLoad);
        modEventBus.addListener(AshenwheatClientConfig::onLoad);
        modEventBus.addListener(ModEventSubscriber::onCommonSetup);
        modEventBus.addListener(ModEventSubscriber::onRegisterItems);

        NeoForge.EVENT_BUS.addListener(ForgeEventSubscriber::onVillagerTrades);
        NeoForge.EVENT_BUS.addListener(ForgeEventSubscriber::onWandererTrades);

        // Register Configs (Does not need to be after Deferred Registers)
        modContainer.registerConfig(ModConfig.Type.CLIENT, AshenwheatClientConfig.SPEC);
        modContainer.registerConfig(ModConfig.Type.COMMON, AshenwheatConfig.SPEC);
        modContainer.registerConfig(ModConfig.Type.STARTUP, AshenwheatConfig.SPEC);

    } // end ctor()
} // end class
