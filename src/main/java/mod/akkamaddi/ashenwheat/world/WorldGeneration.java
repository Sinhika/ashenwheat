package mod.akkamaddi.ashenwheat.world;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldGeneration
{
    private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Forge Event Subscriber");

    public static void generateOverworldFeatures(BiomeLoadingEvent evt)
    {
        List<Biome.BiomeCategory> flax_biome_cats = 
                List.of(Biome.BiomeCategory.PLAINS, Biome.BiomeCategory.RIVER, Biome.BiomeCategory.SAVANNA, Biome.BiomeCategory.SWAMP);
        
        if (evt.getCategory() == Biome.BiomeCategory.NETHER)
        {
            if (AshenwheatConfig.GenerateBlazeTrees)
            {
                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.TREES_BLAZEWOOD.getHolder().get());
            }
        } // end-if NETHER
        if (flax_biome_cats.contains(evt.getCategory()))
        {
            if (AshenwheatConfig.GenerateFlax)
            {
                LOGGER.debug("onBiomeLoading: attempt to addFeature PATCH_FLAX_COMMON" );
                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_FLAX_COMMON.getHolder().get());
            }           
        } // end-if flax biomes
        if ((evt.getCategory() != Biome.BiomeCategory.NETHER) && (evt.getCategory() != Biome.BiomeCategory.THEEND))
        {
            if (AshenwheatConfig.GenerateRottenPlants)
            {
                LOGGER.debug("onBiomeLoading: attempt to addFeature PATCH_ROTTEN_PLANT_NORMAL" );
                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_ROTTEN_PLANT_NORMAL.getHolder().get());
            }
            if (AshenwheatConfig.GenerateBuriedRemains)
            {
                LOGGER.debug("onBiomeLoading: attempt to addFeature BURIAL" );
                evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.BURIAL.getHolder().get());
            }
        } // end-if any overworld
        
    } // end generateOverworldFeatures
} // end class
