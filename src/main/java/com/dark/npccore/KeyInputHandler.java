package com.dark.npccore;


import com.dark.npccore.event.ChatlineSendOver;
import com.dark.npccore.network.NpccoreModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Npccore.MODID, value = Dist.CLIENT)
public class KeyInputHandler {


    public static void register() {
        MinecraftForge.EVENT_BUS.register(KeyInputHandler.class);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        boolean wasKeyDown = false;
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        boolean isDown = false;
        if (KeyBindings.UP_TO_CHAT_LINE != null && KeyBindings.UP_TO_CHAT_LINE.isDown() && !wasKeyDown) {
            if (NpccoreModVariables.chatLine <= 16 && NpccoreModVariables.chatLine > 0) {
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine - 1;
            }
            isDown = true;
        }
        else if (KeyBindings.DOWN_TO_CHAT_LINE != null && KeyBindings.DOWN_TO_CHAT_LINE.isDown() && !wasKeyDown) {
            if (NpccoreModVariables.chatLine <= 15 && NpccoreModVariables.chatLine >= 0)  {
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine + 1;
            }
            isDown = true;
        }
        else if (KeyBindings.LEFT_CHAT_LINE != null && KeyBindings.LEFT_CHAT_LINE.isDown() && !wasKeyDown) {
            if (NpccoreModVariables.chatRow <= 3 && NpccoreModVariables.chatRow > 1) {
                NpccoreModVariables.chatRow = NpccoreModVariables.chatRow - 1;
            }
            isDown = true;
        }
        else if (KeyBindings.RIGHT_CHAT_LINE != null && KeyBindings.RIGHT_CHAT_LINE.isDown() && !wasKeyDown) {
            if (NpccoreModVariables.chatRow <= 2 && NpccoreModVariables.chatRow >= 1) {
                NpccoreModVariables.chatRow = NpccoreModVariables.chatRow + 1;
            }
            isDown = true;
        }
        else if (KeyBindings.SAY_LINE != null && KeyBindings.SAY_LINE.isDown() && !wasKeyDown) {
            mc.player.displayClientMessage(Component.literal("said smt"), true);
            ChatlineSendOver.sendoverchatline(NpccoreModVariables.chatLine, NpccoreModVariables.chatRow, NpccoreModVariables.selectedNPC, player);
            isDown = true;
        }
        wasKeyDown = isDown;
    }
}