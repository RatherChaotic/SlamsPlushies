package com.ratherchaotic.slamsplushies.init;

import com.ratherchaotic.slamsplushies.Slamsplushies;
import com.ratherchaotic.slamsplushies.block.BlockPlushie;
import com.ratherchaotic.slamsplushies.item.ItemPlushie;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Handles setting up the Items for the mod.
 */
public class InitItems {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Slamsplushies.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Slamsplushies.MOD_ID);

    /**
     * Called to initialize the Items.
     */
    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> PLUSHIE_BLOCK = BLOCKS.register("plushie_block", BlockPlushie::new);

    public static final RegistryObject<Item> PLUSHIE_BASE = ITEMS.register("plushie_base", ItemPlushie::new);
    public static final RegistryObject<Item> PLUSHIE_CALEMI = ITEMS.register("plushie_calemi", ItemPlushie::new);

    /**
     * Used to register an Item.
     *
     * @param name The name of the Item.
     * @param sup  The Item class.
     */
    public static RegistryObject<Item> regItem(String name, final Supplier<? extends Item> sup) {
        return ITEMS.register(name, sup);
    }
}
