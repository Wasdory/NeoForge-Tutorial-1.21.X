package net.wasdory.tutorialmod.item;

import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> THAUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("thaum_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.THAUMIUM.get()))
                    .title(Component.translatable("creativetab.tutorialmod.thaum_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.THAUMIUM);
                        output.accept(ModItems.AMBER);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.ZOMBIE_BRAIN);

                        output.accept(ModItems.ALUMENTUM);
                    }).build());

    public static final Supplier<CreativeModeTab> THAUM_BLOCK_TAB = CREATIVE_MODE_TAB.register("thaum_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.THAUMIUM_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "thaum_items_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.thaum_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.THAUMIUM_BLOCK);
                        output.accept(ModBlocks.AMBER_ORE);
                        output.accept(ModBlocks.DEEPSLATE_AMBER_ORE);

                        output.accept(ModBlocks.MAGIC_STONE);

                        output.accept(ModBlocks.MAGIC_STONE_STAIRS);
                        output.accept(ModBlocks.MAGIC_STONE_SLAB);

                        output.accept(ModBlocks.MAGIC_STONE_PRESSURE_PLATE);
                        output.accept(ModBlocks.MAGIC_STONE_BUTTON);

                        output.accept(ModBlocks.MAGIC_STONE_FENCE);
                        output.accept(ModBlocks.MAGIC_STONE_FENCE_GATE);
                        output.accept(ModBlocks.MAGIC_STONE_WALL);

                        output.accept(ModBlocks.MAGIC_STONE_DOOR);
                        output.accept(ModBlocks.MAGIC_STONE_TRAPDOOR);

                        output.accept(ModBlocks.THAUMIUM_LAMP_BLOCK);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
