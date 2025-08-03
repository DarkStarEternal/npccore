package com.dark.npccore.client.event;

import com.dark.npccore.client.screens.player_talk_overlay_base;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class DialogueManager {
    private static Map<String, String> commonDialogues;

    public static void loadDialogues() {
        try {
            Minecraft mc = Minecraft.getInstance();
            InputStream is = mc.getResourceManager().getResource(
                    new ResourceLocation("npccore", "dialogues/common.json")
            ).get().open();
            InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            player_talk_overlay_base.DialogueData data = new Gson().fromJson(reader, player_talk_overlay_base.DialogueData.class);
            commonDialogues = data.common;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLine(String key) {
        return commonDialogues != null ? commonDialogues.getOrDefault(key, "") : "";
    }
}