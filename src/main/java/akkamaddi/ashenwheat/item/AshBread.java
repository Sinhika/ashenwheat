package akkamaddi.ashenwheat.item;

import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;
import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;

public class AshBread extends ItemFood
{
	private final String name = "ashbread";
	
    public AshBread(int par2, float par3, boolean par4)
    {
        super(par2, par3, par4);
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
        GameRegistry.register(this);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
     }

    public String getName()
    {
    	return name;
    }

} // end class AshBread
