package net.wasdory.tutorialmod.item;

import net.wasdory.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier THAUMIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_THAUMIUM_TOOL,
            400, 6.5f, 2.5f, 25, () -> Ingredient.of(ModItems.THAUMIUM));

}