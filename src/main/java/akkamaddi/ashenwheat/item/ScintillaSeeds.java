package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScintillaSeeds extends ItemSeeds implements IPlantable
{
	private final String name = "scintillaseeds";
	
    public ScintillaSeeds(Block cropBlock, Block soilBlock)
    {
        super(cropBlock, soilBlock);
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
