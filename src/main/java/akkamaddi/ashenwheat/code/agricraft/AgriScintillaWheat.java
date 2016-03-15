/**
 * 
 */
package akkamaddi.ashenwheat.code.agricraft;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import akkamaddi.ashenwheat.code.AshenWheatCore;

import com.InfinityRaider.AgriCraft.api.v2.ICropPlant;

import cpw.mods.fml.common.Optional;

/**
 * ICropPlant object for ScintillaWheat/Seeds.
 *
 */
@SuppressWarnings("deprecation")
@Optional.Interface(modid = "AgriCraft", iface = "com.InfinityRaider.AgriCraft.api.v2.ICropPlant")
public class AgriScintillaWheat extends AgriAkkamaddiCrop implements ICropPlant 
{
	private static final ArrayList<ItemStack> allfruits = new ArrayList<ItemStack>();


    /**
     * This method returns the default tier of this plant, tiers can be overridden with the configs.
     * This should be in the interval [1, 5].
     *
     * @return the default tier
     */
	@Override
	public int tier() {
		return 4;
	}

    /**
     * This returns a new ItemStack holding the seed for this plant
     *
     * @return a new ItemStack
     */
	@Override
	public ItemStack getSeed() {
		return new ItemStack(AshenWheatCore.scintillaSeeds);
	}
	
    /**
     * This method should return all possible fruits for this crop.
     * It is used for the NEI handler and the journal
     *
     * @return an ArrayList holding all possible fruit drops for this crop, regardless of its stats
     */
	@Override
	public ArrayList<ItemStack> getAllFruits() {
		if (AgriScintillaWheat.allfruits.isEmpty()) {
			AgriScintillaWheat.allfruits.add(new ItemStack(AshenWheatCore.scintillaWheatSheaf));
		}
		return AgriScintillaWheat.allfruits;
	}

    /**
     * This method should return the Block for your in world crop, it is used to read data from.
     *
     * @return the Block implementation for this crop
     */
	@Override
	public Block getBlock() {
		return AshenWheatCore.scintillaWheatCrop;
	}

    /**
     * Returns a new ItemStack with a random fruit
     *
     * @param rand a Random object
     * @return a randomly selected fruit
     */
	@Override
	public ItemStack getRandomFruit(Random rand) {
		return new ItemStack(AshenWheatCore.scintillaWheatSheaf);
	}
	
    /**
     * Retrieves information about the plant for the seed journal.
     * It's possible to pass an unlocalized String, the returned value will be localized if possible.
     *
     * @return a string describing the plant for use by the seed journal.
     */
	@Override
	public String getInformation() {
		return "A sparkling golden wheat grain, seed of the Scintilla Wheat. "
				+ "This grain can be used for food and processed to create glowstone dust.";
	}

} // end class
