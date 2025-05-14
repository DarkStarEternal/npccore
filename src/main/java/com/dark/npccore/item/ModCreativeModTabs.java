package com.dark.npccore.item;

import com.dark.npccore.Npccore;
import com.dark.npccore.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Npccore.MODID);

    public static final RegistryObject<CreativeModeTab> NPCCORE_BLOCKS = CREATIVE_MODE_TABS.register("npccoreblocks",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CARPENTER_WORKSTATION.get()))
                    .title(Component.translatable("creativetab.npccoreblocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.CARPENTER_WORKSTATION.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> NPCCORE_ITEMS = CREATIVE_MODE_TABS.register("npccoreitems",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COIN.get()))
                    .title(Component.translatable("creativetab.npccoreblocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COIN.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
