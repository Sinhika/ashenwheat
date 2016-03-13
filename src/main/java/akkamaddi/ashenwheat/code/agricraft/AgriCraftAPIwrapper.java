package akkamaddi.ashenwheat.code.agricraft;

import com.InfinityRaider.AgriCraft.api.example.ExampleAgriCraftAPIimplementation;
import com.InfinityRaider.AgriCraft.api.v1.IGrowthRequirement;

import cpw.mods.fml.common.Loader;

/**
 * Based on example implementation of how to use the AgriCraft API.
 */
public class AgriCraftAPIwrapper 
{
	private static AgriCraftAPIwrapper instance;
	
    /**
     * This method returns the wrapper instance, and initializes it if hasn't been initialized yet
     * If AgriCraft is not present, it sets it to a placeholder (which is this class) which returns default values and never references the AgriCraft API.
     * If AgriCraft is loaded, it sets it to an actual class forwarding the calls to the AgriCraft API (see the  {@link ExampleAgriCraftAPIimplementation} class)
     *
     * @return the AgriCraftAPI wrapper
     */
    public static AgriCraftAPIwrapper getInstance() {
        if(instance == null) {
            if(Loader.isModLoaded("AgriCraft")) {
                instance = new AgriCraftAPIimplementation();
            } else {
                instance = new AgriCraftAPIwrapper();
            }
        }
        return instance;
    }

    protected AgriCraftAPIwrapper() {}
    
    /**
     * Define methods here which return values that you need, override them in the class which does reference AgriCraft API methods.
     * Here they should just return a default value whichever fits your application.
     *
     * If you need to work with implementations of interfaces, you can use the ever so handy {@Link Optional.Interface} annotation
     */

    /**
     * Method to check if the API is properly wrapped -- it isn't.
     */
    public boolean isOk() {
        return false;
    }
    
    /**
     * @return null, because this is a wrapper
     */
	public IGrowthRequirement createDefaultGrowthRequirement() {
		return null;
	}	

    /**
     * Register a cropPlant for AgriCraft to recognise as a valid plant for crops
     */
    public void registerCropPlant(AgriAkkamaddiCrop akkaCrop) {}

//    /**
//     * Example method, this one gets the stats of a crop
//     */
//    public SeedStats GetSeedStats(World world, int x, int y, int z) {
//        return new SeedStats((short) -1, (short) -1, (short) -1, false);
//    }
//
//    /**
//     * Example method, this one gets the stat cap imposed to agricraft
//     */
//    public short GetSeedStatsCap() {
//        return -1;
//    }


} // end class APIwrapper
