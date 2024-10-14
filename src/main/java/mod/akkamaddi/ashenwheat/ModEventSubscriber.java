package mod.akkamaddi.ashenwheat;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Subscribe to events from the MOD EventBus that should be handled on both PHYSICAL sides in this class
 *
 * @author Cadiboo
 */
public final class ModEventSubscriber
{

	private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Mod Event Subscriber");

	/**
     * Everything should exist at this point, so configure as necessary.
     * @param event
     */
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
    public static void onRegisterItems(final RegisterEvent event)
    {
		event.register(Registries.ITEM,  helper ->
		{
			// Automatically register BlockItems for all our Blocks
			ModBlocks.BLOCKS.getEntries().stream()
					.map(DeferredHolder::get)
					// You can do extra filtering here if you don't want some blocks to have an BlockItem automatically registered for them
					.filter(block -> needsItemBlock(block))
					// Register the BlockItem for the block
					.forEach(block -> {
						// Create the new BlockItem with the block and it's properties
						// Register the BlockItem
						helper.register(BuiltInRegistries.BLOCK.getKey(block),
								new BlockItem(block, new Item.Properties()));
					});
			LOGGER.debug("Registered BlockItems");

			// now register DoubleHigh blocks Items.
			ModBlocks.BLOCKS.getEntries().stream()
					.map(DeferredHolder::get)
					// You can do extra filtering here if you don't want some blocks to have an BlockItem
					// automatically registered for them
					.filter(block -> needsDoubleHighBlock(block))
					// Register the BlockItem for the block
					.forEach(block ->
					{
						helper.register(BuiltInRegistries.BLOCK.getKey(block),
								new DoubleHighBlockItem(block, new Item.Properties()));
					});
			LOGGER.debug("Registered doublehighblockitems");
		});
    } // end onRegisterItems

    private static boolean needsItemBlock(Block block)
    {
        if (block == ModBlocks.ash_wheat_bale.get()) {
            return false;
        }
        else if (block instanceof ModCropsBlock) {
            return false;
        }
		else if (block instanceof DoorBlock) {
			return false;
		}
        return true;
    }

	private static boolean needsDoubleHighBlock(Block block)
	{
		return (block instanceof DoorBlock);
	}

} // end class
