package akkamaddi.ashenwheat.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;

public class AshSeeds extends ItemSeeds implements IPlantable
{
    public AshSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
        setUnlocalizedName("ashSeeds");
    }

    @Override
    public void registerIcons(IIconRegister ir)
    {
        this.itemIcon = ir.registerIcon("ashenwheat:ashSeeds");
    }
} // end class AshSeeds
