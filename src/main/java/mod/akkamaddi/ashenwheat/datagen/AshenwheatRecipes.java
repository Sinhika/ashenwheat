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
    } // end regiserMiscRecipes()

} // end class
