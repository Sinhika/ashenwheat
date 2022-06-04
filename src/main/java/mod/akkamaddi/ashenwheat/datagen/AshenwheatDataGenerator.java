package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid=Ashenwheat.MODID, bus=EventBusSubscriber.Bus.MOD)
public class AshenwheatDataGenerator
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer())
        {
            gen.addProvider(new AshenwheatBlockTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new AshenwheatItemTags(gen, event.getExistingFileHelper()));
            gen.addProvider(new AshenwheatLootTableProvider(gen));
            gen.addProvider(new AshenwheatRecipes(gen));
        }
        if (event.includeClient())
        {
            gen.addProvider(new AshenwheatBlockStateProvider(gen, event.getExistingFileHelper()));
            gen.addProvider(new AshenwheatItemModelProvider(gen, event.getExistingFileHelper()));
        }
    } // end gatherData()

} // end class
