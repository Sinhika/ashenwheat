package mod.akkamaddi.ashenwheat.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModCodecs;
import mod.alexndr.simplecorelib.api.loot.AbstractChestLootModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class AshenwheatChestLootModifier extends AbstractChestLootModifier
{

    public static final MapCodec<AshenwheatChestLootModifier> CODEC =
            RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst)
                    .and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable")
                            .forGetter((m) -> m.lootTable))
                    .apply(inst, AshenwheatChestLootModifier::new));


    public AshenwheatChestLootModifier(LootItemCondition[] conditionsIn,
                                       ResourceKey<LootTable> lootTable)
    {
        super(conditionsIn, lootTable);
    }

    @Override protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot,
                                                                    LootContext context)
    {
        if (AshenwheatConfig.SeedsInChests)
        {
            return super.doApply(generatedLoot, context);
        }
        else {
            return generatedLoot;
        }
    } // end doApply()

    @Override public @NotNull MapCodec<? extends IGlobalLootModifier> codec()
    {
        return ModCodecs.CHEST_LOOT.get();
    }
} // end class
