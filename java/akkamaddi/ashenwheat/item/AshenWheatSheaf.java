package akkamaddi.ashenwheat.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class AshenWheatSheaf extends Item
{
    public AshenWheatSheaf()
    {
        super();
        setUnlocalizedName("ashWheatSheaf");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
