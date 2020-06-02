package mod.akkamaddi.ashenwheat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.ConfigHolder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
//        ModBlocks.BLOCKS.register(modEventBus);
//        ModItems.ITEMS.register(modEventBus);
//        ModTileEntities.TILE_ENTITIES.register(modEventBus);
        
        // Register Configs (Does not need to be after Deferred Registers)
        modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
       
    } // end ctor()
} // end class
