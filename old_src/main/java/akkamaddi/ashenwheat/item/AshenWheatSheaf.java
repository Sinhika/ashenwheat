package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class AshenWheatSheaf extends Item
{
	private final String name = "ashwheatsheaf";
	
    public AshenWheatSheaf()
    {
        super();
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
        GameRegistry.register(this);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }
    
    public String getName()
    {
    	return name;
    }
}
