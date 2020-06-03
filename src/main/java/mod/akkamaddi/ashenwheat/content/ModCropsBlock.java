package mod.akkamaddi.ashenwheat.content;

import mod.akkamaddi.ashenwheat.init.ModBlocks;
import mod.akkamaddi.ashenwheat.init.ModItems;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;

public class ModCropsBlock extends CropsBlock
{

    public ModCropsBlock(Properties builder)
    {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem()
    {
        if (this == ModBlocks.ash_wheat_crop.get()) {
            return ModItems.ash_seeds.get();
        }
        else if (this == ModBlocks.ossid_root_crop.get()) {
            return ModItems.ossid_seeds.get();
        }
        else if (this == ModBlocks.scintilla_wheat_crop.get()) {
            return ModItems.scintilla_seeds.get();
        }
        else if (this == ModBlocks.thunder_grass_crop.get()) {
            return ModItems.thunder_seeds.get();
        }
        return super.getSeedsItem();
    } // getSeedsItems

} // end class
