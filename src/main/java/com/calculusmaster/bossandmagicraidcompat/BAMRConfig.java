package com.calculusmaster.bossandmagicraidcompat;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;

public class BAMRConfig
{
    public static ForgeConfigSpec.BooleanValue MAGICIAN_KING_ENABLED;
    public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> MAGICIAN_KING_WAVE_COUNTS;

    public static void register()
    {
        ForgeConfigSpec.Builder config = new ForgeConfigSpec.Builder();

        config.push("Magician King Settings");

        MAGICIAN_KING_ENABLED = config
                .comment("Determines if the Magician King will show up in Raids.")
                .define("magicianKingRaids", true);

        MAGICIAN_KING_WAVE_COUNTS = config
                .comment("Determines the number of Magician Kings that will spawn in each wave. The first number is ignored! Wave 1 of a Raid is the 2nd element.")
                .defineList("magicianKingWaveCounts", List.of(0, 0, 0, 0, 0, 1, 0, 1), o -> o instanceof Integer);

        config.pop();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, config.build(), BossAndMagicRaidCompat.MODID + ".toml");
    }
}
