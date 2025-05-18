package com.dark.npccore.event;


import com.dark.npccore.Npccore;
import com.dark.npccore.entity.ModEntities;
import com.dark.npccore.entity.client.FemaleHumanModel;
import com.dark.npccore.entity.client.ModModelLayers;
import com.dark.npccore.entity.custom.FemaleHumanEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Npccore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.HUMANFEMALE.get(), FemaleHumanEntity.createAttributes().build());
    }
}
