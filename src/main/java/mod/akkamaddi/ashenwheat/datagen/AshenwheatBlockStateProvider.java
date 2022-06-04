package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatBlockStateProvider extends SimpleBlockStateProvider
{

    public AshenwheatBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, Ashenwheat.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // simple models
        ModelFile buriedRemainsModel = this.models().cubeAll("buried_remains", 
                                            new ResourceLocation(Ashenwheat.MODID, "block/remains"));
        this.itemModels().withExistingParent("buried_remains", new ResourceLocation(Ashenwheat.MODID, "block/buried_remains"));
        this.simpleBlock(ModBlocks.buried_remains.get(), new ConfiguredModel(buriedRemainsModel));
        
        registerTreeBlocks();
        registerCropBlocks();
    } // end registerStatesAndModels

    // TODO tree blocks
    private void registerTreeBlocks()
    {
        
    } // end registerTreeBlocks
    
    // TODO crop blocks
    private void registerCropBlocks()
    {
        
    } // end registerCropBlocks
    
} // end class
