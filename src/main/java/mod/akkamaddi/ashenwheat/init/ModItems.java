package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.CombustibleBlockItem;
import mod.akkamaddi.ashenwheat.content.CombustibleBlockNamedItem;
import mod.akkamaddi.ashenwheat.content.CombustibleItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
            DeferredRegister.create(ForgeRegistries.ITEMS, Ashenwheat.MODID);

    // Food values
    public static final FoodProperties ASHBREAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties ASHCOOKIE  = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2, 1), 1.0F).build();
    public static final FoodProperties SCINTILLABREAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();
    public static final FoodProperties SCINTILLACOOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3, 1), 1.0F).build();
    
    // Ashwheat items
    public static final RegistryObject<CombustibleItem> ash_wheat_sheaf = ITEMS.register("ash_wheat_sheaf", 
            () -> new CombustibleItem(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<CombustibleBlockNamedItem> ash_seeds = ITEMS.register("ash_seeds", 
            () -> new CombustibleBlockNamedItem(ModBlocks.ash_wheat_crop.get(), 
                                     new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    // ashenwheat hay bale block item is a special snowflake that needs an item to define burn-time.
    public static final RegistryObject<CombustibleBlockItem> ash_wheat_bale = ITEMS.register("ash_wheat_bale", 
            () -> new CombustibleBlockItem(ModBlocks.ash_wheat_bale.get(), new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<CombustibleItem> ash_bread = ITEMS.register("ash_bread", 
            () -> new CombustibleItem(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP).food(ASHBREAD)));
    public static final RegistryObject<CombustibleItem> ash_cookie = ITEMS.register("ash_cookie", 
            () -> new CombustibleItem(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP).food(ASHCOOKIE)));
    
    // Scintilla Wheat items
    public static final RegistryObject<ItemNameBlockItem> scintilla_seeds = ITEMS.register("scintilla_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.scintilla_wheat_crop.get(), 
                                     new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintilla_wheat_sheaf = ITEMS.register("scintilla_wheat_sheaf", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintillating_ash = ITEMS.register("scintillating_ash", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    public static final RegistryObject<Item> scintilla_bread = ITEMS.register("scintilla_bread", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP).food(SCINTILLABREAD)));
    public static final RegistryObject<Item> scintilla_cookie = ITEMS.register("scintilla_cookie", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP).food(SCINTILLACOOKIE)));
    
    
    // Ossidroot items
    public static final RegistryObject<ItemNameBlockItem> ossid_seeds = ITEMS.register("ossid_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.ossid_root_crop.get(), 
                                     new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> calcified_ash = ITEMS.register("calcified_ash", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Thundergrass items
    public static final RegistryObject<ItemNameBlockItem> thunder_seeds = ITEMS.register("thunder_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.thunder_grass_crop.get(), 
                                    new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> unstable_soot = ITEMS.register("unstable_soot", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    //  Flax items
    public static final RegistryObject<ItemNameBlockItem> flax_seeds = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(ModBlocks.flax_crop.get(), new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> flax_fibre = ITEMS.register("flax_fibre", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> cloth = ITEMS.register("cloth", 
            () -> new Item(new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Rotten Plant items
    public static final RegistryObject<ItemNameBlockItem> rotten_seeds = ITEMS.register("rotten_seeds",
            () -> new ItemNameBlockItem(ModBlocks.rotten_crop.get(), new Item.Properties().tab(ModItemGroups.MOD_ITEM_GROUP)));
    
    // TODO possible future Ender Clam items
} // end class
