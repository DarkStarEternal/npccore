package com.dark.npccore.event;

import com.dark.npccore.Npccore;
import com.dark.npccore.entity.client.ModModelLayers;
import com.dark.npccore.entity.client.FemaleHumanModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Npccore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.FEMALE_HUMAN_LAYER, FemaleHumanModel::createBodyLayer);
    }

}
