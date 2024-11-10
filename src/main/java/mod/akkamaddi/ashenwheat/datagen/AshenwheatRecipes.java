package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.SimpleRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AshenwheatRecipes extends SimpleRecipeProvider
{

    public AshenwheatRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(pOutput, lookupProvider, Ashenwheat.MODID);
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer)
    {
        regiserMiscRecipes(consumer);
        registerArmorRecipes(consumer);
        registerWoodRecipes(consumer);
        registerSmeltingRecipes(consumer);
        registerFoodRecipes(consumer);
    }

    private void registerFoodRecipes(RecipeOutput consumer)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.ash_bread.get())
                .define('A', ModItems.ash_wheat_sheaf.get())
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.ash_wheat_sheaf.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.scintilla_bread.get())
                .define('A', ModItems.scintilla_wheat_sheaf.get())
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.scintilla_wheat_sheaf.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.ash_cookie.get())
                .define('C', Items.COCOA_BEANS)
                .define('W', ModItems.ash_wheat_sheaf.get())
                .pattern("WCW")
                .unlockedBy("has_item", has(ModItems.ash_wheat_sheaf.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.scintilla_cookie.get())
                .define('C', Items.COCOA_BEANS)
                .define('W', ModItems.scintilla_wheat_sheaf.get())
                .pattern("WCW")
                .unlockedBy("has_item", has(ModItems.scintilla_wheat_sheaf.get()))
                .save(consumer);
    } // end registerFoodRecipes()


    private void registerSmeltingRecipes(RecipeOutput consumer)
    {
        modOreSmelting(consumer, List.of(ModBlocks.ossid_root.asItem()), RecipeCategory.MISC,
                ModItems.calcified_ash.get(), 0.4F, 200, null);
        modOreSmelting(consumer, List.of(ModBlocks.scintilla_wheat_bale.asItem()), RecipeCategory.MISC,
                ModItems.scintillating_ash.get(), 0.5F, 200, null);
        modOreSmelting(consumer, List.of(ModItems.ash_bread.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.5F, 200, null);
        modOreSmelting(consumer, List.of(ModItems.thunder_seeds.get()), RecipeCategory.MISC,
                ModItems.unstable_soot.get(), 0.4F, 200, null);
    }

    private void registerWoodRecipes(RecipeOutput consumer)
    {
        // log -> planks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.blaze_log.get())
            .unlockedBy("has_item", has(ModBlocks.blaze_log.get()))
            .save(consumer);
                    
        // wood -> planks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.blaze_wood.get())
            .unlockedBy("has_item", has(ModBlocks.blaze_wood.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_wood");
        
        // stripped wood -> planks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.stripped_blaze_wood.get())
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_wood.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_stripped_wood");
    
        // stripped log -> planks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.stripped_blaze_log.get())
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_log.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_stripped_log");
        
        // stripped log -> stripped wood
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.stripped_blaze_wood.get(), 3)
            .define('S', ModBlocks.stripped_blaze_log.get())
            .pattern("SS")
            .pattern("SS")
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_log.get()))
            .save(consumer);
        
        // log -> wood
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blaze_wood.get(), 3)
            .define('S', ModBlocks.blaze_log.get())
            .pattern("SS")
            .pattern("SS")
            .unlockedBy("has_item", has(ModBlocks.blaze_log.get()))
            .save(consumer);
        
        // stairs
        AshenwheatRecipes.stairBuilder(ModBlocks.blazewood_stairs.get(), Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);

        // slab
        AshenwheatRecipes.slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.blazewood_slab.get(),  Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);
        
        // pressure plates.
        this.buildSimplePressurePlate(consumer, Ingredient.of(ModBlocks.blazewood_planks.get()),
                ModBlocks.blazewood_pressure_plate.get(), has(ModBlocks.blazewood_planks.get()));
        
        // button
        AshenwheatRecipes.buttonBuilder(ModBlocks.blazewood_button.get(), Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);
            
        // fence gate
        AshenwheatRecipes.fenceGateBuilder(ModBlocks.blazewood_fence_gate.get(), Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);
        
        // fence
        AshenwheatRecipes.fenceBuilder(ModBlocks.blazewood_fence.get(), Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.blazewood_door.get(), 3)
                .define('S', ModBlocks.blazewood_planks.get())
                .pattern(" SS")
                .pattern(" SS")
                .pattern(" SS")
                .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.blazewood_trapdoor.get(), 2)
                .define('S', ModBlocks.blazewood_planks.get())
                .pattern("   ")
                .pattern("SSS")
                .pattern("SSS")
                .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
                .save(consumer);

    } // end registerWoodRecipes
    
    
    /**
     * Setbuilder.buildSimpleArmorSet() isn't set up to handle vanilla armor outputs, so we 
     * cut & paste the contents and adapt it. 
     *        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.cloth.get()), "leather",
     *          has(ModItems.cloth.get()), flag("flax_recipes_enabled"));
     *
     * @param consumer
     */
    private void registerArmorRecipes(RecipeOutput consumer)
    {
        Criterion<InventoryChangeTrigger.TriggerInstance> criterion = has(ModItems.cloth.get());
        Ingredient item = Ingredient.of(ModItems.cloth.get());
        
        ResourceLocation helmet_name = new ResourceLocation("minecraft", "leather_helmet");
        ResourceLocation chestplate_name = new ResourceLocation("minecraft", "leather_chestplate");
        ResourceLocation leggings_name = new ResourceLocation("minecraft", "leather_leggings");
        ResourceLocation boots_name = new ResourceLocation("minecraft", "leather_boots");
        
        ResourceLocation helmet_recipe = new ResourceLocation(Ashenwheat.MODID, helmet_name.getPath() + "_from_cloth");
        ResourceLocation chestplate_recipe = new ResourceLocation(Ashenwheat.MODID, chestplate_name.getPath() + "_from_cloth");
        ResourceLocation leggings_recipe = new ResourceLocation(Ashenwheat.MODID, leggings_name.getPath() + "_from_cloth");
        ResourceLocation boots_recipe = new ResourceLocation(Ashenwheat.MODID, boots_name.getPath() + "_from_cloth");
        
        Item helmet = BuiltInRegistries.ITEM.get(helmet_name);
        Item chestplate = BuiltInRegistries.ITEM.get(chestplate_name);
        Item leggings = BuiltInRegistries.ITEM.get(leggings_name);
        Item boots = BuiltInRegistries.ITEM.get(boots_name);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
            .define('S', item)
            .pattern("SSS")
            .pattern("S S")
            .pattern("   ")
            .unlockedBy("has_item", criterion)
            .save(consumer, helmet_recipe);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,chestplate)
            .define('S',item)
            .pattern("S S")
            .pattern("SSS")
            .pattern("SSS")
            .unlockedBy("has_item", criterion)
            .save(consumer, chestplate_recipe);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,leggings)
            .define('S', item)
            .pattern("SSS")
            .pattern("S S")
            .pattern("S S")
            .unlockedBy("has_item", criterion)
            .save(consumer, leggings_recipe);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,boots)
            .define('S', item)
            .pattern("   ")
            .pattern("S S")
            .pattern("S S")
            .unlockedBy("has_item", criterion)
            .save(consumer, boots_recipe);
    } // end registerArmorRecipes()
    
    private void regiserMiscRecipes(RecipeOutput consumer)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING)
            .requires(ModItems.flax_fibre.get(), 2)
            .unlockedBy("has_item", has(ModItems.flax_fibre.get()))
            .save(consumer, "ashenwheat:string_from_fibre");
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.cloth.get())
                .requires(Items.STRING, 2)
                .unlockedBy("has_item", has(Items.STRING))
                .save(consumer);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.cloth.get())
            .requires(ItemTags.WOOL)
            .requires(ItemTags.WOOL)
            .unlockedBy("has_item", has(ItemTags.WOOL))
            .save(consumer, "ashenwheat:cloth_from_wool");
                
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.WHITE_WOOL)
            .requires(ModItems.cloth.get(), 2)
            .unlockedBy("has_item", has(ModItems.cloth.get()))
            .save(consumer, "ashenwheat:white_wool_from_cloth");
            
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BOOK)
            .requires(Items.PAPER, 3)
            .requires(ModItems.cloth.get())
            .unlockedBy("has_item", has(ModItems.cloth.get()))
            .save(consumer, "ashenwheat:book_from_cloth");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BLACK_DYE)
                .define('A', ModItems.unstable_soot.get())
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_item", has(ModItems.unstable_soot.get()))
                .save(consumer, "ashenwheat:black_dye_from_soot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BONE_MEAL)
                .define('A', ModItems.calcified_ash.get())
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_item", has(ModItems.calcified_ash.get()))
                .save(consumer, "ashenwheat:bonemeal_from_ash");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GLOWSTONE)
                .define('A', ModItems.scintillating_ash.get())
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_item", has(ModItems.scintillating_ash.get()))
                .save(consumer, "ashenwheat:glowstone_from_ash");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GUNPOWDER)
                .define('A', ModItems.unstable_soot.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.unstable_soot.get()))
                .save(consumer, "ashenwheat:gunpowder_from_soot");

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ossid_lantern.asItem())
                .define('A', ModBlocks.carved_ossid_root.asItem())
                .define('T', Items.TORCH)
                .pattern("A")
                .pattern("T")
                .unlockedBy("has_item", has(ModBlocks.carved_ossid_root.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ash_seeds.get(), 2)
                .requires(ModItems.ash_wheat_sheaf.get())
                .unlockedBy("has_item", has(ModItems.ash_wheat_sheaf.get()))
                .save(consumer, "ashenwheat:ash_seeds_from_ash_wheat");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ossid_seeds.get(), 4)
                .requires(ModBlocks.ossid_root.asItem())
                .unlockedBy("has_item", has(ModBlocks.ossid_root.asItem()))
                .save(consumer, "ashenwheat:ossid_seeds_from_root");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.scintilla_seeds.get(), 2)
                .requires(ModItems.scintilla_wheat_sheaf.get())
                .unlockedBy("has_item", has(ModItems.scintilla_wheat_sheaf.get()))
                .save(consumer, "ashenwheat:scintilla_seeds_from_scintilla_wheat");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ash_wheat_bale.asItem())
                .define('A', ModItems.ash_wheat_sheaf.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.ash_wheat_sheaf.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.scintilla_wheat_bale.asItem())
                .define('A', ModItems.scintilla_wheat_sheaf.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy("has_item", has(ModItems.scintilla_wheat_sheaf.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.scintilla_wheat_sheaf.get(), 9)
                .requires(ModBlocks.scintilla_wheat_bale.asItem())
                .unlockedBy("has_item", has(ModBlocks.scintilla_wheat_bale.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ash_wheat_sheaf.get(), 9)
                .requires(ModBlocks.ash_wheat_bale.asItem())
                .unlockedBy("has_item", has(ModBlocks.ash_wheat_bale.get()))
                .save(consumer);

    } // end regiserMiscRecipes()

} // end class
