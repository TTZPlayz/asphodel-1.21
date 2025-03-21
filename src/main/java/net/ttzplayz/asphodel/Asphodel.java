package net.ttzplayz.asphodel;

import net.ttzplayz.asphodel.block.ModBlocks;
import net.ttzplayz.asphodel.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Asphodel.MOD_ID)
public class Asphodel {
    public static final String MOD_ID = "asphodel";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Asphodel(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.FOG_BERRIES);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModBlocks.RESIN_CLUMP);
            event.accept(ModItems.RESIN_BRICK);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PALE_MOSS_BLOCK);
            event.accept(ModBlocks.PALE_MOSS_CARPET);
            event.accept(ModBlocks.PALE_WILLOW_LOG);
            event.accept(ModBlocks.PALE_WILLOW_WOOD);
            event.accept(ModBlocks.STRIPPED_PALE_WILLOW_LOG);
            event.accept(ModBlocks.STRIPPED_PALE_WILLOW_WOOD);
            event.accept(ModBlocks.PALE_WILLOW_PLANKS);
            event.accept(ModBlocks.PALE_WILLOW_LEAVES);
            event.accept(ModBlocks.PEERING_PALE_WILLOW_LOG);
            event.accept(ModBlocks.GAZING_PALE_WILLOW_LOG);
            event.accept(ModBlocks.WHISPERING_PALE_WILLOW_LOG);

            event.accept(ModBlocks.PALE_WILLOW_STAIRS);
            event.accept(ModBlocks.PALE_WILLOW_SLAB);
            event.accept(ModBlocks.PALE_WILLOW_PRESSURE_PLATE);
            event.accept(ModBlocks.PALE_WILLOW_BUTTON);
            event.accept(ModBlocks.PALE_WILLOW_FENCE);
            event.accept(ModBlocks.PALE_WILLOW_FENCE_GATE);
            event.accept(ModBlocks.PALE_WILLOW_DOOR);
            event.accept(ModBlocks.PALE_WILLOW_TRAPDOOR);

            event.accept(ModBlocks.RESIN_BLOCK);
            event.accept(ModBlocks.RESIN_BRICKS);
            event.accept(ModBlocks.CHISELED_RESIN_BRICKS);

            event.accept(ModBlocks.RESIN_BRICK_STAIRS);
            event.accept(ModBlocks.RESIN_BRICK_SLAB);
            event.accept(ModBlocks.RESIN_BRICK_WALL);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}