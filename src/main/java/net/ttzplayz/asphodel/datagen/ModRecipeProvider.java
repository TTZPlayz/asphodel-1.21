package net.ttzplayz.asphodel.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.ttzplayz.asphodel.Asphodel;
import net.ttzplayz.asphodel.block.ModBlocks;
import net.ttzplayz.asphodel.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> RESIN_SMELTABLES = List.of(ModBlocks.RESIN_CLUMP);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALE_WILLOW_WOOD.get(), 4)
                .pattern("LL")
                .pattern("LL")
                .define('L', ModBlocks.PALE_WILLOW_LOG.get())
                .unlockedBy("has_pale_willow_log", has(ModBlocks.PALE_WILLOW_LOG))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PALE_WILLOW_PLANKS.get(), 4)
                .requires(ModBlocks.PALE_WILLOW_LOG)
                .unlockedBy("has_pale_willow_log", has(ModBlocks.PALE_WILLOW_LOG))
                .save(recipeOutput);
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PALE_WILLOW_PLANKS.get(), 4)
                .requires(ModBlocks.PALE_WILLOW_WOOD)
                .unlockedBy("has_pale_willow_wood", has(ModBlocks.PALE_WILLOW_WOOD))
                .save(recipeOutput, "asphodel:pale_willow_planks_from_pale_willow_wood");
        oreSmelting(recipeOutput, RESIN_SMELTABLES, RecipeCategory.MISC, ModItems.RESIN_BRICK.get(), 0.25F, 200, "resin");
        oreBlasting(recipeOutput, RESIN_SMELTABLES, RecipeCategory.MISC, ModItems.RESIN_BRICK.get(), 0.25F, 100, "resin");

        stairBuilder(ModBlocks.PALE_WILLOW_STAIRS.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS)).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_WILLOW_SLAB.get(), ModBlocks.PALE_WILLOW_PLANKS.get());
        pressurePlate(recipeOutput, ModBlocks.PALE_WILLOW_PRESSURE_PLATE.get(), ModBlocks.PALE_WILLOW_PLANKS.get());
        buttonBuilder(ModBlocks.PALE_WILLOW_BUTTON.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS.get())).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS.get())).save(recipeOutput);

        fenceBuilder(ModBlocks.PALE_WILLOW_FENCE.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS.get())).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PALE_WILLOW_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS.get())).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS.get())).save(recipeOutput);
        doorBuilder(ModBlocks.PALE_WILLOW_DOOR.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS.get())).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALE_WILLOW_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALE_WILLOW_PLANKS.get())).group("pale_willow")
                .unlockedBy("has_pale_willow_planks", has(ModBlocks.PALE_WILLOW_PLANKS.get())).save(recipeOutput);

        // add sign and hanging sign
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
                    .save(recipeOutput, Asphodel.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
