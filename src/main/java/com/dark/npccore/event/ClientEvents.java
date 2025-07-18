package com.dark.npccore.event;

import com.dark.npccore.KeyBindings;
import com.dark.npccore.Npccore;
import com.dark.npccore.network.NpccoreModVariables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Npccore.MODID, value = Dist.CLIENT)
public class ClientEvents {

    private static boolean wasKeyDown = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            boolean isDown = false;

            if (true == false){
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine;
            }
            else if (KeyBindings.UP_TO_CHAT_LINE != null && KeyBindings.UP_TO_CHAT_LINE.isDown() && !wasKeyDown) {
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine - 1;
                isDown = true;
            }
            else if (KeyBindings.DOWN_TO_CHAT_LINE != null && KeyBindings.DOWN_TO_CHAT_LINE.isDown() && !wasKeyDown) {
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine + 1;
                isDown = true;
            }
        wasKeyDown = isDown;
        }

    }
}