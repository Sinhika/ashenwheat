package mod.akkamaddi.ashenwheat.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.akkamaddi.ashenwheat.init.ModItems;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

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
    }

    private void registerArmorRecipes(Consumer<FinishedRecipe> consumer)
    {
        setbuilder.buildSimpleArmorSet(consumer, Ingredient.of(ModItems.cloth.get()), "leather",
                has(ModItems.cloth.get()), flag("flax_recipes_enabled"));
    }
    
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
            
    } // end regiserMiscRecipes()

    @Override
    public ICondition flag(String arg0)
    {
         return impl_flag(Ashenwheat.MODID, AshenwheatConfig.INSTANCE, arg0);
    }

} // end class
