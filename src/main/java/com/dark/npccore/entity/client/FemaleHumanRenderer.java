package com.dark.npccore.entity.client;

import com.dark.npccore.Npccore;
import com.dark.npccore.client.event.NpcReactionManager;
import com.dark.npccore.entity.custom.FemaleHumanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.Random;


public class FemaleHumanRenderer extends MobRenderer<FemaleHumanEntity, FemaleHumanModel<FemaleHumanEntity>> {
    public FemaleHumanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FemaleHumanModel<>(pContext.bakeLayer(ModModelLayers.FEMALE_HUMAN_LAYER)), 1f);

    }
    public static class NPCDialogueData {
        public Map<String, Map<String, String>> npc;
    }

    @Override
    public ResourceLocation getTextureLocation(FemaleHumanEntity pEntity) {
        return new ResourceLocation(Npccore.MODID, "textures/entity/gwen.png");
    }

    @Override
    public void render(FemaleHumanEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, bufferSource, packedLight);

        // Render the custom name/tag above the entity
        renderNameTag(entity,poseStack, bufferSource, packedLight);
    }
    private void renderNameTag(FemaleHumanEntity entity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        double yOffset = entity.getBbHeight() + 0.5; // height of the entity + offset

        String outerKey = Integer.toString(entity.getDialogueKey());
        String innerKey = Integer.toString(entity.getDialogueRandomizer());
        String customText = NpcReactionManager.getReaction(outerKey, innerKey); // Or any dynamic value

        // Don't render if the entity is too far or invisible
        if (this.entityRenderDispatcher.distanceToSqr(entity) > 4096.0D) return;

        Font font = Minecraft.getInstance().font;

        poseStack.pushPose();
        poseStack.translate(0.0D, yOffset, 0.0D);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.scale(-0.025F, -0.025F, 0.025F);

        float backgroundOpacity = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
        int backgroundColor = (int)(backgroundOpacity * 255.0F) << 24;

        float xOffset = -font.width(customText) / 2.0f;

        font.drawInBatch(customText, xOffset, 0, 0xFFFFFF, false,
                poseStack.last().pose(), bufferSource, Font.DisplayMode.NORMAL,
                backgroundColor, packedLight);

        poseStack.popPose();
    }

}
