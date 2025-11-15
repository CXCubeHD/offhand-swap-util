package dev.chrones.mods

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object OffhandSwapUtil : ModInitializer {
    private val logger = LoggerFactory.getLogger("offhand-swap-util")

	override fun onInitialize() {
		logger.info("Initialized Offhand Swap Util Mod")
    }
}