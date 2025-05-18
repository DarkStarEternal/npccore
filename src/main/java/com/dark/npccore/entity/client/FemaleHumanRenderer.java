package com.dark.npccore.entity.client;

import com.dark.npccore.Npccore;
import com.dark.npccore.entity.custom.FemaleHumanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class FemaleHumanRenderer extends MobRenderer<FemaleHumanEntity, FemaleHumanModel<FemaleHumanEntity>> {
    public FemaleHumanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FemaleHumanModel<>(pContext.bakeLayer(ModModelLayers.FEMALE_HUMAN_LAYER)), 1f);

    }

    @Override
    public ResourceLocation getTextureLocation(FemaleHumanEntity pEntity) {
        return new ResourceLocation(Npccore.MODID, "textures/entity/gwen.png");
    }

}
