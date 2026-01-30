package com.github.rmheuer.rjm;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public final class RemoveJoinMessage implements ModInitializer {
  public static final String MOD_ID = "remove-join-message";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  public static final Set<String> BLOCKED_KEYS =
      Set.of(
          "multiplayer.player.joined",
          "multiplayer.player.joined.renamed",
          "multiplayer.player.left");

  @Override
  public void onInitialize() {
    LOGGER.info("Disabling player join and leave messages");
  }
}
