/**
 * 
 */
package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Sinhika
 *
 */
public class ItemBase extends Item 
{
	protected String name;
	protected int burnTime = -1;
	
	public ItemBase( String name) 
	{
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
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	public ItemBase setBurnTime(int burntime) {
		this.burnTime = burntime;
		return this;
	}
	
} // end ItemBase
