package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootInjectorSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class AshenwheatLootInjectorProvider extends SimpleLootInjectorSubProvider
{
    public static final ResourceKey<LootTable> SIMPLE_DUNGEON =
            getInjectionTableId(Ashenwheat.MODID, "simple_dungeon");
    public static final ResourceKey<LootTable> ABANDONED_MINESHAFT =
            getInjectionTableId(Ashenwheat.MODID, "abandoned_mineshaft");
    public static final ResourceKey<LootTable> DESERT_PYRAMID =
            getInjectionTableId(Ashenwheat.MODID, "desert_pyramid");
    public static final ResourceKey<LootTable> JUNGLE_TEMPLE =
            getInjectionTableId(Ashenwheat.MODID, "jungle_temple");
    public static final ResourceKey<LootTable> IGLOO_CHEST =
            getInjectionTableId(Ashenwheat.MODID, "igloo_chest");
    public static final ResourceKey<LootTable> VILLAGE_HOUSE =
            getInjectionTableId(Ashenwheat.MODID, "village_house");



    @Override public void generate(HolderLookup.Provider pRegistries,
                                   BiConsumer<ResourceKey<LootTable>, LootTable.Builder> pGenerator)
    {
        pGenerator.accept(SIMPLE_DUNGEON,LootTable.lootTable().withPool(
                createChestPool("simple_dungeon", 1, 1, 0.5F)
                        .add(LootItem.lootTableItem(ModItems.ash_seeds.get()).setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,6))))
                        .add(LootItem.lootTableItem(ModItems.ossid_seeds.get()).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_seeds.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.thunder_seeds.get()).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))));

        pGenerator.accept(ABANDONED_MINESHAFT, LootTable.lootTable()
                .withPool(createChestPool("abandoned_mineshaft", 1, 1, 0.75F)
                        .add(LootItem.lootTableItem(ModItems.ash_seeds.get()).setWeight(3)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,4))))
                        .add(LootItem.lootTableItem(ModItems.ossid_seeds.get()).setWeight(1)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_seeds.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(ModItems.thunder_seeds.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))));


        pGenerator.accept(DESERT_PYRAMID, LootTable.lootTable().withPool(
                createChestPool("desert_pyramid", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.scintilla_seeds.get()).setWeight(6)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,6))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_wheat_sheaf.get()).setWeight(16)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.ash_cookie.get()).setWeight(12)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6,16))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_cookie.get()).setWeight(12)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6,16))))));

        pGenerator.accept(IGLOO_CHEST, LootTable.lootTable().withPool(
                createChestPool("igloo_chest", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.ash_wheat_sheaf.get()).setWeight(9)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.ash_bread.get()).setWeight(14)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))));

        pGenerator.accept(JUNGLE_TEMPLE, LootTable.lootTable().withPool(
                createChestPool( "jungle_temple", 1, 1, 0.25F)
                        .add(LootItem.lootTableItem(ModItems.ash_seeds.get()).setWeight(20)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,8))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_seeds.get()).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.ossid_seeds.get()).setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,6))))
                        .add(LootItem.lootTableItem(ModItems.thunder_seeds.get()).setWeight(15)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,6))))));

        pGenerator.accept(VILLAGE_HOUSE, LootTable.lootTable().withPool(
                createChestPool("village_house", 1, 1, 0.50F)
                        .add(LootItem.lootTableItem(ModItems.ash_seeds.get()).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,6))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_seeds.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(ModItems.ossid_seeds.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.thunder_seeds.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.ash_wheat_sheaf.get()).setWeight(5)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2,4))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_wheat_sheaf.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,3))))
                        .add(LootItem.lootTableItem(ModItems.ash_cookie.get()).setWeight(4)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6,16))))
                        .add(LootItem.lootTableItem(ModItems.scintilla_cookie.get()).setWeight(2)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(6,16))))));

    } // end generate()
} // end class
