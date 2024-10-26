package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class AshenwheatDataMapProvider extends DataMapProvider
{
    Builder<Compostable, Item> compostables = this.builder(NeoForgeDataMaps.COMPOSTABLES);

    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    protected AshenwheatDataMapProvider(PackOutput packOutput,
                                        CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(packOutput, lookupProvider);
    }

    /**
     * Generate data map entries.
     */
    @Override protected void gather()
    {
        addCompost(ModItems.ash_bread.get(), 0.85F);
        addCompost(ModItems.ash_seeds.get(), 0.3F);
        addCompost(ModItems.ash_cookie.get(), 0.85F);
        addCompost(ModItems.ash_wheat_bale.get(), 0.85F);
        addCompost(ModItems.ash_wheat_sheaf.get(), 0.65F);
        addCompost(ModItems.scintilla_seeds.get(), 0.3F);
        addCompost(ModItems.scintilla_wheat_sheaf.get(), 0.65F);
        addCompost(ModItems.scintilla_bread.get(), 0.85F);
        addCompost(ModItems.scintilla_cookie.get(), 0.85F);
        addCompost(ModItems.ossid_seeds.get(), 0.3F);
        addCompost(ModItems.thunder_seeds.get(), 0.3F);
        addCompost(ModItems.flax_seed.get(), 0.3F);
        addCompost(ModItems.rotten_seeds.get(), 0.3F);
        addCompost(ModBlocks.scintilla_wheat_bale.get(), 0.85F);
        addCompost(ModBlocks.ossid_root.get(), 0.65F);
        addCompost(ModBlocks.carved_ossid_root.get(), 0.65F);
        addCompost(ModBlocks.blaze_leaves.get(), 0.3F);
        addCompost(ModBlocks.blaze_sapling.get(), 0.3F);

    } // end gather()

    protected void addCompost(ItemLike item, float chance)
    {
        compostables.add(item.asItem().builtInRegistryHolder(), new Compostable(chance), false);
    }
} // end class
