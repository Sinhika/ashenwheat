package mod.akkamaddi.ashenwheat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.config.ConfigHelper;
import mod.akkamaddi.ashenwheat.config.ConfigHolder;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItemGroups;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * Subscribe to events from the MOD EventBus that should be handled on both PHYSICAL sides in this class
 *
 * @author Cadiboo
 */
@EventBusSubscriber(modid = Ashenwheat.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber 
{

	private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Mod Event Subscriber");

	/**
     * Everything should exist at this point, so configure as necessary.
     * @param event
     */
    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        ModBlocks.ash_wheat_crop.get().setFertility_factor(25.0F/AshenwheatConfig.growthRateAshenWheat);
        ModBlocks.ossid_root_crop.get().setFertility_factor(25.0F/AshenwheatConfig.growthRateOssidRoot);
        ModBlocks.scintilla_wheat_crop.get().setFertility_factor(25.0F/AshenwheatConfig.growthRateScintillaWheat);
        ModBlocks.thunder_grass_crop.get().setFertility_factor(25.0F/AshenwheatConfig.growthRateThunderGrass);
        ModBlocks.thunder_grass_crop.get().setMin_f(AshenwheatConfig.neighborFactorThunderGrass);
        LOGGER.debug("Common setup done");
    } // end onCommonSetup

	/**
	 * This method will be called by Forge when it is time for the mod to register its Items.
	 * This method will always be called after the Block registry method.
	 */
    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) 
    {
        if (event.getRegistryKey() == Registry.ITEM_REGISTRY)
        {
         // Automatically register BlockItems for all our Blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                // You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
                .filter(block -> needsItemBlock(block))
                // Register the BlockItem for the block
                .forEach(block -> {
                    // Make the properties, and make it so that the item will be on our ItemGroup (CreativeTab)
                    final Item.Properties properties = new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP);
                    // Create the new BlockItem with the block and it's properties
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Register the BlockItem
                    event.register(Registry.ITEM_REGISTRY,  helper -> {
                        helper.register(ForgeRegistries.BLOCKS.getKey(block), blockItem);
                    });
                });
        LOGGER.debug("Registered BlockItems");
        }
    }

    private static boolean needsItemBlock(Block block)
    {
        if (block == ModBlocks.ash_wheat_bale.get()) {
            return false;
        }
        else if (block instanceof ModCropsBlock) {
            return false;
        }
        return true;
    }

	/**
	 * This method will be called by Forge when a config changes.
	 */
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfigEvent event) 
	{
		final ModConfig config = event.getConfig();
		// Rebake the configs when they change
		if (config.getSpec() == ConfigHolder.CLIENT_SPEC) 
		{
			ConfigHelper.bakeClient(config);
			LOGGER.debug("Baked client config");
		} 
		else if (config.getSpec() == ConfigHolder.SERVER_SPEC) 
		{
			ConfigHelper.bakeServer(config);
			LOGGER.debug("Baked server config");
		}
	} // end onModConfigEvent()

} // end class
