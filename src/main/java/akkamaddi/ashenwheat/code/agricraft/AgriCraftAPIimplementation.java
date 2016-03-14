package akkamaddi.ashenwheat.code.agricraft;

import net.minecraft.item.ItemStack;

import com.InfinityRaider.AgriCraft.api.API;
import com.InfinityRaider.AgriCraft.api.APIBase;
import com.InfinityRaider.AgriCraft.api.v1.IGrowthRequirement;
import com.InfinityRaider.AgriCraft.api.v2.APIv2;

public class AgriCraftAPIimplementation extends AgriCraftAPIwrapper 
{
    private APIv2 api;
    private boolean ok;

    /**
     * Constructor grabs the wanted API version and checks if it is correctly initialized
     */
    protected AgriCraftAPIimplementation() {
        super();
        APIBase apiObj = API.getAPI(2);
        if(apiObj != null && (apiObj instanceof APIv2)) {
            api = (APIv2) apiObj;
            ok = api.getStatus().isOK();
        } else {
            ok = false;
        }
    } // end ctor()
    
    /**
     * Here are the actual implementations for the methods you need to call API methods
     * Note the isOk() calls, this is not necessary, but guarantees that your implementation will not start returning values you don't expect,
     * for instance when the api version you use becomes {@Link APIStatus.ERROR} or {@Link APIStatus.BACKLEVEL_UNSUPPORTED}
     */

    /**
     * Method to check if the API is properly wrapped
     */
    @Override
    public boolean isOk() {
        return ok;
    }

    /**
     * @return a new IGrowthRequirement object which has default vanilla behaviour, 
     * meaning no base block, soil is farmland and requires brightness
     */
    @Override
	public IGrowthRequirement createDefaultGrowthRequirement() 
	{
		if (isOk()) {
			return api.createDefaultGrowthRequirement();
		}
		else {
			return super.createDefaultGrowthRequirement();
		}
	}
    
    /**
     * Register a cropPlant for AgriCraft to recognise as a valid plant for crops
     */
    @Override
	public void registerCropPlant(AgriAkkamaddiCrop akkaCrop) {
		if (isOk()) {
			api.registerCropPlant(akkaCrop);
		}
		else {
			super.registerCropPlant(akkaCrop);
		}
    }
    
    /**
     * Registers a new mutation: result = parent1 + parent2
     * @param result ItemStack containing the resulting seed of the mutation
     * @param parent1 ItemStack containing one parent for the mutation
     * @param parent2 ItemStack containing the other parent for the mutation
     * @return True if successful
     */
    @Override
    public boolean registerMutation(ItemStack result, ItemStack parent1, ItemStack parent2)
    {
		if (isOk()) {
			return api.registerMutation(result, parent1, parent2);
		}
		else {
			return super.registerMutation(result, parent1, parent2);
		}
    }
	
    /**
     * Example method, this one gets the stats of a crop
     */
//    @Override
//    public SeedStats GetSeedStats(World world, int x, int y, int z) {
//        if(isOk()) {
//            ISeedStats stats = api.getStats(world, x, y ,z);
//            return new SeedStats(stats.getGrowth(), stats.getGain(), stats.getStrength(), stats.isAnalyzed());
//        } else {
//            return super.GetSeedStats(world, x, y, z);
//        }
//    }
//
//    /**
//     * Example method, this one gets the stat cap imposed to agricraft
//     */
//    @Override
//    public short GetSeedStatsCap() {
//        return isOk()?api.getStatCap():super.GetSeedStatsCap();
//    }


} // end class
