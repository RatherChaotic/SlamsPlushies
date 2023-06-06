package com.ratherchaotic.slamsplushies.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class BlockPlushie extends Block {
    public static final IntegerProperty PlushieType = SPBlockStates.PlushieType;
    public BlockPlushie() {
        super(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION)
                .noOcclusion()
                .strength(0.1F));
        registerDefaultState(getStateDefinition().any().setValue(PlushieType, 0));
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PlushieType);
    }
}
