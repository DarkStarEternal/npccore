package com.dark.npccore;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KeyBindings {
    public static final KeyMapping UP_TO_CHAT_LINE = new KeyMapping("key.npccore.keyup", GLFW.GLFW_KEY_PAGE_UP, "key.categories.npccore");
    public static final KeyMapping DOWN_TO_CHAT_LINE = new KeyMapping("key.npccore.keydown", GLFW.GLFW_KEY_PAGE_DOWN, "key.categories.npccore");

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(UP_TO_CHAT_LINE);
        event.register(DOWN_TO_CHAT_LINE);
    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (Minecraft.getInstance().screen == null) {
            }
        }
    }
}
