package net.wasdory.tutorialmod.datagen;

import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.block.custom.ThaumiumLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.THAUMIUM_BLOCK);
        blockWithItem(ModBlocks.VOID_METAL_BLOCK);

        blockWithItem(ModBlocks.AMBER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE);

        blockWithItem(ModBlocks.ARCANE_BLOCK);
        blockWithItem(ModBlocks.MAGIC_STONE);

        stairsBlock(ModBlocks.MAGIC_STONE_STAIRS.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        slabBlock(ModBlocks.MAGIC_STONE_SLAB.get(), blockTexture(ModBlocks.MAGIC_STONE.get()), blockTexture(ModBlocks.MAGIC_STONE.get()));

        buttonBlock(ModBlocks.MAGIC_STONE_BUTTON.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        pressurePlateBlock(ModBlocks.MAGIC_STONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));

        fenceBlock(ModBlocks.MAGIC_STONE_FENCE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        fenceGateBlock(ModBlocks.MAGIC_STONE_FENCE_GATE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        wallBlock(ModBlocks.MAGIC_STONE_WALL.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));

        doorBlockWithRenderType(ModBlocks.MAGIC_STONE_DOOR.get(), modLoc("block/magic_stone_door_bottom"), modLoc("block/magic_stone_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.MAGIC_STONE_TRAPDOOR.get(), modLoc("block/magic_stone_trapdoor"), true, "cutout");

        blockItem(ModBlocks.MAGIC_STONE_STAIRS);
        blockItem(ModBlocks.MAGIC_STONE_SLAB);
        blockItem(ModBlocks.MAGIC_STONE_PRESSURE_PLATE);
        blockItem(ModBlocks.MAGIC_STONE_FENCE_GATE);
        blockItem(ModBlocks.MAGIC_STONE_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.THAUMIUM_LAMP_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(ThaumiumLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thaumium_lamp_block_on",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "thaumium_lamp_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thaumium_lamp_block_off",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "thaumium_lamp_block_off")))};
            }
        });

        simpleBlockItem(ModBlocks.THAUMIUM_LAMP_BLOCK.get(), models().cubeAll("thaumium_lamp_block_on",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "thaumium_lamp_block_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
