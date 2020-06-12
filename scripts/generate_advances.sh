#!/bin/bash
# scripts are from mod_utils project on my GitHub.

TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != 'Ashenwheat' ]; then
    echo "Running in wrong directory!"
    exit 1
fi

TARGETDIR=${TOPDIR}/src/main/resources/data/ashenwheat/advancements/recipes

# generate recipe advancements
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR
make_recipe_advancements.py -i ashenwheat:ash_wheat_sheaf ashenwheat:ash_bread \
    ashenwheat:ash_cookie ashenwheat:ash_seeds
make_recipe_advancements.py -i ashenwheat:ash_bread ashenwheat:charcoal_from_smelting
make_recipe_advancements.py -i ashenwheat:ash_wheat_bale ashenwheat:ash_wheat_sheaf
make_recipe_advancements.py -i ashenwheat:scintilla_wheat_sheaf \
    ashenwheat:scintilla_bread ashenwheat:scintilla_cookie \
    ashenwheat:scintilla_seeds ashenwheat:scintilla_wheat_bale
make_recipe_advancements.py -i ashenwheat:scintilla_wheat_bale \
    ashenwheat:scintillating_ash_from_smelting ashenwheat:scintilla_wheat_sheaf
make_recipe_advancements.py -i ashenwheat:scintillating_ash ashenwheat:glowstone_dust
make_recipe_advancements.py -i ashenwheat:ossid_root ashenwheat:ossid_seeds \
    ashenwheat:ossid_lantern ashenwheat:calcified_ash_from_smelting
make_recipe_advancements.py -i ashenwheat:calcified_ash ashenwheat:bonemeal
make_recipe_advancements.py -i ashenwheat:thunder_seeds ashenwheat:unstable_soot_from_smelting
make_recipe_advancements.py -i ashenwheat:unstable_soot ashenwheat:gunpowder \
    ashenwheat:black_dye
