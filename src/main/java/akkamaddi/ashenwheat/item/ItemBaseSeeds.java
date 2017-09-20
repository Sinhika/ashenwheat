package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;

public class ItemBaseSeeds extends ItemSeeds 
{
	protected String name;
	protected int burnTime = -1;

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
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return burnTime;
	}

	@Override
	public ItemBaseSeeds setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	public ItemBaseSeeds setBurnTime(int burntime) {
		this.burnTime = burntime;
		return this;
	}
	
} // end class
