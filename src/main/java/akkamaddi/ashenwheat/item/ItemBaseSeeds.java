package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;

public class ItemBaseSeeds extends ItemSeeds 
{
	protected String name;

	public ItemBaseSeeds(String name, Block crops, Block soil) 
	{
		super(crops, soil);
		this.name = name;
        setUnlocalizedName(name);
        setRegistryName(ModInfo.ID, name);
	} // end ctor()

	public void registerItemModel() {
		AshenWheatCore.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ItemBaseSeeds setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
} // end class
