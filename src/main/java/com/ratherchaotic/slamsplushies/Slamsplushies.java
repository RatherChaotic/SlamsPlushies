package com.ratherchaotic.slamsplushies;

import com.mojang.logging.LogUtils;
import com.ratherchaotic.slamsplushies.init.InitBlockEntityTypes;
import com.ratherchaotic.slamsplushies.init.InitItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Slamsplushies.MOD_ID)
public class Slamsplushies {
    public static final String MOD_ID = "slamsplushies";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static IEventBus MOD_EVENT_BUS;



    public Slamsplushies() {
        // Register the setup method for modloading
        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        InitItems.init();
        InitBlockEntityTypes.BLOCK_ENTITY_TYPES.register(MOD_EVENT_BUS);

        MOD_EVENT_BUS.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
