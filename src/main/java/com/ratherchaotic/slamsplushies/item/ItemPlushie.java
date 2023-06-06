package com.ratherchaotic.slamsplushies.item;

import com.ratherchaotic.slamsplushies.block.BlockPlushie;
import com.ratherchaotic.slamsplushies.init.InitItems;
import com.ratherchaotic.slamsplushies.util.*;
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

import static com.ratherchaotic.slamsplushies.block.BlockPlushie.*;

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

    public static void setColorById(ItemStack stack, int meta) {
        stack.getOrCreateTag().putInt("type", meta);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {

        BlockPlaceContext placeContext = new BlockPlaceContext(context);

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Direction dir = context.getClickedFace();
        InteractionHand hand = context.getHand();

        BlockPlushie PLUSHIE = (BlockPlushie) InitItems.PLUSHIEBLOCK.get();
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

            else {

                if (location.isBlockValidForPlacing()) {
                    location.setBlock(PLUSHIE.defaultBlockState().setValue(PlushieType,(getTypeId(context.getItemInHand()))));
                }

                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
