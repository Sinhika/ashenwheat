#!/bin/bash
# scripts are from mod_utils project on my GitHub.

TOPDIR=`pwd`

# loot tables for 'drop-self' blocks
cd ${TOPDIR}/src/main/resources/data/ashenwheat/loot_tables/blocks
make_loot_drops.py ash_wheat_bale
make_loot_drops.py scintilla_wheat_bale
make_loot_drops.py carved_ossid_root
make_loot_drops.py ossid_lantern
make_loot_drops.py ossid_root
# crop loot drops must be hand-tweaked.

# recipes
cd ${TOPDIR}/src/main/resources/data/ashenwheat/recipes
make_storage_recipes.py -n -i sheaf -b bale ash_wheat
make_storage_recipes.py -n -i sheaf -b bale scintilla_wheat

