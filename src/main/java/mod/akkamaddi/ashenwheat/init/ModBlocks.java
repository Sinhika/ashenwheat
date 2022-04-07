package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.CarvedOssidRoot;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.content.ModHayBlock;
import mod.akkamaddi.ashenwheat.content.OssidRootBlock;
import mod.alexndr.simplecorelib.helpers.LightUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    public static final DeferredRegister<Block> BLOCKS = 
            DeferredRegister.create(ForgeRegistries.BLOCKS, Ashenwheat.MODID);

    // Ashenwheat blocks
    public static final RegistryObject<ModCropsBlock> ash_wheat_crop = BLOCKS.register("ash_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_RED)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> ash_wheat_bale = BLOCKS.register("ash_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_RED)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Scintillawheat blocks
    public static final RegistryObject<ModCropsBlock> scintilla_wheat_crop = BLOCKS.register("scintilla_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.SAND)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> scintilla_wheat_bale = BLOCKS.register("scintilla_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.of(Material.GRASS, MaterialColor.SAND)
                            .strength(0.5F).sound(SoundType.GRASS)));
    
    // Ossidroot blocks
    public static final RegistryObject<ModCropsBlock> ossid_root_crop = BLOCKS.register("ossid_root_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<OssidRootBlock> ossid_root = BLOCKS.register("ossid_root", 
            () -> new OssidRootBlock(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<CarvedOssidRoot> carved_ossid_root = BLOCKS.register("carved_ossid_root", 
            () -> new CarvedOssidRoot(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)));
   public static final RegistryObject<CarvedOssidRoot> ossid_lantern = BLOCKS.register("ossid_lantern", 
            () -> new CarvedOssidRoot(Block.Properties.of(Material.VEGETABLE, MaterialColor.TERRACOTTA_LIGHT_GREEN)
                            .strength(1.0F).sound(SoundType.WOOD)
                            .lightLevel(LightUtils.setFixedLight(15))));
    
    // Thundergrass blocks
    public static final RegistryObject<ModCropsBlock> thunder_grass_crop = BLOCKS.register("thunder_grass_crop", 
            () -> new ModCropsBlock(Block.Properties.of(Material.PLANT, MaterialColor.COLOR_CYAN)
                    .noCollission().randomTicks().strength(0.0F).sound(SoundType.CROP)));
 
} // end class
