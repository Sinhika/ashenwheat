package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatItemModelProvider extends ItemModelProvider
{

    public AshenwheatItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Ashenwheat.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        this.withExistingParent("rotten_seeds", "generated")
            .texture("layer0", modLoc("item/rottenseed"));
        this.withExistingParent("flax_seed", "generated")
            .texture("layer0", modLoc("item/flax_seed"));
        this.withExistingParent("flax_fibre", "generated")
            .texture("layer0", modLoc( "item/flax_fibre"));
        this.withExistingParent("cloth", "generated")
            .texture("layer0", modLoc("item/cloth"));
        this.withExistingParent("blaze_sapling", "generated")
            .texture("layer0", modLoc("item/blaze_sapling"));
        
    } // end-registerModels()

} // END CLASS
