package akkamaddi.ashenwheat.code;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ScintillaCookie extends ItemFood
{
    public ScintillaCookie(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        //setAlwaysEdible();
        setPotionEffect(Potion.regeneration.id, 3, 1, 1.0F);
        setUnlocalizedName("scintillaCookie");
    }

    public void registerIcons(IIconRegister ir)
    {
		this.itemIcon = ir.registerIcon("ashenwheat:" + (this.getUnlocalizedName().substring(5)));
    }
}