package net.wasdory.tutorialmod.datagen;

import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.THAUMIUM.get());
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.VOID_METAL.get());

        basicItem(ModItems.ZOMBIE_BRAIN.get());
        basicItem(ModItems.ALUMENTUM.get());
        basicItem(ModItems.CHISEL.get());

        handheldItem(ModItems.THAUMIUM_SWORD);
        handheldItem(ModItems.THAUMIUM_SHOVEL);
        handheldItem(ModItems.THAUMIUM_PICKAXE);
        handheldItem(ModItems.THAUMIUM_AXE);
        handheldItem(ModItems.THAUMIUM_HOE);

        buttonItem(ModBlocks.MAGIC_STONE_BUTTON, ModBlocks.MAGIC_STONE);
        fenceItem(ModBlocks.MAGIC_STONE_FENCE, ModBlocks.MAGIC_STONE);
        wallItem(ModBlocks.MAGIC_STONE_WALL, ModBlocks.MAGIC_STONE);

        basicItem(ModBlocks.MAGIC_STONE_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
