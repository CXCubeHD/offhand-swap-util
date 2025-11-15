<!-- markdownlint-disable MD033 -->
# Offhand Swap Util

Offhand Swap Util is a lightweight Fabric mod for Minecraft 1.21.10 that stops the player from accidentally swapping items into the offhand slot whenever they press the swap key while not inside an inventory screen.

## Features

- Hooks Minecraft's `KeyboardHandler` via a mixin to intercept the swap-offhand key before Minecraft processes it.
- Cancels the key press whenever the player is not viewing an inventory screen, letting you keep your shield, torch, or other offhand item steady during gameplay.
- Built with Kotlin + Fabric Loom, so it plays nicely with Fabric API and the Fabric Kotlin module.

## Requirements

- **Minecraft**: 1.21.10 (Fabric mappings and loader rely on this version)
- **Fabric Loader**: 0.17.3 or later
- **Java**: 21 (both for building and running)
- **Fabric API** + **Fabric Kotlin** bundles matching the versions in `gradle.properties`

## Installation

1. Build the mod using the Gradle wrapper from the repository root:

```bash
./gradlew build
```

2. Copy the resulting JAR from `build/libs/` (the filename follows `offhand-swap-util-<version>.jar`) into your Fabric client's `mods/` folder.
3. Start Minecraft with Fabric and the Fabric Kotlin loader; the mod logs a simple initialization message on startup.

## Development

1. Clone the repository and install Java 21.
2. Run `./gradlew build` to compile the Kotlin mixin entrypoint (`dev.chrones.mods.OffhandSwapUtil`) and the mixin that guards `KeyboardHandler#keyPress`.
3. Use the `build/libs` artifact during manual testing or supply it to CurseForge, Modrinth, or another loader target for distribution.

### Source layout

- Kotlin entry point: `src/main/kotlin/dev/chrones/mods/OffhandSwapUtil.kt`
- Keyboard mixin: `src/main/java/dev/chrones/mods/mixin/KeyboardHandlerMixin.java`
- Mod metadata and mixins are driven from `src/main/resources/fabric.mod.json`

## Testing

There are no automated tests in this repository. To verify functionality, run Minecraft with Fabric locally and press the swap-offhand key outside of any inventory screen; the mixin prevents the swap from occurring.

## Contributing

Contributions, issue reports, and feature requests are welcome—just open a PR or issue. Please keep the code in Kotlin or Java and follow the existing style.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for the full text.
