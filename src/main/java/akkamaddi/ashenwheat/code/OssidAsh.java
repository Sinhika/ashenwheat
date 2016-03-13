package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class OssidAsh extends Item
{
    public OssidAsh()
    {
        super();
        setUnlocalizedName("calcifiedAsh");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}
