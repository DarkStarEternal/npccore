package com.dark.npccore.event;

import com.dark.npccore.network.NpccoreModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.UUID;


@Mod.EventBusSubscriber
public class PlayerRightClickEvent {
    static Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getTarget(), event.getEntity());

    }
    public static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        String uuidString = entity.getStringUUID();
        UUID uuid = UUID.fromString(uuidString);

        if (sourceentity.level().isClientSide()) {
            mc.player.displayClientMessage(Component.literal("UUID: " + uuidString), true);
            NpccoreModVariables.selectedNPC = entity;
        }
    }

    @Nullable
    public static Entity getEntityFromUUID(UUID uuid, Level level) {
        if (level instanceof ServerLevel serverLevel) {
            return serverLevel.getEntity(uuid); // Server-side entity lookup
        }
        return null; // Will return null if not on server
    }
}