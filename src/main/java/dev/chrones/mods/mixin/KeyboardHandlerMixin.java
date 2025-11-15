package dev.chrones.mods.mixin;

import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
    private void onKeyPress(long window, int key, KeyEvent keyEvent, CallbackInfo ci) {
        var client = Minecraft.getInstance();

        // Check if pressed key matches the swap offhand key and if it's a press or repeat action
        // KeyEvent might be a record, try accessing fields directly
        if (client.options.keySwapOffhand.matches(keyEvent)) {
            // Cancel if NOT in an inventory screen
            if (client.screen == null) {
                ci.cancel();
            }
        }
    }
}
