package com.dark.npccore.event;

import com.dark.npccore.KeyBindings;
import com.dark.npccore.network.NpccoreModVariables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "npccore", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (KeyBindings.UP_TO_CHAT_LINE != null && KeyBindings.UP_TO_CHAT_LINE.consumeClick()) {
                // up variable value by one
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine - 1;
            }
            if (KeyBindings.DOWN_TO_CHAT_LINE != null && KeyBindings.DOWN_TO_CHAT_LINE.consumeClick()) {
                // up variable value by one
                NpccoreModVariables.chatLine = NpccoreModVariables.chatLine + 1;
            }
        }
    }

}