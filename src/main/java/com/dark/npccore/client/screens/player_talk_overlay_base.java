package com.dark.npccore.client.screens;



import com.dark.npccore.client.event.DialogueManager;
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

import java.util.Map;
import java.util.Optional;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class player_talk_overlay_base {
    Minecraft mc = Minecraft.getInstance();
    Player player = mc.player;

    public class DialogueData {
        public Map<String, String> common;
    }

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
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/npc_bar_middle.png"), 128, 0, 0, 0, 128, 16, 128, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/player_bar_end.png"), 256, 0, 0, 0, 128, 16, 128, 16);
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/chatbar_commons.png"), 3, 8, 0, Mth.clamp((int) 14  * 16, 0, 496), 128, 16, 128, 512);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font, DialogueManager.getLine(Integer.toString(NpccoreModVariables.chatLine)), 4, 8, -1, true);
        }

        if (NpccoreModVariables.chatRow == 1) {
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/textselected.png"), 0, 4, 0, 0, 134, 22, 134, 22);
        }
        else if (NpccoreModVariables.chatRow == 2) {
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/textselected.png"), 144, 4, 0, 0, 134, 22, 134, 22);
        }
        else if (NpccoreModVariables.chatRow == 3) {
            event.getGuiGraphics().blit(new ResourceLocation("npccore:textures/screens/textselected.png"), 291, 4, 0, 0, 134, 22, 134, 22);
        }


        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }

}