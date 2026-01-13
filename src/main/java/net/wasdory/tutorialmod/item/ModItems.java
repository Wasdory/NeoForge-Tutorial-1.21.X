package net.wasdory.tutorialmod.item;

import net.minecraft.world.item.*;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.item.custom.ChiselItem;
import net.wasdory.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
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

    public static final DeferredItem<SwordItem> THAUMIUM_SWORD = ITEMS.register("thaumium_sword",
            () -> new SwordItem(ModToolTiers.THAUMIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.THAUMIUM, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> THAUMIUM_PICKAXE = ITEMS.register("thaumium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.THAUMIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.THAUMIUM, 1f, -2.8f))));
    public static final DeferredItem<ShovelItem> THAUMIUM_SHOVEL = ITEMS.register("thaumium_shovel",
            () -> new ShovelItem(ModToolTiers.THAUMIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.THAUMIUM, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> THAUMIUM_AXE = ITEMS.register("thaumium_axe",
            () -> new AxeItem(ModToolTiers.THAUMIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.THAUMIUM, 5.5f, -3.1f))));
    public static final DeferredItem<HoeItem> THAUMIUM_HOE = ITEMS.register("thaumium_hoe",
            () -> new HoeItem(ModToolTiers.THAUMIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.THAUMIUM, -2.5f, 0f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
