package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.world.ShallowGraveFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.function.Supplier;

public class ModFeatures
{
    
    /** FEATURES REGISTRY */
    public static final DeferredRegister<Feature<?>> MOD_FEATURES =
            DeferredRegister.create(Registries.FEATURE, Ashenwheat.MODID);
            
    public static Supplier<Feature<CountConfiguration>> SHALLOW_GRAVE_FEATURE =
            MOD_FEATURES.register("shallow_grave_feature", ()->new ShallowGraveFeature(CountConfiguration.CODEC));
    
     /** CONFIGURED_FEATURES REGISTERY */
//    public static final DeferredRegister<ConfiguredFeature<?, ?>> MOD_CONFIGURED_FEATURES = 
//    		DeferredRegister.create(Registries.CONFIGURED_FEATURE, Ashenwheat.MODID);
    
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLAZE_TREE = 
    		ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Ashenwheat.MODID, "blaze_tree"));    


    public static TreeGrower BLAZE_TREE_GROWER =
            new TreeGrower("blaze_tree", Optional.empty(), Optional.of(ModFeatures.BLAZE_TREE), Optional.empty());
} // end class
