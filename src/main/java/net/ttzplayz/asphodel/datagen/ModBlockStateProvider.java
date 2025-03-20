package net.ttzplayz.asphodel.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.ttzplayz.asphodel.Asphodel;
import net.ttzplayz.asphodel.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Asphodel.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // For copying: blockWithItem(ModBlocks.X());
        blockWithItem(ModBlocks.PALE_MOSS_BLOCK);
        blockWithItem(ModBlocks.PALE_MOSS_CARPET);
        blockWithItem(ModBlocks.PALE_WILLOW_LOG);
        blockWithItem(ModBlocks.PALE_WILLOW_WOOD);
        blockWithItem(ModBlocks.STRIPPED_PALE_WILLOW_LOG);
        blockWithItem(ModBlocks.STRIPPED_PALE_WILLOW_WOOD);
        blockWithItem(ModBlocks.PALE_WILLOW_PLANKS);
        blockWithItem(ModBlocks.PALE_WILLOW_LEAVES);
        blockWithItem(ModBlocks.PEERING_PALE_WILLOW_LOG);
        blockWithItem(ModBlocks.GAZING_PALE_WILLOW_LOG);
        blockWithItem(ModBlocks.WHISPERING_PALE_WILLOW_LOG);

        stairsBlock(ModBlocks.PALE_WILLOW_STAIRS.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));
        slabBlock(ModBlocks.PALE_WILLOW_SLAB.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));

        buttonBlock(ModBlocks.PALE_WILLOW_BUTTON.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PALE_WILLOW_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));

        fenceBlock(ModBlocks.PALE_WILLOW_FENCE.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));
        fenceGateBlock(ModBlocks.PALE_WILLOW_FENCE_GATE.get(), blockTexture(ModBlocks.PALE_WILLOW_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.PALE_WILLOW_DOOR.get(), modLoc("block/pale_willow_door_bottom"), modLoc("block/pale_willow_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALE_WILLOW_TRAPDOOR.get(), modLoc("block/pale_willow_trapdoor"), true, "cutout");

        blockItem(ModBlocks.PALE_WILLOW_STAIRS);
        blockItem(ModBlocks.PALE_WILLOW_SLAB);
        blockItem(ModBlocks.PALE_WILLOW_PRESSURE_PLATE);
        blockItem(ModBlocks.PALE_WILLOW_FENCE_GATE);
        blockItem(ModBlocks.PALE_WILLOW_TRAPDOOR, "_bottom");
        // add sign and hanging sign

        blockWithItem(ModBlocks.RESIN_CLUMP);
        blockWithItem(ModBlocks.RESIN_BLOCK);
        blockWithItem(ModBlocks.RESIN_BRICKS);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("asphodel:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("asphodel:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }



    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
