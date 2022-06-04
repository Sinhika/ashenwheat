package mod.akkamaddi.ashenwheat.datagen;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.mojang.datafixers.util.Pair;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.BlockLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

public class AshenwheatLootTableProvider extends BlockLootTableProvider
{

    public AshenwheatLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables()
    {
        tables.clear();
        specialDropTable(ModBlocks.buried_remains.get(), Items.ROTTEN_FLESH);
        return tables;
    }

} // end class
