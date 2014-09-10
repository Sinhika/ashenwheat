package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class AshCookie extends ItemFood
{
    public AshCookie(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        setUnlocalizedName("ashCookie");
        setPotionEffect(Potion.regeneration.id, 2, 1, 1.0F);
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
} // end class AshCookie
