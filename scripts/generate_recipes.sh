#!/bin/bash
# scripts are from mod_utils project on my GitHub.

TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != 'Ashenwheat' ]; then
    echo "Running in wrong directory!"
    exit 1
fi

#TARGETDIR = ${TOPDIR}/src/main/resources/data/ashenwheat/loot_tables/blocks
#if [ ! -d $TARGETDIR ]; then
#    mkdir -p $TARGETDIR
#fi

# loot tables for 'drop-self' blocks
#cd $TARGETDIR
#make_loot_drops.py ash_wheat_bale
#make_loot_drops.py scintilla_wheat_bale
#make_loot_drops.py carved_ossid_root
#make_loot_drops.py ossid_lantern
#make_loot_drops.py ossid_root
# crop loot drops must be hand-tweaked.

# recipes

TARGETDIR=${TOPDIR}/src/main/resources/data/ashenwheat/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR
#make_storage_recipes.py -n -i sheaf -b bale ash_wheat
#make_storage_recipes.py -n -i sheaf -b bale scintilla_wheat
#make_custom_recipes.py -t shaped -p "AAA" -k "A=ashenwheat:ash_wheat_sheaf" ash_bread 1
#make_custom_recipes.py -t shaped -p "WCW" -k "W=ashenwheat:ash_wheat_sheaf;C=minecraft:cocoa_beans" ash_cookie 8
#make_custom_recipes.py -t shapeless -i "ashenwheat:ash_wheat_sheaf" -n 1 ash_seeds 2
#make_custom_recipes.py -t shaped -p "AAA" -k "A=ashenwheat:scintilla_wheat_sheaf" scintilla_bread 1
#make_custom_recipes.py -t shaped -p "WCW" -k "W=ashenwheat:scintilla_wheat_sheaf;C=minecraft:cocoa_beans" scintilla_cookie 8
#make_custom_recipes.py -t shapeless -i "ashenwheat:scintilla_wheat_sheaf" -n 1 scintilla_seeds 2
#make_custom_recipes.py -t shaped -p "AA,AA" -k "A=ashenwheat:scintillating_ash" glowstone_dust 1
#make_custom_recipes.py -t shaped -p "A,T" -k "A=ashenwheat:carved_ossid_root;T=minecraft:torch" ossid_lantern 1
#make_custom_recipes.py -t shapeless -i "ashenwheat:ossid_root" -n 1 ossid_seeds 4
#make_custom_recipes.py -t shaped -p "AA,AA" -k "A=ashenwheat:calcified_ash" bonemeal 1
#make_custom_recipes.py -t shaped -p "AAA,AAA,AAA" -k "A=ashenwheat:unstable_soot" gunpowder 1
make_custom_recipes.py -t shaped -p "AA,AA" -k "A=ashenwheat:unstable_soot" black_dye 1
##
#make_custom_recipes.py -t smelting -i "ashenwheat:ash_bread" --xp 0.5 charcoal 1
##
#make_custom_recipes.py -t smelting -i "ashenwheat:scintilla_wheat_bale" --xp 0.5 scintillating_ash 1
##
#make_custom_recipes.py -t smelting -i "ashenwheat:ossid_root" --xp 0.4 calcified_ash 1
##
#make_custom_recipes.py -t smelting -i "ashenwheat:thunder_seeds" --xp 0.4 unstable_soot 1

