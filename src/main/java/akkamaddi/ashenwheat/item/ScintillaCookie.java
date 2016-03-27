package akkamaddi.ashenwheat.item;

import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;
import akkamaddi.ashenwheat.AshenWheatCore;

public class ScintillaCookie extends ItemFood
{
	private final String name = "scintillacookie";
	
    public ScintillaCookie(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        //setAlwaysEdible();
        setPotionEffect(new PotionEffect(MobEffects.regeneration, 3, 1), 1.0F);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }
    
    public String getName()
    {
    	return name;
    }
}
