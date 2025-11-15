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

## Automation

- **Build** – Runs automatically on every push and pull request (`.github/workflows/build.yml`). It validates the Gradle wrapper, sets up JDK 21, caches Gradle, and executes `./gradlew build`, uploading everything in `build/libs/` as a workflow artifact for quick inspection.
- **Release** – Can be triggered manually from the Actions tab (`.github/workflows/release.yml`). The workflow rebuilds the project, uploads the jars as an artifact, and publishes a GitHub Release with every jar from `build/libs/` attached. When starting the workflow, provide a `tag_name` (e.g., `v1.0.1`), optionally override the release title/body, and choose whether to mark it as a prerelease or auto-generate release notes.

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
