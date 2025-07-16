package com.dark.npccore;


import com.dark.npccore.network.NpccoreModVariables;
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
        if (KeyBindings.UP_TO_CHAT_LINE != null && KeyBindings.UP_TO_CHAT_LINE.consumeClick()) {

        }
    }
}