package com.ratherchaotic.slamsplushies.block;

import com.ratherchaotic.slamsplushies.blockentity.BlockEntityPlushie;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class BlockPlushie extends BaseEntityBlock {

    public BlockPlushie() {
        super(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).noOcclusion().strength(0.1F));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityPlushie(pos, state);
    }
}
