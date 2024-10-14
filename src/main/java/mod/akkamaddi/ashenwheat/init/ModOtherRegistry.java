package mod.akkamaddi.ashenwheat.init;

import com.mojang.serialization.Codec;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.loot.CobwebLootModifiers.CobwebLootModifier;
import mod.akkamaddi.ashenwheat.loot.GrassLootModifiers.GrassLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

/**
 * This is where we put other registries that don't fit under the usual categories.
 * @author Sinhika
 *
 */
public final class ModOtherRegistry
{
    
    // GlobalLootModifiers registry
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = 
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Ashenwheat.MODID);
    
    public static final RegistryObject<Codec<GrassLootModifier>> seeds_from_grass = 
            GLM.register( "seeds_from_grass", GrassLootModifier.CODEC);
            
    public static final RegistryObject<Codec<CobwebLootModifier>> spider_eyes_from_cobweb =
            GLM.register( "spider_eyes_from_cobweb", CobwebLootModifier.CODEC);
    
} // end class
