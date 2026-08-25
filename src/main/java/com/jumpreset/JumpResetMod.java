package com.jumpreset;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = JumpResetMod.MODID, version = JumpResetMod.VERSION)
public class JumpResetMod {

    public static final String MODID = "jumpreset";
    public static final String VERSION = "1.2";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new JumpResetHandler());
    }
}
