package net.ttzplayz.asphodel.datagen;

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
import net.ttzplayz.asphodel.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // For copying: dropSelf(ModBlocks.X.get());
        dropSelf(ModBlocks.PALE_MOSS_BLOCK.get());
        dropSelf(ModBlocks.PALE_MOSS_CARPET.get());
        dropSelf(ModBlocks.PALE_WILLOW_LOG.get());
        dropSelf(ModBlocks.PALE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALE_WILLOW_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALE_WILLOW_WOOD.get());
        dropSelf(ModBlocks.PALE_WILLOW_PLANKS.get());
        dropSelf(ModBlocks.PALE_WILLOW_LEAVES.get());
        dropSelf(ModBlocks.PEERING_PALE_WILLOW_LOG.get());
        dropSelf(ModBlocks.GAZING_PALE_WILLOW_LOG.get());
        dropSelf(ModBlocks.WHISPERING_PALE_WILLOW_LOG.get());

        dropSelf(ModBlocks.PALE_WILLOW_STAIRS.get());
        add(ModBlocks.PALE_WILLOW_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALE_WILLOW_SLAB.get()));
        dropSelf(ModBlocks.PALE_WILLOW_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PALE_WILLOW_BUTTON.get());
        dropSelf(ModBlocks.PALE_WILLOW_FENCE.get());
        dropSelf(ModBlocks.PALE_WILLOW_FENCE_GATE.get());
        add(ModBlocks.PALE_WILLOW_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALE_WILLOW_DOOR.get()));
        dropSelf(ModBlocks.PALE_WILLOW_TRAPDOOR.get());
        // add sign and hanging sign

        dropSelf(ModBlocks.RESIN_CLUMP.get());
        dropSelf(ModBlocks.RESIN_BLOCK.get());
        dropSelf(ModBlocks.RESIN_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_RESIN_BRICKS.get());

        dropSelf(ModBlocks.RESIN_BRICK_STAIRS.get());
        dropSelf(ModBlocks.RESIN_BRICK_SLAB.get());
        dropSelf(ModBlocks.RESIN_BRICK_WALL.get());

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