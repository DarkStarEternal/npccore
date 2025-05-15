package com.dark.npccore.entity;

import com.dark.npccore.Npccore;
import com.dark.npccore.entity.custom.FemaleHumanEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Npccore.MODID);

    public static final RegistryObject<EntityType<FemaleHumanEntity>> HUMANFEMALE =
            ENTITY_TYPES.register("humanfemale", () -> EntityType.Builder.of(FemaleHumanEntity::new, MobCategory.CREATURE)
                    .sized(1f, 2f).build("humanfemale"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
