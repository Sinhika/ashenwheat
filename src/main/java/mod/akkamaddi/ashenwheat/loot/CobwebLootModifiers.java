package mod.akkamaddi.ashenwheat.loot;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class CobwebLootModifiers
{
    public static class CobwebLootModifier extends LootModifier
    {
        public static final Supplier<Codec<CobwebLootModifier>> CODEC =
                Suppliers.memoize(() -> RecordCodecBuilder.create( inst -> codecStart(inst).apply(inst, CobwebLootModifier::new)));
                        
        protected CobwebLootModifier(LootItemCondition[] conditionsIn)
        {
            super(conditionsIn);
        }

        /**
         * if Peacefulpack is enabled and spider eyes are enabled, and rand < drop chance,
         * add spider eye to loot list.
         */
        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
                LootContext context)
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

        @Override
        public Codec<? extends IGlobalLootModifier> codec()
        {
            return CODEC.get();
        }
        
    } // end-class CobwebLootModifier
} // end class CobwebLootModifiers
