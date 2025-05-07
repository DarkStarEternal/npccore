package com.dark.npccore.item;

import com.dark.npccore.Npccore;
import com.dark.npccore.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> Creative_Mode_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Npccore.MODID);

    public static final RegistryObject<CreativeModeTab> NPCCORETAB = CREATIVE_MODE_TABS.register("NPCcore",
            () -> CreativeModeTab.builder().icon() -> new ItemStack(ModItems.COIN.get()))
            .title(Component.translatable("creativetab.npccoretab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.COIN.get());
                pOutput.accept(ModBlocks.CARPENTER_WORKSTATION.get());
            })
            .build());
    public static void register(IEventBus eventBus) { Creative_Mode_TABS.register(eventBus); }
}
