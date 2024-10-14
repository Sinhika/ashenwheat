package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.*;
import mod.akkamaddi.ashenwheat.world.BlazeTreeGrower;
import mod.alexndr.simplecorelib.api.content.block.MultifunctionPressurePlateBlock;
import mod.alexndr.simplecorelib.api.helpers.LightUtils;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Holds a list of all our {@link Block}s.
 * Suppliers that create Blocks are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Block Registry Event is fired by Forge and it is time for the mod to
 * register its Blocks, our Blocks are created and registered by the DeferredRegister.
 * The Block Registry Event will always be called before the Item registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Ashenwheat.MODID);

    // Ashenwheat blocks
    public static final DeferredBlock<ModCropsBlock> ash_wheat_crop = BLOCKS.register("ash_wheat_crop", 
            () -> new ModCropsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ModHayBlock> ash_wheat_bale = BLOCKS.register("ash_wheat_bale", 
            () -> new ModHayBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Scintillawheat blocks
    public static final DeferredBlock<ModCropsBlock> scintilla_wheat_crop = BLOCKS.register("scintilla_wheat_crop", 
            () -> new ModCropsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ModHayBlock> scintilla_wheat_bale = BLOCKS.register("scintilla_wheat_bale", 
            () -> new ModHayBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Ossidroot blocks
    public static final DeferredBlock<ModCropsBlock> ossid_root_crop = BLOCKS.register("ossid_root_crop", 
            () -> new ModCropsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<OssidRootBlock> ossid_root = BLOCKS.register("ossid_root", 
            () -> new OssidRootBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<CarvedOssidRoot> carved_ossid_root = BLOCKS.register("carved_ossid_root", 
            () -> new CarvedOssidRoot(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
   public static final DeferredBlock<CarvedOssidRoot> ossid_lantern = BLOCKS.register("ossid_lantern", 
            () -> new CarvedOssidRoot(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
                            .lightLevel(LightUtils.setFixedLight(15))));
    
    // Thundergrass blocks
    public static final DeferredBlock<ModCropsBlock> thunder_grass_crop = BLOCKS.register("thunder_grass_crop", 
            () -> new ModCropsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    // Flax (crop) blocks
    public static final DeferredBlock<FlaxCropBlock> flax_crop = BLOCKS.register("flax_crop", 
            ()-> new FlaxCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
           
    // Rotten Plant (crop) blocks
    public static final DeferredBlock<RottenPlantBlock> rotten_crop = BLOCKS.register("rotten_crop", 
            ()-> new RottenPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    
    // Enderclam blocks
    public static final DeferredBlock<EnderClamBlock> ender_clam = BLOCKS.register("ender_clam", 
            () -> new EnderClamBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
                    .strength(3.0F).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()));
    
    // Buried Remains blocks
    public static final DeferredBlock<DropExperienceBlock> buried_remains = BLOCKS.register("buried_remains",
            ()->new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                    .strength(1.0F).sound(SoundType.SLIME_BLOCK)));

    // Blaze Tree blocks
    public static final DeferredBlock<LeavesBlock> blaze_leaves = BLOCKS.register("blaze_leaves", 
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.2F).randomTicks()
                    .noOcclusion().sound(SoundType.GRASS).isSuffocating((a,b,c)->{return false;}).isViewBlocking((a,b,c)->{return false;})            
                    .lightLevel(LightUtils.setFixedLight(10)).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<BlazeLogBlock> blaze_log = BLOCKS.register("blaze_log", 
            () -> new BlazeLogBlock(BlockBehaviour.Properties.of().mapColor((a ) -> {
                return a.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y 
                		? MapColor.COLOR_YELLOW 
                		: MapColor.PODZOL;
            }).strength(2.0F).sound(SoundType.WOOD)));
    
    // blaze WOOD - a block covered in bark on all sides.
    public static final DeferredBlock<BlazeWoodBlock> blaze_wood = BLOCKS.register("blaze_wood",
            () -> new BlazeWoodBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL)
                    .strength(2.0F).sound(SoundType.WOOD)));
    // stripped blaze log - a log with no bark.
    public static final DeferredBlock<RotatedPillarBlock> stripped_blaze_log = BLOCKS.register("stripped_blaze_log", 
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F).sound(SoundType.WOOD)));
    // stripped blaze wood - ??
    public static final DeferredBlock<RotatedPillarBlock> stripped_blaze_wood = BLOCKS.register("stripped_blaze_wood", 
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F).sound(SoundType.WOOD)));
    
    // sapling
    public static final DeferredBlock<BlazeSaplingBlock> blaze_sapling = BLOCKS.register("blaze_sapling", 
            () -> new BlazeSaplingBlock(new BlazeTreeGrower(), BlockBehaviour.Properties.of().noCollission()
                    .randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    
    // blaze PLANKS
    public static final DeferredBlock<Block> blazewood_planks = BLOCKS.register("blazewood_planks", 
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(2.0F,3.0F).sound(SoundType.WOOD)));
    
    // blazewood plank Aesthetic blocks
    // blazewood stairs
    public static final DeferredBlock<StairBlock> blazewood_stairs = BLOCKS.register("blazewood_stairs", 
            () -> new StairBlock( blazewood_planks.get().defaultBlockState(),  Block.Properties.ofFullCopy(blazewood_planks.get())));
    
    // blazewood slabs
    public static final DeferredBlock<SlabBlock> blazewood_slab = BLOCKS.register("blazewood_slab", 
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(blazewood_planks.get())));
    
    // blazewood pressure plate
    public static final DeferredBlock<MultifunctionPressurePlateBlock> blazewood_pressure_plate = BLOCKS.register("blazewood_pressure_plate", 
            () -> new MultifunctionPressurePlateBlock(15, MultifunctionPressurePlateBlock.Sensitivity.EVERYTHING, 20,
            		BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .noCollission().strength(0.5F), BlockSetType.OAK));
            
    // blazewood button
    public static final DeferredBlock<ButtonBlock> blazewood_button = BLOCKS.register("blazewood_button", 
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F)
            		.pushReaction(PushReaction.DESTROY)));
            
    // blazewood fence
    public static final DeferredBlock<FenceBlock> blazewood_fence = BLOCKS.register("blazewood_fence", 
            () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(ModBlocks.blazewood_planks.get().defaultMapColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));
       
    // blazewood fence gate
    public static final DeferredBlock<FenceGateBlock> blazewood_fence_gate = BLOCKS.register("blazewood_fence_gate", 
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().mapColor(ModBlocks.blazewood_planks.get().defaultMapColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    
    // TODO blazewood sign
    // TODO blazewood door
    // TODO blazewood trapdoor
 } // end class
