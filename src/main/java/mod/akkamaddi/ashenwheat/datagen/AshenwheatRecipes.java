package mod.akkamaddi.ashenwheat.datagen;

import java.util.function.Consumer;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.akkamaddi.ashenwheat.config.AshenwheatConfig;
import mod.alexndr.simplecorelib.api.datagen.ISimpleConditionBuilder;
import mod.alexndr.simplecorelib.api.datagen.RecipeSetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
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
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer)
    {
    }


    @Override
    public ICondition flag(String arg0)
    {
         return impl_flag(Ashenwheat.MODID, AshenwheatConfig.INSTANCE, arg0);
    }

} // end class
