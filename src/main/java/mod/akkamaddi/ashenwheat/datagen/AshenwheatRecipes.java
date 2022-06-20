package mod.akkamaddi.ashenwheat.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

public class AshenwheatRecipes extends RecipeProvider implements IConditionBuilder, ISimpleConditionBuilder
{
    private RecipeSetBuilder setbuilder;

    public AshenwheatRecipes(DataGenerator pGenerator)
    {
        super(pGenerator);
        setbuilder = new RecipeSetBuilder(Ashenwheat.MODID);
    }

    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        regiserMiscRecipes(consumer);
        registerArmorRecipes(consumer);
        registerWoodRecipes(consumer);
    }

    private void registerWoodRecipes(Consumer<FinishedRecipe> consumer)
    {
        // log -> planks
        ShapelessRecipeBuilder.shapeless(ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.blaze_log.get())
            .unlockedBy("has_item", has(ModBlocks.blaze_log.get()))
            .save(consumer);
                    
        // wood -> planks
        ShapelessRecipeBuilder.shapeless(ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.blaze_wood.get())
            .unlockedBy("has_item", has(ModBlocks.blaze_wood.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_wood");
        
        // stripped wood -> planks
        ShapelessRecipeBuilder.shapeless(ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.stripped_blaze_wood.get())
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_wood.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_stripped_wood");
    
        // stripped log -> planks
        ShapelessRecipeBuilder.shapeless(ModBlocks.blazewood_planks.get(), 4)
            .requires(ModBlocks.stripped_blaze_log.get())
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_log.get()))
            .save(consumer, "ashenwheat:blaze_planks_from_stripped_log");
        
        // stripped log -> stripped wood
        ShapedRecipeBuilder.shaped(ModBlocks.stripped_blaze_wood.get(), 3)
            .define('S', ModBlocks.stripped_blaze_log.get())
            .pattern("SS")
            .pattern("SS")
            .unlockedBy("has_item", has(ModBlocks.stripped_blaze_log.get()))
            .save(consumer);
        
        // log -> wood
        ShapedRecipeBuilder.shaped(ModBlocks.blaze_wood.get(), 3)
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
        AshenwheatRecipes.slabBuilder(ModBlocks.blazewood_slab.get(),  Ingredient.of(ModBlocks.blazewood_planks.get()))
            .unlockedBy("has_item", has(ModBlocks.blazewood_planks.get()))
            .save(consumer);
        
        // pressure plates.
        this.setbuilder.buildSimplePressurePlate(consumer, Ingredient.of(ModBlocks.blazewood_planks.get()), 
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
    private void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
        CriterionTriggerInstance criterion = has(ModItems.cloth.get());
        Ingredient item = Ingredient.of(ModItems.cloth.get());
        
        ResourceLocation helmet_name = new ResourceLocation("minecraft", "leather_helmet");
        ResourceLocation chestplate_name = new ResourceLocation("minecraft", "leather_chestplate");
        ResourceLocation leggings_name = new ResourceLocation("minecraft", "leather_leggings");
        ResourceLocation boots_name = new ResourceLocation("minecraft", "leather_boots");
        
        ResourceLocation helmet_recipe = new ResourceLocation(Ashenwheat.MODID, helmet_name.getPath() + "_from_cloth");
        ResourceLocation chestplate_recipe = new ResourceLocation(Ashenwheat.MODID, chestplate_name.getPath() + "_from_cloth");
        ResourceLocation leggings_recipe = new ResourceLocation(Ashenwheat.MODID, leggings_name.getPath() + "_from_cloth");
        ResourceLocation boots_recipe = new ResourceLocation(Ashenwheat.MODID, boots_name.getPath() + "_from_cloth");
        
        Item helmet = ForgeRegistries.ITEMS.getValue(helmet_name);
        Item chestplate = ForgeRegistries.ITEMS.getValue(chestplate_name);
        Item leggings = ForgeRegistries.ITEMS.getValue(leggings_name);
        Item boots = ForgeRegistries.ITEMS.getValue(boots_name);

        ShapedRecipeBuilder.shaped(helmet)
            .define('S', item)
            .pattern("SSS")
            .pattern("S S")
            .pattern("   ")
            .unlockedBy("has_item", criterion)
            .save(consumer, helmet_recipe);
        ShapedRecipeBuilder.shaped(chestplate)
            .define('S',item)
            .pattern("S S")
            .pattern("SSS")
            .pattern("SSS")
            .unlockedBy("has_item", criterion)
            .save(consumer, chestplate_recipe);
        ShapedRecipeBuilder.shaped(leggings)
            .define('S', item)
            .pattern("SSS")
            .pattern("S S")
            .pattern("S S")
            .unlockedBy("has_item", criterion)
            .save(consumer, leggings_recipe);
        ShapedRecipeBuilder.shaped(boots)
            .define('S', item)
            .pattern("   ")
            .pattern("S S")
            .pattern("S S")
            .unlockedBy("has_item", criterion)
            .save(consumer, boots_recipe);
    } // end registerArmorRecipes()
    
    private void regiserMiscRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapelessRecipeBuilder.shapeless(Items.STRING)
            .requires(ModItems.flax_fibre.get(), 2)
            .unlockedBy("has_item", has(ModItems.flax_fibre.get()))
            .save(consumer, "ashenwheat:string_from_fibre");
        
        ShapelessRecipeBuilder.shapeless(ModItems.cloth.get())
                .requires(Items.STRING, 2)
                .unlockedBy("has_item", has(Items.STRING))
                .save(consumer);
        
        ShapelessRecipeBuilder.shapeless(ModItems.cloth.get())
            .requires(ItemTags.WOOL)
            .requires(ItemTags.WOOL)
            .unlockedBy("has_item", has(ItemTags.WOOL))
            .save(consumer, "ashenwheat:cloth_from_wool");
                
        ShapelessRecipeBuilder.shapeless(Items.WHITE_WOOL)
            .requires(ModItems.cloth.get(), 2)
            .unlockedBy("has_item", has(ModItems.cloth.get()))
            .save(consumer, "ashenwheat:white_wool_from_cloth");
            
        ShapelessRecipeBuilder.shapeless(Items.BOOK)
            .requires(Items.PAPER, 3)
            .requires(ModItems.cloth.get())
            .unlockedBy("has_item", has(ModItems.cloth.get()))
            .save(consumer, "ashenwheat:book_from_cloth");
    } // end regiserMiscRecipes()

    @Override
    public ICondition flag(String arg0)
    {
         return impl_flag(Ashenwheat.MODID, AshenwheatConfig.INSTANCE, arg0);
    }

} // end class
