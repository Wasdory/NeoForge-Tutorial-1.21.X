package net.wasdory.tutorialmod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.item.custom.ChiselItem;
import net.wasdory.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wasdory.tutorialmod.item.custom.HammerItem;
import net.wasdory.tutorialmod.item.custom.ModArmorItem;

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
                    .attributes(HoeItem.createAttributes(ModToolTiers.THAUMIUM, -2.5f, -1f))));

    public static final DeferredItem<HammerItem> THAUMIUM_HAMMER = ITEMS.register("thaumium_hammer",
            () -> new HammerItem(ModToolTiers.THAUMIUM_HAMMER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.THAUMIUM_HAMMER, 6.5f, -3.5f))));

    public static final DeferredItem<ArmorItem> THAUMIUM_HELMET = ITEMS.register("thaumium_helmet",
            () -> new ArmorItem(ModArmorMaterials.THAUMIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(23))));
    public static final DeferredItem<ArmorItem> THAUMIUM_CHESTPLATE = ITEMS.register("thaumium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.THAUMIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(23))));
    public static final DeferredItem<ArmorItem> THAUMIUM_LEGGINGS = ITEMS.register("thaumium_leggings",
            () -> new ArmorItem(ModArmorMaterials.THAUMIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(23))));
    public static final DeferredItem<ArmorItem> THAUMIUM_BOOTS = ITEMS.register("thaumium_boots",
            () -> new ArmorItem(ModArmorMaterials.THAUMIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(23))));

    public static final DeferredItem<ArmorItem> FORTRESS_HELMET = ITEMS.register("fortress_helmet",
            () -> new ModArmorItem(ModArmorMaterials.FORTRESS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(30))));
    public static final DeferredItem<ArmorItem> FORTRESS_CHESTPLATE = ITEMS.register("fortress_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.FORTRESS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));
    public static final DeferredItem<ArmorItem> FORTRESS_LEGGINGS = ITEMS.register("fortress_leggings",
            () -> new ModArmorItem(ModArmorMaterials.FORTRESS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));
    public static final DeferredItem<ArmorItem> FORTRESS_BOOTS = ITEMS.register("fortress_boots",
            () -> new ModArmorItem(ModArmorMaterials.FORTRESS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(30))));

    public static final DeferredItem<Item> THAUMIUM_HORSE_ARMOR = ITEMS.register("thaumium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.THAUMIUM_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> KWA_SMITHING_TEMPLATE = ITEMS.register( "kwa_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kwa")));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
