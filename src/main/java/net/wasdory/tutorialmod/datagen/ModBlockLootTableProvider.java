package net.wasdory.tutorialmod.datagen;

import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.THAUMIUM_BLOCK.get());
        dropSelf(ModBlocks.VOID_METAL_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_STONE.get());

        add(ModBlocks.AMBER_ORE.get(),
                block -> createOreDrop(ModBlocks.AMBER_ORE.get(), ModItems.AMBER.get()));
        add(ModBlocks.DEEPSLATE_AMBER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_AMBER_ORE.get(), ModItems.AMBER.get(), 2, 5));

        dropSelf(ModBlocks.MAGIC_STONE_STAIRS.get());
        add(ModBlocks.MAGIC_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MAGIC_STONE_SLAB.get()));

        dropSelf(ModBlocks.MAGIC_STONE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.MAGIC_STONE_BUTTON.get());

        dropSelf(ModBlocks.MAGIC_STONE_FENCE.get());
        dropSelf(ModBlocks.MAGIC_STONE_FENCE_GATE.get());
        dropSelf(ModBlocks.MAGIC_STONE_WALL.get());
        dropSelf(ModBlocks.MAGIC_STONE_TRAPDOOR.get());

        add(ModBlocks.MAGIC_STONE_DOOR.get(),
                block -> createDoorTable(ModBlocks.MAGIC_STONE_DOOR.get()));

        dropSelf(ModBlocks.THAUMIUM_LAMP_BLOCK.get());

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
