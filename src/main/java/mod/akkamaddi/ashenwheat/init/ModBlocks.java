package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.ModHayBlock;
import mod.akkamaddi.ashenwheat.content.CarvedOssidRoot;
import mod.akkamaddi.ashenwheat.content.ModCropsBlock;
import mod.akkamaddi.ashenwheat.content.OssidRootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
            new DeferredRegister<>(ForgeRegistries.BLOCKS, Ashenwheat.MODID);

    // TODO : initialize as generic blocks until we code the particulars.
    // Ashenwheat blocks
    public static final RegistryObject<ModCropsBlock> ash_wheat_crop = BLOCKS.register("ash_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.RED_TERRACOTTA)
                    .doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> ash_wheat_bale = BLOCKS.register("ash_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.RED_TERRACOTTA)
                            .hardnessAndResistance(0.5F).sound(SoundType.PLANT)));
    
    // Scintillawheat blocks
    public static final RegistryObject<ModCropsBlock> scintilla_wheat_crop = BLOCKS.register("scintilla_wheat_crop", 
            () -> new ModCropsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.SAND)
                    .doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP)));
    public static final RegistryObject<ModHayBlock> scintilla_wheat_bale = BLOCKS.register("scintilla_wheat_bale", 
            () -> new ModHayBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.SAND)
                            .hardnessAndResistance(0.5F).sound(SoundType.PLANT)));
    
    // Ossidroot blocks
    public static final RegistryObject<ModCropsBlock> ossid_root_crop = BLOCKS.register("ossid_root_crop", 
            () -> new ModCropsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.LIME_TERRACOTTA)
                            .hardnessAndResistance(0.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<OssidRootBlock> ossid_root = BLOCKS.register("ossid_root", 
            () -> new OssidRootBlock(Block.Properties.create(Material.GOURD, MaterialColor.LIME_TERRACOTTA)
                            .hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<CarvedOssidRoot> carved_ossid_root = BLOCKS.register("carved_ossid_root", 
            () -> new CarvedOssidRoot(Block.Properties.create(Material.GOURD, MaterialColor.LIME_TERRACOTTA)
                            .hardnessAndResistance(1.0F).sound(SoundType.WOOD)));
   public static final RegistryObject<CarvedOssidRoot> ossid_lantern = BLOCKS.register("ossid_lantern", 
            () -> new CarvedOssidRoot(Block.Properties.create(Material.GOURD, MaterialColor.LIME_TERRACOTTA)
                            .hardnessAndResistance(1.0F).sound(SoundType.WOOD).lightValue(15)));
    
    // Thundergrass blocks
    public static final RegistryObject<ModCropsBlock> thunder_grass_crop = BLOCKS.register("thunder_grass_crop", 
            () -> new ModCropsBlock(Block.Properties.create(Material.PLANTS, MaterialColor.CYAN)
                    .doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F).sound(SoundType.CROP)));
    
} // end class
