package net.wasdory.tutorialmod.datagen;

import net.minecraft.tags.ItemTags;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.item.ModItems;
import net.wasdory.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.THAUMIUM.get())
                .add(ModItems.AMBER.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.THAUMIUM_SWORD.asItem());
        tag(ItemTags.PICKAXES)
                .add(ModItems.THAUMIUM_PICKAXE.asItem());
        tag(ItemTags.SHOVELS)
                .add(ModItems.THAUMIUM_SHOVEL.asItem());
        tag(ItemTags.AXES)
                .add(ModItems.THAUMIUM_AXE.asItem());
        tag(ItemTags.HOES)
                .add(ModItems.THAUMIUM_HOE.asItem());

    }
}
