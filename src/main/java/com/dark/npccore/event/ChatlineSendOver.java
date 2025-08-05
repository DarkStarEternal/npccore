package com.dark.npccore.event;

import com.dark.npccore.entity.custom.FemaleHumanEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;
import java.util.UUID;

public class ChatlineSendOver {

    public static void sendoverchatline(int line, int row, Entity targetEntity, Player player) {
        Level level = player.level(); // Get the world the player is in
        Random rand = new Random();
        Integer randomizer = rand.nextInt(2);
        if (targetEntity instanceof FemaleHumanEntity npc) {
            npc.setDialogueKey(line);
            npc.setDialogueRandomizer(randomizer);
            player.displayClientMessage(Component.literal("its saying ?"), true);

            // If you add row support:
            // female.setDialogueRow(Integer.toString(row));
        }
    }
}