package net.ttzplayz.asphodel.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ttzplayz.asphodel.Asphodel;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Asphodel.MOD_ID);

    public static final DeferredItem<Item> FOG_BERRIES = ITEMS.register("fog_berries",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RESIN_BRICK = ITEMS.register("resin_brick",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
