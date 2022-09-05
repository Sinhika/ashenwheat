package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.world.ShallowGraveFeature;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
    
    /** FEATURES REGISTRY */
    public static final DeferredRegister<Feature<?>> MOD_FEATURES =
            DeferredRegister.create(Registry.FEATURE_REGISTRY, Ashenwheat.MODID);
            
    public static RegistryObject<Feature<CountConfiguration>> SHALLOW_GRAVE_FEATURE =
            MOD_FEATURES.register("shallow_grave_feature", ()->new ShallowGraveFeature(CountConfiguration.CODEC));
    
            
 
} // end class
