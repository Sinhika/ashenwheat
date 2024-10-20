package mod.akkamaddi.ashenwheat.loot;

import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import mod.akkamaddi.ashenwheat.init.ModCodecs;
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
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class CobwebLootModifiers
{
    public static class CobwebLootModifier extends LootModifier
    {
        public static final MapCodec<CobwebLootModifier> CODEC =
               RecordCodecBuilder.mapCodec( inst -> LootModifier.codecStart(inst).apply(inst, CobwebLootModifier::new));

        public CobwebLootModifier(LootItemCondition[] conditionsIn)
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
            if (AshenwheatConfig.EnableSpiderEyeDrops)
            {
                if (context.getRandom().nextFloat() < AshenwheatConfig.SpiderEyeDropChance) 
                {
                    generatedLoot.add(new ItemStack(Items.SPIDER_EYE));
                }
            }
            return generatedLoot;
        }

        @Override
        public MapCodec<? extends IGlobalLootModifier> codec()
        {
            return ModCodecs.spider_eyes_from_cobweb.get();
        }
        
    } // end-class CobwebLootModifier
} // end class CobwebLootModifiers
