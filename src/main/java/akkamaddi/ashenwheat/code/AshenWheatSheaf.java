package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class AshenWheatSheaf extends Item
{
    public AshenWheatSheaf()
    {
        super();
        this.setUnlocalizedName("ashWheatSheaf");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
