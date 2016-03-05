package akkamaddi.ashenwheat.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.registry.GameRegistry;
import akkamaddi.ashenwheat.AshenWheatCore;

public class OssidSeeds extends ItemSeeds implements net.minecraftforge.common.IPlantable
{
	private final String name = "ossidseeds";
	
    public OssidSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        setCreativeTab(AshenWheatCore.tabAshenwheat);
    }
    
    public String getName()
    {
    	return name;
    }

}
