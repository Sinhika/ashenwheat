package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.loot.AshenwheatChestLootModifier;
import mod.akkamaddi.ashenwheat.loot.CobwebLootModifiers;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootModifierProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.concurrent.CompletableFuture;

public class AshenwheatLootModifierProvider extends SimpleLootModifierProvider
{
    public AshenwheatLootModifierProvider(PackOutput output,
                                          CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, Ashenwheat.MODID);
    }

    @Override protected void add(ResourceKey<LootTable> targetLootTable, ResourceKey<LootTable> customLootTable)
    {
        this.add(targetLootTable.location().getPath(),
                new AshenwheatChestLootModifier(getCondition(targetLootTable.location()), customLootTable));
    }

    /**
     * Call {@link #add} here, which will pass in the necessary information to write the jsons.
     */
    @Override protected void start()
    {
        this.add(BuiltInLootTables.ABANDONED_MINESHAFT, AshenwheatLootInjectorProvider.ABANDONED_MINESHAFT);
        this.add(BuiltInLootTables.DESERT_PYRAMID, AshenwheatLootInjectorProvider.DESERT_PYRAMID);
        this.add(BuiltInLootTables.IGLOO_CHEST, AshenwheatLootInjectorProvider.IGLOO_CHEST);
        this.add(BuiltInLootTables.JUNGLE_TEMPLE, AshenwheatLootInjectorProvider.JUNGLE_TEMPLE);
        this.add(BuiltInLootTables.SIMPLE_DUNGEON, AshenwheatLootInjectorProvider.SIMPLE_DUNGEON);
        AddStrongholdAliases(AshenwheatLootInjectorProvider.SIMPLE_DUNGEON);
        AddDungeonAliases(AshenwheatLootInjectorProvider.SIMPLE_DUNGEON);
        AddVillageHouseAliases(AshenwheatLootInjectorProvider.VILLAGE_HOUSE);
        this.add(BuiltInLootTables.BURIED_TREASURE, AshenwheatLootInjectorProvider.SIMPLE_DUNGEON);

        add("spider_eyes_from_cobweb", new CobwebLootModifiers.CobwebLootModifier(
                new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(
                                Blocks.COBWEB).build()
                }
        ));

    }
} // end class
