package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.loot.CobwebLootModifiers;
import mod.akkamaddi.ashenwheat.loot.GrassLootModifiers;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * This is where we put other registries that don't fit under the usual categories.
 * @author Sinhika
 *
 */
public final class ModOtherRegistry
{
    
    // GlobalLootModifiers registry
    public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_SERIALIZERS = 
            DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS.get(), Ashenwheat.MODID);
    
    public static final RegistryObject<GlobalLootModifierSerializer<?>> seeds_from_grass = 
            LOOT_SERIALIZERS.register( "seeds_from_grass", () -> new GrassLootModifiers.GrassLootModifier.Serializer());
            
    public static final RegistryObject<GlobalLootModifierSerializer<?>> spider_eyes_from_cobweb =
            LOOT_SERIALIZERS.register( "spider_eyes_from_cobweb", () -> new CobwebLootModifiers.CobwebLootModifier.Serializer());
    
} // end class
