package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemBaseFood extends ItemFood 
{
	protected String name;
	protected int burnTime = -1;
	
	public ItemBaseFood( String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
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
	public ItemBaseFood setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	public ItemBaseFood setBurnTime(int burntime) {
		this.burnTime = burntime;
		return this;
	}

} // end class
