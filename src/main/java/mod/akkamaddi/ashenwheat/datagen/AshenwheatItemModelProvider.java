package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.data.DataGenerator;
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
        // TODO Auto-generated method stub

    }

} // END CLASS
