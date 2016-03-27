package akkamaddi.ashenwheat.item;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;
import akkamaddi.ashenwheat.AshenWheatCore;

public class AshCookie extends ItemFood
{
	private final String name = "ashcookie";
	
    public AshCookie(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        setUnlocalizedName(name);
        setPotionEffect(new PotionEffect(MobEffects.regeneration, 2, 1), 1.0F);
        GameRegistry.registerItem(this, name);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }

    public String getName()
    {
    	return name;
    }

} // end class AshCookie
