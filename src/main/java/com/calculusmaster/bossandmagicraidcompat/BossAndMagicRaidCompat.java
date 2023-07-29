package com.calculusmaster.bossandmagicraidcompat;

import com.mojang.logging.LogUtils;
import net.mcreator.animatedmobsmod.init.AnimatedmobsmodModEntities;
import net.minecraft.world.entity.raid.Raid;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BossAndMagicRaidCompat.MODID)
public class BossAndMagicRaidCompat
{
    public static final String MODID = "bossandmagicraidcompat";

    public BossAndMagicRaidCompat()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> Raid.RaiderType.create(AnimatedmobsmodModEntities.MAGICIAN_KING.get().getDescriptionId(), AnimatedmobsmodModEntities.MAGICIAN_KING.get(), new int[]{0, 0, 0, 0, 0, 1, 0, 1}));
    }
}
