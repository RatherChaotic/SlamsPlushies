package com.ratherchaotic.slamsplushies.init;

import com.ratherchaotic.slamsplushies.Slamsplushies;
import com.ratherchaotic.slamsplushies.blockentity.BlockEntityPlushie;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles setting up the Block Entities for the mod.
 */
public class InitBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Slamsplushies.MOD_ID);

    public static RegistryObject<BlockEntityType<BlockEntityPlushie>> PLUSHIE = BLOCK_ENTITY_TYPES.register(
            "plushie", () -> BlockEntityType.Builder.of(BlockEntityPlushie::new, InitItems.PLUSHIE_BLOCK.get()).build(null));
}
