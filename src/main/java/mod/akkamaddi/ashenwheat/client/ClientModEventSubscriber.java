package mod.akkamaddi.ashenwheat.client;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Subscribe to events from the MOD EventBus that should be handled on the PHYSICAL CLIENT side in this class
 *
 * @author Cadiboo
 */
@EventBusSubscriber(modid=Ashenwheat.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEventSubscriber
{
    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event) 
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ash_wheat_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.scintilla_wheat_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ossid_root_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.thunder_grass_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.rotten_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.flax_crop.get(), 
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.blaze_leaves.get(),
                (layer) -> layer == RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.blaze_sapling.get(),
                (layer) -> layer == RenderType.cutoutMipped());
    } // end onFMLClientSetupEvent()
    
} // end class
