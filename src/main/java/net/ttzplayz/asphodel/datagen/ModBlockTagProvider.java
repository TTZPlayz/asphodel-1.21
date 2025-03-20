package net.ttzplayz.asphodel.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.ttzplayz.asphodel.Asphodel;
import net.ttzplayz.asphodel.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Asphodel.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PALE_WILLOW_LOG.get())
                .add(ModBlocks.PALE_WILLOW_WOOD.get())
                .add(ModBlocks.STRIPPED_PALE_WILLOW_LOG.get())
                .add(ModBlocks.STRIPPED_PALE_WILLOW_WOOD.get())
                .add(ModBlocks.PALE_WILLOW_PLANKS.get())
                .add(ModBlocks.PEERING_PALE_WILLOW_LOG.get())
                .add(ModBlocks.GAZING_PALE_WILLOW_LOG.get())
                .add(ModBlocks.WHISPERING_PALE_WILLOW_LOG.get())
                .add(ModBlocks.PALE_WILLOW_STAIRS.get())
                .add(ModBlocks.PALE_WILLOW_SLAB.get())
                .add(ModBlocks.PALE_WILLOW_BUTTON.get())
                .add(ModBlocks.PALE_WILLOW_PRESSURE_PLATE.get())
                .add(ModBlocks.PALE_WILLOW_FENCE.get())
                .add(ModBlocks.PALE_WILLOW_FENCE_GATE.get())
                .add(ModBlocks.PALE_WILLOW_DOOR.get())
                .add(ModBlocks.PALE_WILLOW_TRAPDOOR.get());
                // add sign and hanging sign
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RESIN_CLUMP.get())
                .add(ModBlocks.RESIN_BLOCK.get())
                .add(ModBlocks.RESIN_BRICKS.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.PALE_MOSS_BLOCK.get())
                .add(ModBlocks.PALE_WILLOW_LEAVES.get())
                .add(ModBlocks.PALE_MOSS_CARPET.get());
// NON-BLOCKS (PALE WILLOW)
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALE_WILLOW_FENCE.get())
                .add(ModBlocks.PALE_WILLOW_FENCE_GATE.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALE_WILLOW_BUTTON.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.PALE_WILLOW_DOOR.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PALE_WILLOW_SLAB.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALE_WILLOW_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PALE_WILLOW_STAIRS.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALE_WILLOW_TRAPDOOR.get());
        tag(BlockTags.SIGNS);
        // add sign and hanging sign


    }
}
