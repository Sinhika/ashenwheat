package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.CombustibleBlockItem;
import mod.akkamaddi.ashenwheat.content.CombustibleBlockNamedItem;
import mod.akkamaddi.ashenwheat.content.CombustibleItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = 
            new DeferredRegister<>(ForgeRegistries.ITEMS, Ashenwheat.MODID);

    // Food values
    public static final Food ASHBREAD = (new Food.Builder()).hunger(4).saturation(0.5F).build();
    public static final Food ASHCOOKIE  = (new Food.Builder()).hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 2, 1), 1.0F).build();
    public static final Food SCINTILLABREAD = (new Food.Builder()).hunger(4).saturation(0.7F).build();
    public static final Food SCINTILLACOOKIE = (new Food.Builder()).hunger(1).saturation(0.1F)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 3, 1), 1.0F).build();
    
    // Ashwheat items
    public static final RegistryObject<CombustibleItem> ash_wheat_sheaf = ITEMS.register("ash_wheat_sheaf", 
            () -> new CombustibleItem(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<CombustibleBlockNamedItem> ash_seeds = ITEMS.register("ash_seeds", 
            () -> new CombustibleBlockNamedItem(ModBlocks.ash_wheat_crop.get(), 
                                     new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // ashenwheat hay bale block item is a special snowflake that needs an item to define burn-time.
    public static final RegistryObject<CombustibleBlockItem> ash_wheat_bale = ITEMS.register("ash_wheat_bale", 
            () -> new CombustibleBlockItem(ModBlocks.ash_wheat_bale.get(), new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // TODO initially use generic items until we get the particulars sorted out.
    public static final RegistryObject<Item> ash_bread = ITEMS.register("ash_bread", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).food(ASHBREAD)));
    public static final RegistryObject<Item> ash_cookie = ITEMS.register("ash_cookie", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).food(ASHCOOKIE)));
    
    // Scintilla Wheat items
    public static final RegistryObject<BlockNamedItem> scintilla_seeds = ITEMS.register("scintilla_seeds", 
            () -> new BlockNamedItem(ModBlocks.scintilla_wheat_crop.get(), 
                                     new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintilla_wheat_sheaf = ITEMS.register("scintilla_wheat_sheaf", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintillating_ash = ITEMS.register("scintillating_ash", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> scintilla_bread = ITEMS.register("scintilla_bread", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).food(SCINTILLABREAD)));
    public static final RegistryObject<Item> scintilla_cookie = ITEMS.register("scintilla_cookie", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP).food(SCINTILLACOOKIE)));
    
    
    // Ossidroot items
    public static final RegistryObject<BlockNamedItem> ossid_seeds = ITEMS.register("ossid_seeds", 
            () -> new BlockNamedItem(ModBlocks.ossid_root_crop.get(), 
                                     new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> calcified_ash = ITEMS.register("calcified_ash", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Thundergrass items
    public static final RegistryObject<BlockNamedItem> thunder_seeds = ITEMS.register("thunder_seeds", 
            () -> new BlockNamedItem(ModBlocks.thunder_grass_crop.get(), 
                                    new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> unstable_soot = ITEMS.register("unstable_soot", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
} // end class
