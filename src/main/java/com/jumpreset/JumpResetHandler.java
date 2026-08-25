package com.jumpreset;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class JumpResetHandler {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase != Phase.END || mc.thePlayer == null || mc.theWorld == null)
            return;

        if (mc.thePlayer.fallDistance > 0.5f && !mc.thePlayer.onGround) {
            mc.thePlayer.jump();
        }
    }
}
