package com.ratherchaotic.slamsplushies.item;

import com.ratherchaotic.slamsplushies.Slamsplushies;
import com.ratherchaotic.slamsplushies.block.BlockPlushie;
import com.ratherchaotic.slamsplushies.blockentity.BlockEntityPlushie;
import com.ratherchaotic.slamsplushies.init.InitItems;
import com.tm.calemicore.util.Location;
import com.tm.calemicore.util.helper.LogHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ItemPlushie extends Item {

    public ItemPlushie() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(1));
    }

    public static int getTypeId(ItemStack stack) {

        int meta = 11;

        if (stack.getOrCreateTag().contains("type")) {
            meta = stack.getOrCreateTag().getInt("type");
        }

        return meta;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        BlockPlaceContext placeContext = new BlockPlaceContext(context);

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Direction dir = context.getClickedFace();
        InteractionHand hand = context.getHand();

        BlockPlushie PLUSHIE = (BlockPlushie) InitItems.PLUSHIE_BLOCK.get();
        Location location = new Location(level, pos);

        //Checks if the Player exists.
        if (player != null) {

            //Checks if the clicked Location can be replaced.
            if (!location.getBlockState().getMaterial().isReplaceable()) {

                location = new Location(location, dir);

                if (!location.isBlockValidForPlacing()) return InteractionResult.FAIL;
            }

            //Checks if the Player is not at that location.
            if (location.isEntityAtLocation(player)) {
                return InteractionResult.FAIL;
            }

            //Checks if the Player can edit the Location.
            if (!placeContext.canPlace()) return InteractionResult.FAIL;

            if (location.isBlockValidForPlacing()) {

                location.setBlock(PLUSHIE.defaultBlockState().setValue(BlockPlushie.FACING, context.getHorizontalDirection().getOpposite()));

                BlockEntity blockEntity = location.getBlockEntity();

                if (blockEntity instanceof BlockEntityPlushie plushie) {
                    plushie.setPlushie(context.getItemInHand());
                }
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}
