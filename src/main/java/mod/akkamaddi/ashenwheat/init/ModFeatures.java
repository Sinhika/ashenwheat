package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.world.ShallowGraveFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    
    /** FEATURES REGISTRY */
    public static final DeferredRegister<Feature<?>> MOD_FEATURES =
            DeferredRegister.create(Registries.FEATURE, Ashenwheat.MODID);
            
    public static RegistryObject<Feature<CountConfiguration>> SHALLOW_GRAVE_FEATURE =
            MOD_FEATURES.register("shallow_grave_feature", ()->new ShallowGraveFeature(CountConfiguration.CODEC));
    
     /** CONFIGURED_FEATURES REGISTERY */
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> MOD_CONFIGURED_FEATURES = 
//    		DeferredRegister.create(Registries.CONFIGURED_FEATURE, Ashenwheat.MODID);
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLAZE_TREE = 
    		ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Ashenwheat.MODID, "blaze_tree"));    
 
} // end class
