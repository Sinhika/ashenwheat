/**
 * 
 */
package akkamaddi.ashenwheat.item;

import akkamaddi.ashenwheat.AshenWheatCore;
import akkamaddi.ashenwheat.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author Sinhika
 *
 */
public class ItemBase extends Item 
{
	protected String name;
	
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
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
} // end ItemBase
