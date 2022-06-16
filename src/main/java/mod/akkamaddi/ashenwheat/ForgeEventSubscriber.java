package mod.akkamaddi.ashenwheat;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.loot.WheatInjectionLookup;
import mod.akkamaddi.ashenwheat.world.WorldGeneration;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both
 * PHYSICAL sides in this class
 */
@EventBusSubscriber(modid = Ashenwheat.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
    private static final WheatInjectionLookup lootLookupMap = new WheatInjectionLookup();

    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        if (AshenwheatConfig.EnablePeacefulPack) {
            WorldGeneration.generateOverworldFeatures(evt);
        }
    } // end onBiomeLoading()

    /**
     * add mods seeds to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (AshenwheatConfig.SeedsInChests) 
        {
            LootUtils.LootLoadHandler(Ashenwheat.MODID, event, lootLookupMap);
        } // end-if SeedsInChest
    } // end LootLoad()
    
} // end class
