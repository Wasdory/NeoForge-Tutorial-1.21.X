package net.wasdory.tutorialmod.item;

import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.item.custom.ChiselItem;
import net.wasdory.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> THAUMIUM = ITEMS.register("thaumium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VOID_METAL = ITEMS.register("void_metal",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tutorialmod.void_metal"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> ZOMBIE_BRAIN = ITEMS.register("zombie_brain",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ZOMBIE_BRAIN)));

    public static final DeferredItem<Item> ALUMENTUM = ITEMS.register("alumentum",
            () -> new FuelItem(new Item.Properties(), 6400));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
