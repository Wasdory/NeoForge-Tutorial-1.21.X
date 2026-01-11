package net.wasdory.tutorialmod.datagen;

import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> AMBER_SMELTABLES = List.of(ModItems.AMBER,
                ModBlocks.AMBER_ORE, ModBlocks.DEEPSLATE_AMBER_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THAUMIUM_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.THAUMIUM.get())
                .unlockedBy("has_thaumium_ignot", has(ModItems.THAUMIUM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THAUMIUM.get(), 9)
                .requires(ModBlocks.THAUMIUM_BLOCK)
                .unlockedBy("has_thaumium_block", has(ModBlocks.THAUMIUM_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THAUMIUM.get(), 18)
                .requires(ModBlocks.ARCANE_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.ARCANE_BLOCK))
                .save(recipeOutput, "tutorialmod:thaumium_from_arcane_block");

        oreSmelting(recipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.THAUMIUM.get(), 0.25f, 200, "amber");
        oreBlasting(recipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.THAUMIUM.get(), 0.25f, 100, "amber");

        stairBuilder(ModBlocks.MAGIC_STONE_STAIRS.get(), Ingredient.of(ModBlocks.MAGIC_STONE)).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_STONE_SLAB.get(), ModBlocks.MAGIC_STONE.get());

        buttonBuilder(ModBlocks.MAGIC_STONE_BUTTON.get(), Ingredient.of(ModBlocks.MAGIC_STONE.get())).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.MAGIC_STONE_PRESSURE_PLATE.get(), ModBlocks.MAGIC_STONE.get());

        fenceBuilder(ModBlocks.MAGIC_STONE_FENCE.get(), Ingredient.of(ModBlocks.MAGIC_STONE.get())).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.MAGIC_STONE_FENCE_GATE.get(), Ingredient.of(ModBlocks.MAGIC_STONE.get())).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGIC_STONE_WALL.get(), ModBlocks.MAGIC_STONE.get());

        doorBuilder(ModBlocks.MAGIC_STONE_DOOR.get(), Ingredient.of(ModBlocks.MAGIC_STONE.get())).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.MAGIC_STONE_TRAPDOOR.get(), Ingredient.of(ModBlocks.MAGIC_STONE.get())).group("magic_stone")
                .unlockedBy("has_magic_stone", has(ModBlocks.MAGIC_STONE.get())).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
