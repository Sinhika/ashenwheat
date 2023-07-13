package mod.akkamaddi.ashenwheat.datagen;

import java.util.ArrayList;
import java.util.List;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.RottenPlantBlock;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.alexndr.simplecorelib.api.datagen.SimpleBlockStateProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatBlockStateProvider extends SimpleBlockStateProvider
{

    public AshenwheatBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Ashenwheat.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        // simple models & blockstates
        ModelFile buriedRemainsModel = this.models().cubeAll("buried_remains", modLoc("block/remains"));
        this.itemModels().withExistingParent("buried_remains", modLoc("block/buried_remains"));
        this.simpleBlock(ModBlocks.buried_remains.get(), new ConfiguredModel(buriedRemainsModel));
        
        registerTreeBlocks();
        registerCropBlocks();
        registerMisc();
    } // end registerStatesAndModels

    // tree blocks
    private void registerTreeBlocks()
    {
        // blaze_leaves
        ModelFile leaves = this.models().cubeAll("blaze_leaves", modLoc("block/blaze_leaves")).renderType("cutout_mipped");
        this.simpleBlock(ModBlocks.blaze_leaves.get(), leaves);
        this.itemModels().withExistingParent("blaze_leaves", modLoc("block/blaze_leaves"));

        // blaze log
        this.logBlock(ModBlocks.blaze_log.get());
        this.itemModels().withExistingParent("blaze_log", modLoc("block/blaze_log"));
        
        // blaze_wood - a block covered in bark on all sides.
        this.axisBlock(ModBlocks.blaze_wood.get(), modLoc("block/blaze_log"), modLoc("block/blaze_log"));
        this.itemModels().withExistingParent("blaze_wood", modLoc("block/blaze_wood"));
       
        // stripped_blaze_log - a log with no bark.
        this.logBlock(ModBlocks.stripped_blaze_log.get());
        this.itemModels().withExistingParent("stripped_blaze_log", modLoc("block/stripped_blaze_log"));
        
        // stripped_blaze_wood 
        this.axisBlock(ModBlocks.stripped_blaze_wood.get(), modLoc("block/stripped_blaze_log"), modLoc("block/stripped_blaze_log"));
        this.itemModels().withExistingParent("stripped_blaze_wood", modLoc("block/stripped_blaze_wood"));
        
        // blaze_planks
        ModelFile planks = this.models().cubeAll("blazewood_planks", modLoc("block/blaze_planks"));
        this.simpleBlock(ModBlocks.blazewood_planks.get(), planks);
        this.itemModels().withExistingParent("blazewood_planks", modLoc("block/blazewood_planks"));
        
        // blaze_sapling
        ModelFile sapling = this.models().cross("blaze_sapling", modLoc("block/blaze_sapling")).renderType("cutout_mipped");
        this.simpleBlock(ModBlocks.blaze_sapling.get(), sapling);
        // sapling item model handled elsewhere.
        
        // blazewood_pressure_plate
        ModelFile blazewoodPlateModel = this.models().pressurePlate("blazewood_pressure_plate",
                modLoc("block/blaze_planks"));
        ModelFile blazewoodPlateModel_down = this.models().pressurePlateDown("blazewood_pressure_plate_down",
                modLoc("block/blaze_planks"));
        this.buildWeightedPressurePlateBlockState(ModBlocks.blazewood_pressure_plate.get(), 
                blazewoodPlateModel, blazewoodPlateModel_down);
        this.itemModels().withExistingParent("blazewood_pressure_plate", modLoc("block/blazewood_pressure_plate"));
        
        // blazewood_slab
        this.slabBlock(ModBlocks.blazewood_slab.get(), modLoc("block/blazewood_planks"), modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_slab", modLoc("block/blazewood_slab"));
        
        // blazewood_stairs
        this.stairsBlock(ModBlocks.blazewood_stairs.get(), modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_stairs", modLoc("block/blazewood_stairs"));
        
        // blazewood_button
        ModelFile blazewood_button_model = this.models().button("blazewood_button", modLoc("block/blaze_planks"));
        ModelFile blazewood_button_pressed = this.models().buttonPressed("blazewood_button_pressed", modLoc("block/blaze_planks"));
        this.buttonBlock(ModBlocks.blazewood_button.get(), blazewood_button_model, blazewood_button_pressed);
        this.models().buttonInventory("blazewood_button_inventory", modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_button", modLoc("block/blazewood_button_inventory"));
        
        // blazewood_fence
        this.fenceBlock(ModBlocks.blazewood_fence.get(), modLoc("block/blaze_planks"));
        this.models().fenceInventory("blazewood_fence_inventory", modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_fence", modLoc("block/blazewood_fence_inventory"));
        
        
        // blazewood_fence_gate
        this.fenceGateBlock(ModBlocks.blazewood_fence_gate.get(), modLoc("block/blaze_planks"));
        this.itemModels().withExistingParent("blazewood_fence_gate", modLoc("block/blazewood_fence_gate"));
        
    } // end registerTreeBlocks
    
    // Ender clam
    private void registerMisc()
    {
        ModelFile enderclam_model = this.models().orientableWithBottom("ender_clam", 
                modLoc("block/ender_clam_side"), 
                modLoc("block/ender_clam_front"), 
                modLoc("block/ender_clam_bottom"),
                modLoc("block/ender_clam_top"));
        this.horizontalBlock(ModBlocks.ender_clam.get(), enderclam_model);
        this.itemModels().withExistingParent("ender_clam", modLoc("block/ender_clam"));
    }
    
    // crop blocks
    private void registerCropBlocks()
    {
        // rotten plant/crop
        List<ModelFile> rp_models = new ArrayList<ModelFile>(2);
        for (int ii=0; ii < 2; ii ++)
        {
            rp_models.add(this.models().crop("rottenplant_0" + ii, modLoc("block/rottenplant_0" + ii)).renderType("cutout_mipped"));
        } // end-for
        this.getVariantBuilder(ModBlocks.rotten_crop.get())
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 0).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 1).addModels(new ConfiguredModel(rp_models.get(0)))
                .partialState().with(RottenPlantBlock.ROTTEN_AGE, 2).addModels(new ConfiguredModel(rp_models.get(1)));
        
        // flax
        List<ModelFile> flax_models = new ArrayList<ModelFile>(3);
        for (int ii=0; ii < 3; ii++)
        {
            flax_models.add(this.models().crop("flax_0" + ii, modLoc("block/flax_0" + ii)).renderType("cutout_mipped"));
        } // end-for
        this.getVariantBuilder(ModBlocks.flax_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(flax_models.get(0)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(flax_models.get(1)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(flax_models.get(2)));

        // ashenwheat
        List<ModelFile> ashwheat_models = new ArrayList<ModelFile>(8);
        for (int ii=0; ii<8; ii++)
        {
            ashwheat_models.add(this.models().crop("ashwheatcrop_0" + ii, 
                                                    modLoc("block/ashwheatcrop_0" + ii)).renderType("cutout_mipped"));
        } // end-for 
        this.getVariantBuilder(ModBlocks.ash_wheat_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(ashwheat_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(ashwheat_models.get(1)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(ashwheat_models.get(2)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(ashwheat_models.get(3)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(ashwheat_models.get(4)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(ashwheat_models.get(5)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(ashwheat_models.get(6)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(ashwheat_models.get(7)));

        // scintilla wheat
        List<ModelFile> sw_models = new ArrayList<ModelFile>(8);
        for (int ii=0; ii<8; ii++)
        {
            sw_models.add(this.models().crop("scintillawheatcrop_0" + ii, 
                                                    modLoc("block/scintillawheatcrop_0" + ii)).renderType("cutout_mipped"));
        } // end-for 
        this.getVariantBuilder(ModBlocks.scintilla_wheat_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(sw_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(sw_models.get(1)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(sw_models.get(2)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(sw_models.get(3)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(sw_models.get(4)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(sw_models.get(5)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(sw_models.get(6)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(sw_models.get(7)));

        // ossid root crop
        List<ModelFile> or_models = new ArrayList<ModelFile>(8);
        for (int ii=0; ii<8; ii++)
        {
            or_models.add(this.models().crop("ossidvine_0" + ii, 
                                                    modLoc("block/ossidvine_0" + ii)).renderType("cutout_mipped"));
        } // end-for 
        this.getVariantBuilder(ModBlocks.ossid_root_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(or_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(or_models.get(1)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(or_models.get(2)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(or_models.get(3)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(or_models.get(4)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(or_models.get(5)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(or_models.get(6)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(or_models.get(7)));
        
        // thundergrass crop
        List<ModelFile> tg_models = new ArrayList<ModelFile>(8);
        for (int ii=0; ii<8; ii++)
        {
            tg_models.add(this.models().crop("thundergrass_0" + ii, 
                                                    modLoc("block/thundergrass_0" + ii)).renderType("cutout_mipped"));
        } // end-for 
        this.getVariantBuilder(ModBlocks.thunder_grass_crop.get())
            .partialState().with(CropBlock.AGE, 0).addModels(new ConfiguredModel(tg_models.get(0)))
            .partialState().with(CropBlock.AGE, 1).addModels(new ConfiguredModel(tg_models.get(1)))
            .partialState().with(CropBlock.AGE, 2).addModels(new ConfiguredModel(tg_models.get(2)))
            .partialState().with(CropBlock.AGE, 3).addModels(new ConfiguredModel(tg_models.get(3)))
            .partialState().with(CropBlock.AGE, 4).addModels(new ConfiguredModel(tg_models.get(4)))
            .partialState().with(CropBlock.AGE, 5).addModels(new ConfiguredModel(tg_models.get(5)))
            .partialState().with(CropBlock.AGE, 6).addModels(new ConfiguredModel(tg_models.get(6)))
            .partialState().with(CropBlock.AGE, 7).addModels(new ConfiguredModel(tg_models.get(7)));
        
       
    } // end registerCropBlocks
    
 
} // end class
