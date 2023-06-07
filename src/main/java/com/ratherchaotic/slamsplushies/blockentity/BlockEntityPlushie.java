package com.ratherchaotic.slamsplushies.blockentity;

import com.ratherchaotic.slamsplushies.init.InitBlockEntityTypes;
import com.tm.calemicore.util.blockentity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityPlushie extends BlockEntityBase {

    private ItemStack plushie = ItemStack.EMPTY;

    public BlockEntityPlushie(BlockPos pos, BlockState state) {
        super(InitBlockEntityTypes.PLUSHIE.get(), pos, state);
    }

    public ItemStack getPlushie() {
        return plushie;
    }

    public void setPlushie(ItemStack plushie) {
        this.plushie = plushie;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        plushie = ItemStack.of(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        plushie.save(tag);
    }
}
