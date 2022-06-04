package mod.akkamaddi.ashenwheat.datagen;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import mod.alexndr.simplecorelib.api.datagen.MiningItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AshenwheatItemTags extends MiningItemTags
{

    public AshenwheatItemTags(DataGenerator gen,  ExistingFileHelper existingFileHelper)
    {
        super(gen, new AshenwheatBlockTags(gen, existingFileHelper), Ashenwheat.MODID, existingFileHelper);
    }

} // end class
