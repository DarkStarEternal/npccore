package com.dark.npccore.client;


import com.dark.npccore.Npccore;
import com.dark.npccore.client.event.DialogueManager;
import com.dark.npccore.client.event.NpcReactionManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Npccore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        DialogueManager.loadDialogues();
        NpcReactionManager.loadReactions();
    }
}