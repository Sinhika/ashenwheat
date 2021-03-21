package mod.akkamaddi.ashenwheat.loot;

import mod.akkamaddi.ashenwheat.Ashenwheat;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;

/**
 * Code that handles injecting seeds into chest loot pools.
 * Based heavily on Botania's LootHandler, without which I never would have
 * figured this out.
 * 
 */
public final class ChestLootHandler
{
    // lets figure out how to write a LootPool
    public static LootPool getInjectPool(String entryName) {
        return LootPool.lootPool()
                .add(getInjectEntry(entryName, 1))
                .bonusRolls(0, 1)
                .name("ashenwheat_inject")
                .build();
    }

    private static LootEntry.Builder<?> getInjectEntry(String name, int weight) {
        ResourceLocation table = new ResourceLocation(Ashenwheat.MODID, "inject/" + name);
        return TableLootEntry.lootTableReference(table)
                .setWeight(weight);
    }

} // end-class
