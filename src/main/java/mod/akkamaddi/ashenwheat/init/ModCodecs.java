package mod.akkamaddi.ashenwheat.init;

import com.mojang.serialization.MapCodec;
import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.loot.AshenwheatChestLootModifier;
import mod.akkamaddi.ashenwheat.loot.CobwebLootModifiers.CobwebLootModifier;
import mod.akkamaddi.ashenwheat.loot.GrassLootModifiers.GrassLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

/**
 * This is where we put other registries that don't fit under the usual categories.
 * @author Sinhika
 *
 */
public final class ModCodecs
{
    
    // GlobalLootModifiers registry
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Ashenwheat.MODID);
    
    public static final Supplier<MapCodec<GrassLootModifier>> seeds_from_grass =
            GLM.register( "seeds_from_grass", () -> GrassLootModifier.CODEC);
            
    public static final Supplier<MapCodec<CobwebLootModifier>> spider_eyes_from_cobweb =
            GLM.register( "spider_eyes_from_cobweb", () -> CobwebLootModifier.CODEC);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> CHEST_LOOT
            = GLM.register("chest_loot", () -> AshenwheatChestLootModifier.CODEC);
    
} // end class
