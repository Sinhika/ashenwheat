package mod.akkamaddi.ashenwheat.config;

import net.minecraftforge.fml.config.ModConfig;

/**
 * This bakes the config values to normal fields
 *
 * @author Cadiboo
 * It can be merged into the main ExampleModConfig class, but is separate because of personal preference and to keep the code organised
 */
public final class ConfigHelper 
{

	public static void bakeClient(final ModConfig config) 
	{
	    AshenwheatConfig.MakeAshenwheatFlame = ConfigHolder.CLIENT.clientMakeAshenwheatFlame.get();
	    AshenwheatConfig.MakeAshenBalesFlame = ConfigHolder.CLIENT.clientMakeAshenBalesFlame.get();
	    AshenwheatConfig.MakeOssidCropGloom = ConfigHolder.CLIENT.clientMakeOssidCropGloom.get();
	    AshenwheatConfig.MakeOssidLanternGloom = ConfigHolder.CLIENT.clientMakeOssidLanternGloom.get();
	    AshenwheatConfig.MakeScintillaBalesScintillate = ConfigHolder.CLIENT.clientMakeScintillaBalesScintillate.get();
	    AshenwheatConfig.MakeScintillawheatScintillate = ConfigHolder.CLIENT.clientMakeScintillawheatScintillate.get();
	    AshenwheatConfig.MakeScintillationsSmaller = ConfigHolder.CLIENT.clientMakeScintillationsSmaller.get();
	    AshenwheatConfig.MakeThunderGrassSmoke = ConfigHolder.CLIENT.clientMakeThunderGrassSmoke.get();
	    AshenwheatConfig.MakeThunderGrassSmokeSmaller = ConfigHolder.CLIENT.clientMakeThunderGrassSmokeSmaller.get();
	}

	public static void bakeServer(final ModConfig config) 
	{
	    AshenwheatConfig.SeedsInChests = ConfigHolder.SERVER.serverSeedsInChests.get();
	    AshenwheatConfig.DropAshSeeds = ConfigHolder.SERVER.serverDropAshSeeds.get();
	    AshenwheatConfig.DropOssidSeeds = ConfigHolder.SERVER.serverDropOssidSeeds.get();
	    AshenwheatConfig.DropScintillaSeeds = ConfigHolder.SERVER.serverDropScintillaSeeds.get();
	    AshenwheatConfig.DropThunderSeeds = ConfigHolder.SERVER.serverDropThunderSeeds.get();
	    
	    AshenwheatConfig.relWeightWheatSeeds = ConfigHolder.SERVER.server_relWeightWheatSeeds.get();
	    AshenwheatConfig.relWeightAshSeeds = ConfigHolder.SERVER.server_relWeightAshSeeds.get();
	    AshenwheatConfig.relWeightScintillaSeeds = ConfigHolder.SERVER.server_relWeightScintillaSeeds.get();
	    AshenwheatConfig.relWeightOssidSeeds = ConfigHolder.SERVER.server_relWeightOssidSeeds.get();
	    AshenwheatConfig.relWeightThunderSeeds = ConfigHolder.SERVER.server_relWeightThunderSeeds.get();
        AshenwheatConfig.relWeightFlaxSeeds = ConfigHolder.SERVER.server_relWeightFlaxSeeds.get();
        AshenwheatConfig.relWeightRottenSeed = ConfigHolder.SERVER.server_relWeightRottenSeeds.get();
	    AshenwheatConfig.growthRateAshenWheat = ConfigHolder.SERVER.serverGrowthRateAshenWheat.get().floatValue();
	    AshenwheatConfig.growthRateScintillaWheat = ConfigHolder.SERVER.serverGrowthRateScintillaWheat.get().floatValue();
	    AshenwheatConfig.growthRateOssidRoot = ConfigHolder.SERVER.serverGrowthRateOssidRoot.get().floatValue();
	    AshenwheatConfig.growthRateThunderGrass = ConfigHolder.SERVER.serverGrowthRateThunderGrass.get().floatValue();
	    AshenwheatConfig.neighborFactorThunderGrass = ConfigHolder.SERVER.serverNeighborFactorThunderGrass.get().floatValue();
	    
	    AshenwheatConfig.EnablePeacefulPack = ConfigHolder.SERVER.serverEnablePeacefulPack.get();
	    AshenwheatConfig.GenerateBlazeTrees = ConfigHolder.SERVER.serverGenerateBlazeTrees.get();
	    AshenwheatConfig.DropFlaxSeed = ConfigHolder.SERVER.serverDropFlaxSeed.get();
	    AshenwheatConfig.GenerateFlax = ConfigHolder.SERVER.serverGenerateFlax.get();
	    AshenwheatConfig.DropRottenSeeds = ConfigHolder.SERVER.serverDropRottenSeeds.get();
	    AshenwheatConfig.GenerateRottenPlants = ConfigHolder.SERVER.serverGenerateRottenPlants.get();
	    AshenwheatConfig.GenerateEnderClams = ConfigHolder.SERVER.serverGenerateEnderClams.get();
        AshenwheatConfig.GenerateBuriedRemains = ConfigHolder.SERVER.serverGenerateBuriedRemains.get();
	    AshenwheatConfig.EnableSpiderEyeDrops = ConfigHolder.SERVER.serverEnableSpiderEyeDrops.get();
	    AshenwheatConfig.SpiderEyeDropChance = ConfigHolder.SERVER.serverSpiderEyeDropChance.get().floatValue();
	    
        AshenwheatConfig.INSTANCE.putFlag("flax_recipes_enabled", ConfigHolder.SERVER.serverEnableFlaxRecipes.get());
	} // end bakeServer()

} // end-class
