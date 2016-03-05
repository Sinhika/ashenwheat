package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UnstableSoot extends Item
{
	private final String name = "unstablesoot";
	
    public UnstableSoot()
    {
        super();
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }
    
    public String getName()
    {
    	return name;
    }
}