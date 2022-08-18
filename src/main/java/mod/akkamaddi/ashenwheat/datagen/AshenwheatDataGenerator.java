package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid=Ashenwheat.MODID, bus=EventBusSubscriber.Bus.MOD)
public class AshenwheatDataGenerator
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(event.includeServer(), new AshenwheatBlockTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new AshenwheatItemTags(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeServer(), new AshenwheatLootTableProvider(gen));
        gen.addProvider(event.includeServer(), new AshenwheatRecipes(gen));

        gen.addProvider(event.includeClient(), new AshenwheatBlockStateProvider(gen, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new AshenwheatItemModelProvider(gen, event.getExistingFileHelper()));
    } // end gatherData()

} // end class
