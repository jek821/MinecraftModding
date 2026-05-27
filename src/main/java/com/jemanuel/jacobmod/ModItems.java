package com.jemanuel.jacobmod;

import com.jemanuel.jacobmod.item.WandItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static final Item WAND = registerItem("wand", WandItem::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function){
        Identifier identifier = Identifier.fromNamespaceAndPath(JacobMod.MOD_ID, name);
        Item.Properties properties = new Item.Properties().setId(ResourceKey.create(Registries.ITEM, identifier));

        return Registry.register(BuiltInRegistries.ITEM, identifier, function.apply(properties));

    }

    public static void registerModItems() {
        JacobMod.LOGGER.info("Registering Mod Items for " + JacobMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((FabricCreativeModeTabOutput output) -> {
            output.accept(WAND);
                });
    }
}
