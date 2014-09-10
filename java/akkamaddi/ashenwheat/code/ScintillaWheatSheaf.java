package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ScintillaWheatSheaf extends Item
{
    public ScintillaWheatSheaf()
    {
        super();
        setUnlocalizedName("scintillaWheatItem");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
