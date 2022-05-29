package mod.akkamaddi.ashenwheat.loot;

import java.util.List;

import com.google.gson.JsonObject;

import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class CobwebLootModifiers
{
    public static class CobwebLootModifier extends LootModifier
    {
       
        protected CobwebLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        /**
         * if Peacefulpack is enabled and spider eyes are enabled, and rand < drop chance,
         * add spider eye to loot list.
         */
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context)
        {
            if (AshenwheatConfig.EnablePeacefulPack && AshenwheatConfig.EnableSpiderEyeDrops)
            {
                if (context.getRandom().nextFloat() < AshenwheatConfig.SpiderEyeDropChance) 
                {
                    generatedLoot.add(new ItemStack(Items.SPIDER_EYE));
                }
            }
            return generatedLoot;
        }
        
        public static class Serializer extends GlobalLootModifierSerializer<CobwebLootModifier>
        {

            // we don't really do anyting special here.
            @Override
            public CobwebLootModifier read(ResourceLocation location, JsonObject object,
                    LootItemCondition[] ailootcondition)
            {
                return new CobwebLootModifier(ailootcondition);
            }

            // again, don't do anything special here.
            @Override
            public JsonObject write(CobwebLootModifier instance)
            {
                return makeConditions(instance.conditions);
            }
            
        } // end-class CobwebLootModifier$Serializer
    } // end-class CobwebLootModifier
} // end class CobwebLootModifiers
