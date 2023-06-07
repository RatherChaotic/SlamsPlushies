package com.ratherchaotic.slamsplushies.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.ratherchaotic.slamsplushies.block.BlockPlushie;
import com.ratherchaotic.slamsplushies.blockentity.BlockEntityPlushie;
import com.tm.calemicore.util.render.RenderedItemStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderPlushie implements BlockEntityRenderer<BlockEntityPlushie> {

    private final RenderedItemStack renderedItemStack = new RenderedItemStack();

    public RenderPlushie(BlockEntityRendererProvider.Context pContext) {}

    @Override
    public void render(BlockEntityPlushie plushie, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        LocalPlayer player = Minecraft.getInstance().player;

        if (player != null && player.distanceToSqr(plushie.getLocation().getVector()) < 500.0D) {

            this.renderedItemStack.setStack(plushie.getPlushie());

            if (!plushie.getPlushie().isEmpty()&& plushie.getLocation().getBlockState().hasProperty(BlockPlushie.FACING)) {

                poseStack.pushPose();

                poseStack.translate(0.5D, 0.4D, 0.5D);

                poseStack.scale(2F, 2F, 2F);

                Direction facing = plushie.getLocation().getBlockState().getValue(BlockPlushie.FACING);

                switch (facing) {
                    case EAST -> {
                        poseStack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0, 270, 0)));
                    }
                    case SOUTH -> {
                        poseStack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0, 180, 0)));
                    }
                    case WEST -> {
                        poseStack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0, 90, 0)));
                    }
                }

                this.renderedItemStack.render(poseStack, buffer, packedLight, packedOverlay);

                poseStack.popPose();
            }

        }
    }
}
