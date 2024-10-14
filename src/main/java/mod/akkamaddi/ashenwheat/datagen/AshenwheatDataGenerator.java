package mod.akkamaddi.ashenwheat.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.alexndr.simplecorelib.api.datagen.SimpleLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid=Ashenwheat.MODID, bus=EventBusSubscriber.Bus.MOD)
public class AshenwheatDataGenerator
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();		
        
        // server datagen
        AshenwheatBlockTags blockTags = new AshenwheatBlockTags(packOutput, lookupProvider, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new AshenwheatItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), 
        		existingFileHelper));
        gen.addProvider(event.includeServer(), new SimpleLootTableProvider(packOutput, List.of(
        		new LootTableProvider.SubProviderEntry(AshenwheatLootSubProvider::new, LootContextParamSets.BLOCK))));
        
        gen.addProvider(event.includeServer(), new AshenwheatRecipes(packOutput));

        // client datagen
        gen.addProvider(event.includeClient(), new AshenwheatBlockStateProvider(packOutput, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new AshenwheatItemModelProvider(packOutput, event.getExistingFileHelper()));
    } // end gatherData()

} // end class
