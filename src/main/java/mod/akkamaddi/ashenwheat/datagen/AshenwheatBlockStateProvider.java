package mod.akkamaddi.ashenwheat.datagen;

import java.util.ArrayList;
import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
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
        // simple models & blockstates
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
        // rotten plant/crop
        List<ModelFile> rp_models = new ArrayList<ModelFile>(2);
        for (int ii=0; ii < 2; ii ++)
        {
            rp_models.add(this.models().crop("rottenplant_0" + ii, new ResourceLocation(Ashenwheat.MODID, "block/rottenplant_0" + ii)));
        } // end-for
        this.getVariantBuilder(ModBlocks.rotten_crop.get())
                .partialState().with(RottenPlantBlock.AGE, 0).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.AGE, 1).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.AGE, 2).addModels(new ConfiguredModel(rp_models.get(1)));
        
        // TODO flax
    } // end registerCropBlocks
    
 
} // end class
