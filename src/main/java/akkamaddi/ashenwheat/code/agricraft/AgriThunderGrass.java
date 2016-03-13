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
 * ICropPlant object for ThunderGrassCrop/Seeds.
 *
 */
@SuppressWarnings("deprecation")
@Optional.Interface(modid = "AgriCraft", iface = "com.InfinityRaider.AgriCraft.api.v2.ICropPlant")
public class AgriThunderGrass extends AgriAkkamaddiCrop implements ICropPlant 
{
	private static final ArrayList<ItemStack> allfruits = new ArrayList<ItemStack>();

    /**
     * This returns a new ItemStack holding the seed for this plant
     *
     * @return a new ItemStack
     */
	@Override
	public ItemStack getSeed() {
		return new ItemStack(AshenWheatCore.thunderSeeds);
	}
	
    /**
     * This method should return all possible fruits for this crop.
     * It is used for the NEI handler and the journal
     *
     * @return an ArrayList holding all possible fruit drops for this crop, regardless of its stats
     */
	@Override
	public ArrayList<ItemStack> getAllFruits() {
		if (AgriThunderGrass.allfruits.isEmpty()) {
			AgriThunderGrass.allfruits.add(new ItemStack(AshenWheatCore.thunderSeeds));
		}
		return AgriThunderGrass.allfruits;
	}

    /**
     * This method should return the Block for your in world crop, it is used to read data from.
     *
     * @return the Block implementation for this crop
     */
	@Override
	public Block getBlock() {
		return AshenWheatCore.thunderGrassCrop;
	}

    /**
     * Returns a new ItemStack with a random fruit
     *
     * @param rand a Random object
     * @return a randomly selected fruit
     */
	@Override
	public ItemStack getRandomFruit(Random rand) {
		return new ItemStack(AshenWheatCore.thunderSeeds);
	}
	
    /**
     * Retrieves information about the plant for the seed journal.
     * It's possible to pass an unlocalized String, the returned value will be localized if possible.
     *
     * @return a string describing the plant for use by the seed journal.
     */
	@Override
	public String getInformation() {
		return "The tiny black seed of Thunder Grass. The seeds can be processed to produce gunpowder.";
	}

} // end class
