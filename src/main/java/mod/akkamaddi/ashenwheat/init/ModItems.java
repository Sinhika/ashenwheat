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
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems
{
    public static final DeferredRegister.Items  ITEMS = DeferredRegister.createItems(Ashenwheat.MODID);

    // Food values
    public static final FoodProperties ASHBREAD = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.5F).build();
    public static final FoodProperties ASHCOOKIE  = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 2, 1), 1.0F).build();
    public static final FoodProperties SCINTILLABREAD = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.7F).build();
    public static final FoodProperties SCINTILLACOOKIE = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 3, 1), 1.0F).build();
    
    // Ashwheat items
    public static final DeferredItem<CombustibleItem> ash_wheat_sheaf = ITEMS.register("ash_wheat_sheaf", 
            () -> new CombustibleItem(new Item.Properties()));
    
    public static final DeferredItem<CombustibleBlockNamedItem> ash_seeds = ITEMS.register("ash_seeds", 
            () -> new CombustibleBlockNamedItem(ModBlocks.ash_wheat_crop.get(), 
                                     new Item.Properties()));
    
    // ashenwheat hay bale block item is a special snowflake that needs an item to define burn-time.
    public static final DeferredItem<CombustibleBlockItem> ash_wheat_bale = ITEMS.register("ash_wheat_bale", 
            () -> new CombustibleBlockItem(ModBlocks.ash_wheat_bale.get(), new Item.Properties()));
    
    public static final DeferredItem<CombustibleItem> ash_bread = ITEMS.register("ash_bread", 
            () -> new CombustibleItem(new Item.Properties().food(ASHBREAD)));
    public static final DeferredItem<CombustibleItem> ash_cookie = ITEMS.register("ash_cookie", 
            () -> new CombustibleItem(new Item.Properties().food(ASHCOOKIE)));
    
    // Scintilla Wheat items
    public static final DeferredItem<ItemNameBlockItem> scintilla_seeds = ITEMS.register("scintilla_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.scintilla_wheat_crop.get(), 
                                     new Item.Properties()));
    public static final DeferredItem<Item> scintilla_wheat_sheaf = ITEMS.register("scintilla_wheat_sheaf", 
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> scintillating_ash = ITEMS.register("scintillating_ash", 
            () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<Item> scintilla_bread = ITEMS.register("scintilla_bread", 
            () -> new Item(new Item.Properties().food(SCINTILLABREAD)));
    public static final DeferredItem<Item> scintilla_cookie = ITEMS.register("scintilla_cookie", 
            () -> new Item(new Item.Properties().food(SCINTILLACOOKIE)));
    
    
    // Ossidroot items
    public static final DeferredItem<ItemNameBlockItem> ossid_seeds = ITEMS.register("ossid_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.ossid_root_crop.get(), 
                                     new Item.Properties()));
    public static final DeferredItem<Item> calcified_ash = ITEMS.register("calcified_ash", 
            () -> new Item(new Item.Properties()));
    
    // Thundergrass items
    public static final DeferredItem<ItemNameBlockItem> thunder_seeds = ITEMS.register("thunder_seeds", 
            () -> new ItemNameBlockItem(ModBlocks.thunder_grass_crop.get(), 
                                    new Item.Properties()));
    public static final DeferredItem<Item> unstable_soot = ITEMS.register("unstable_soot", 
            () -> new Item(new Item.Properties()));
    
    //  Flax items
    public static final DeferredItem<ItemNameBlockItem> flax_seed = ITEMS.register("flax_seed",
            () -> new ItemNameBlockItem(ModBlocks.flax_crop.get(), new Item.Properties()));
    public static final DeferredItem<Item> flax_fibre = ITEMS.register("flax_fibre", 
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> cloth = ITEMS.register("cloth", 
            () -> new Item(new Item.Properties()));
    
    // Rotten Plant items
    public static final DeferredItem<ItemNameBlockItem> rotten_seeds = ITEMS.register("rotten_seeds",
            () -> new ItemNameBlockItem(ModBlocks.rotten_crop.get(), new Item.Properties()));
    
    // TODO blaze wood items
    // blazewood boat
    
} // end class
