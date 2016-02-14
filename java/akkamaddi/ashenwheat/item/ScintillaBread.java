package akkamaddi.ashenwheat.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class ScintillaBread extends ItemFood
{
    public ScintillaBread(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        setUnlocalizedName("scintillaBread");
    }


    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
