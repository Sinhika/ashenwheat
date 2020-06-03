package mod.akkamaddi.ashenwheat.init;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.content.AshwheatSheafItem;
import net.minecraft.item.Item;
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

    public static final RegistryObject<AshwheatSheafItem> ash_wheat_sheaf = ITEMS.register("ash_wheat_sheaf", 
            () -> new AshwheatSheafItem(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // TODO initially use generic items until we get the particulars sorted out.
    // Ashwheat items
    public static final RegistryObject<Item> ash_seeds = ITEMS.register("ash_seeds", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ash_bread = ITEMS.register("ash_bread", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> ash_cookie = ITEMS.register("ash_cookie", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Scintilla Wheat items
    public static final RegistryObject<Item> scintilla_seeds = ITEMS.register("scintilla_seeds", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintilla_wheat_sheaf = ITEMS.register("scintilla_wheat_sheaf", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintilla_bread = ITEMS.register("scintilla_bread", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintilla_cookie = ITEMS.register("scintilla_cookie", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> scintillating_ash = ITEMS.register("scintillating_ash", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Ossidroot items
    public static final RegistryObject<Item> ossid_seeds = ITEMS.register("ossid_seeds", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> calcified_ash = ITEMS.register("calcified_ash", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
    // Thundergrass items
    public static final RegistryObject<Item> thunder_seeds = ITEMS.register("thunder_seeds", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    public static final RegistryObject<Item> unstable_soot = ITEMS.register("unstable_soot", 
            () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));
    
} // end class
