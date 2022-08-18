package mod.akkamaddi.ashenwheat.world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.akkamaddi.ashenwheat.Ashenwheat;

public class WorldGeneration
{
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(Ashenwheat.MODID + " Forge Event Subscriber");

//    public static void generateOverworldFeatures(BiomeLoadingEvent evt)
//    {
//        List<Biome.BiomeCategory> flax_biome_cats = 
//                List.of(Biome.BiomeCategory.PLAINS, Biome.BiomeCategory.RIVER, Biome.BiomeCategory.SAVANNA, Biome.BiomeCategory.SWAMP);
//        
//        // if nether biome
//        if (evt.getCategory() == Biome.BiomeCategory.NETHER)
//        {
//            if (AshenwheatConfig.GenerateBlazeTrees)
//            {
//                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.TREES_BLAZEWOOD.getHolder().get());
//            }
//        } // end-if NETHER
//        
//        // if a flax-friendly biome
//        if (flax_biome_cats.contains(evt.getCategory()))
//        {
//            if (AshenwheatConfig.GenerateFlax)
//            {
//                //LOGGER.debug("onBiomeLoading: attempt to addFeature PATCH_FLAX_COMMON" );
//                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_FLAX_COMMON.getHolder().get());
//            }           
//        } // end-if flax biomes
//        
//        // if any overworld biome
//        if ((evt.getCategory() != Biome.BiomeCategory.NETHER) && (evt.getCategory() != Biome.BiomeCategory.THEEND))
//        {
//            if (AshenwheatConfig.GenerateRottenPlants)
//            {
//                //LOGGER.debug("onBiomeLoading: attempt to addFeature PATCH_ROTTEN_PLANT_NORMAL" );
//                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.PATCH_ROTTEN_PLANT_NORMAL.getHolder().get());
//            }
//            if (AshenwheatConfig.GenerateBuriedRemains)
//            {
//                //LOGGER.debug("onBiomeLoading: attempt to addFeature BURIAL" );
//                evt.getGeneration().addFeature(Decoration.UNDERGROUND_ORES, ModFeatures.BURIAL.getHolder().get());
//            }
//        } // end-if any overworld
//        
//        // if any ocean
//        if (evt.getCategory() == Biome.BiomeCategory.OCEAN)
//        {
//            if (AshenwheatConfig.GenerateEnderClams)
//            {
//                // LOGGER.debug("onBiomeLoading: attempt to addFeature ENDER_CLAMS_ALL" );
//                evt.getGeneration().addFeature(Decoration.VEGETAL_DECORATION, ModFeatures.ENDER_CLAMS_OCEAN.getHolder().get());
//            }
//        } // end-if ocean
//    } // end generateOverworldFeatures
} // end class
