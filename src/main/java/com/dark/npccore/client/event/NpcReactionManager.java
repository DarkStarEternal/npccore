package com.dark.npccore.client.event;

import com.dark.npccore.entity.client.FemaleHumanRenderer;
import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class NpcReactionManager {
    private static Map<String, Map<String, String>> npcDialogues;
    public Map<String, Map<String, String>> npc;

    public static void loadReactions() {
        try {
            Minecraft mc = Minecraft.getInstance();
            InputStream is = mc.getResourceManager()
                    .getResource(new ResourceLocation("npccore", "dialogues/npc.json"))
                    .get().open();
            InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

            FemaleHumanRenderer.NPCDialogueData data = new Gson()
                    .fromJson(reader, FemaleHumanRenderer.NPCDialogueData.class);

            npcDialogues = data.npc;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getReaction(String key, String randomizer) {
        if (npcDialogues == null) return "";

        Map<String, String> innerMap = npcDialogues.get(key);
        if (innerMap == null) return "";

        return innerMap.getOrDefault(randomizer, "");
    }
}