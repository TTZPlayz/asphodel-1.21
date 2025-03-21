package net.ttzplayz.asphodel.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ttzplayz.asphodel.Asphodel;
import net.ttzplayz.asphodel.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(Asphodel.MOD_ID);
    // BLOCKS

    // PALE MOSS

    public static final DeferredBlock<Block> PALE_MOSS_BLOCK = registerBlock("pale_moss_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS)));

    public static final DeferredBlock<Block> PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS_CARPET)));

    // PALE WILLOW BLOCKS

    public static final DeferredBlock<Block> PALE_WILLOW_LOG = registerBlock("pale_willow_log",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PALE_WILLOW_WOOD = registerBlock("pale_willow_wood",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PALE_WILLOW_LOG = registerBlock("stripped_pale_willow_log",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> STRIPPED_PALE_WILLOW_WOOD = registerBlock("stripped_pale_willow_wood",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PALE_WILLOW_PLANKS = registerBlock("pale_willow_planks",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PALE_WILLOW_LEAVES = registerBlock("pale_willow_leaves",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> PEERING_PALE_WILLOW_LOG = registerBlock("peering_pale_willow_log",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> GAZING_PALE_WILLOW_LOG = registerBlock("gazing_pale_willow_log",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> WHISPERING_PALE_WILLOW_LOG = registerBlock("whispering_pale_willow_log",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    // PALE WILLOW NON-BLOCKS

    public static final DeferredBlock<StairBlock> PALE_WILLOW_STAIRS = registerBlock("pale_willow_stairs",
            () -> new StairBlock(ModBlocks.PALE_WILLOW_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)));

    public static final DeferredBlock<SlabBlock> PALE_WILLOW_SLAB = registerBlock("pale_willow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f)));

    public static final DeferredBlock<PressurePlateBlock> PALE_WILLOW_PRESSURE_PLATE = registerBlock("pale_willow_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<ButtonBlock> PALE_WILLOW_BUTTON = registerBlock("pale_willow_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK, 20, BlockBehaviour.Properties.of().strength(2f).noCollission()));

    public static final DeferredBlock<FenceBlock> PALE_WILLOW_FENCE = registerBlock("pale_willow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<FenceGateBlock> PALE_WILLOW_FENCE_GATE = registerBlock("pale_willow_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<DoorBlock> PALE_WILLOW_DOOR = registerBlock("pale_willow_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> PALE_WILLOW_TRAPDOOR = registerBlock("pale_willow_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    // add sign and hanging sign


    // RESIN BLOCKS

    //edit to tile-block
    public static final DeferredBlock<Block> RESIN_CLUMP = registerBlock("resin_clump",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).noCollission().strength(0)));

    public static final DeferredBlock<Block> RESIN_BLOCK = registerBlock("resin_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> RESIN_BRICKS = registerBlock("resin_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<Block> CHISELED_RESIN_BRICKS = registerBlock("chiseled_resin_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    // RESIN NON-BLOCKS

    public static final DeferredBlock<StairBlock> RESIN_BRICK_STAIRS = registerBlock("resin_brick_stairs",
            () -> new StairBlock(ModBlocks.RESIN_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<SlabBlock> RESIN_BRICK_SLAB = registerBlock("resin_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final DeferredBlock<WallBlock> RESIN_BRICK_WALL = registerBlock("resin_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));


    //END OF BLOCKS

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
