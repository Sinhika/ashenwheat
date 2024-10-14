package mod.akkamaddi.ashenwheat.loot;

import mod.alexndr.simplecorelib.api.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class WheatInjectionLookup extends InjectionTableLookup
{

    public WheatInjectionLookup()
    {
        super();
        this.put("simple_dungeon", "simple_dungeon");
        this.put("stronghold_corridor", "simple_dungeon");
        this.put("stronghold_crossing", "simple_dungeon");
        this.put("buried_treasure", "simple_dungeon");
        this.put("abandoned_mineshaft", "abandoned_mineshaft");
        this.put("desert_pyramid", "desert_pyramid");
        this.put("jungle_temple", "jungle_temple");
        this.put("igloo_chest", "igloo_chest");
        AddDungeonAliases();
        AddVillageHouseAliases();
    } // end ctor

} // end class
