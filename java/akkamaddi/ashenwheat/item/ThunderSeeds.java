package akkamaddi.ashenwheat.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;

public class ThunderSeeds extends ItemSeeds implements IPlantable
{
    public ThunderSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
        setUnlocalizedName("thunderSeeds");
    }

    @Override
    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
