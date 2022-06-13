package mod.akkamaddi.ashenwheat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModFeatures;
import mod.akkamaddi.ashenwheat.loot.WheatInjectionLookup;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
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
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Forge Event Subscriber");
    private static final WheatInjectionLookup lootLookupMap = new WheatInjectionLookup();

    /**
     * Biome loading triggers ore generation.
     */
    @SubscribeEvent(priority=EventPriority.HIGH)
    public static void onBiomeLoading(BiomeLoadingEvent evt)
    {
        List<Biome.BiomeCategory> flax_biome_cats = 
                List.of(Biome.BiomeCategory.PLAINS, Biome.BiomeCategory.RIVER, Biome.BiomeCategory.SAVANNA, Biome.BiomeCategory.SWAMP);
        
        if (evt.getCategory() == Biome.BiomeCategory.NETHER)
        {
            if (AshenwheatConfig.EnablePeacefulPack && AshenwheatConfig.GenerateBlazeTrees)
            {
                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.TREES_BLAZEWOOD.getHolder().get());
            }
        } // end NETHER
        else if (flax_biome_cats.contains(evt.getCategory()))
        {
            if (AshenwheatConfig.EnablePeacefulPack && AshenwheatConfig.GenerateFlax)
            {
                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_FLAX_COMMON.getHolder().get());
            }           
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
