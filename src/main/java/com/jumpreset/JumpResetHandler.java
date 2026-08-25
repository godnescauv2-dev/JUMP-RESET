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

        // Detecta se o jogador está sofrendo knockback (velocity horizontal alta)
        // motionX e motionZ representam a velocidade horizontal (knockback)
        double speed = Math.sqrt(
            mc.thePlayer.motionX * mc.thePlayer.motionX +
            mc.thePlayer.motionZ * mc.thePlayer.motionZ
        );

        // Se a velocidade horizontal for alta (levou hit) e estiver no chão, pula
        if (speed > 0.15 && mc.thePlayer.onGround) {
            mc.thePlayer.jump();
        }
    }
}
