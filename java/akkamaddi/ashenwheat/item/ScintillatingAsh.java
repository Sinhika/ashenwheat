package akkamaddi.ashenwheat.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ScintillatingAsh extends Item
{
    public ScintillatingAsh()
    {
        super();
        setUnlocalizedName("scintillatingAsh");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}