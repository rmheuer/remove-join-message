package com.github.rmheuer.rjm.mixin;

import com.github.rmheuer.rjm.RemoveJoinMessage;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {
  @Inject(
      at = @At("HEAD"),
      method = "broadcastSystemMessage(Lnet/minecraft/network/chat/Component;Z)V",
      cancellable = true)
  private void init(Component component, boolean bl, CallbackInfo ci) {
    ComponentContents contents = component.getContents();
    if (contents instanceof TranslatableContents translatable
        && RemoveJoinMessage.BLOCKED_KEYS.contains(translatable.getKey())) {
      ci.cancel();
    }
  }
}
