package com.dark.npccore.client.screens;


import com.dark.npccore.network.NpccoreModVariables;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class player_talk_overlay_base {
    Minecraft mc = Minecraft.getInstance();
    Player player = mc.player;

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        if (true) {
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/npc_bar_middle.png"), 0, 0, 0, 0, 128, 16, 128, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/player_bar_end.png"), 128, 0, 0, 0, 128, 16, 128, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/testing_ground.png"), w / 2 + -57, h / 2 + -29, 0, Mth.clamp((int) NpccoreModVariables.chatLine * 16, 0, 496), 128, 16, 128, 512);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/background_npccore_talking_overlay.png"), 56, 8, 0, 0, 32, 16, 32, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/background_npccore_talking_overlay.png"), 118, 8, 0, 0, 32, 16, 32, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/background_npccore_talking_overlay.png"), 160, 8, 0, 0, 32, 16, 32, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/background_npccore_talking_overlay.png"), 212, 8, 0, 0, 32, 16, 32, 16);
        }
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }

}