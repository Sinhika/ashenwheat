package akkamaddi.ashenwheat.code;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;

public class ScintillaSeeds extends ItemSeeds implements IPlantable
{
    public ScintillaSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
        setUnlocalizedName("scintillaSeeds");
    }

    @Override
    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }

}
