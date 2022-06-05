package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatItemModelProvider extends ItemModelProvider
{

    public AshenwheatItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        this.withExistingParent("rotten_seeds", "generated")
            .texture("layer0", new ResourceLocation(Ashenwheat.MODID, "item/rottenseed"));
        this.withExistingParent("flax_seed", "generated")
            .texture("layer0", new ResourceLocation(Ashenwheat.MODID, "item/flax_seed"));
        this.withExistingParent("flax_fibre", "generated")
            .texture("layer0", new ResourceLocation(Ashenwheat.MODID, "item/flax_fibre"));
        this.withExistingParent("cloth", "generated")
            .texture("layer0", new ResourceLocation(Ashenwheat.MODID, "item/cloth"));
        
    } // end-registerModels()

} // END CLASS
