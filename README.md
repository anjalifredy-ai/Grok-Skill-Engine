# Grok Skill Engine

**Custom ultra-optimized Minecraft Java Edition mobile engine for Android.**

Not a fork of PojavLauncher. Built from the ground up with clean architecture, rock-solid download logic, and first-class support for Fabric, Forge, NeoForge, Quilt and OptiFine as engine components.

> Powered by the `mc-java-mobile-engine` Grok skill.

## Vision

- Clean modular engine (Runtime + Graphics + Download + Loader)
- Official Mojang / Fabric / Quilt / Forge sources only
- Proper version manifests, SHA1 verification, parallel downloads
- Holy GL4ES / ANGLE / Zink renderer support
- Ultra optimization for mobile (memory, thermal, startup)

## Status

🚧 **Early development** — Architecture and download core being built.

## Planned Modules

```
engine/
├── runtime/          # Mobile OpenJDK bridge + classloader
├── graphics/         # GL4ES / ANGLE / Zink wrapper
├── download/         # Mojang + Fabric + Forge download system
├── loaders/          # Fabric, Quilt, Forge, NeoForge, OptiFine integration
├── launch/           # Classpath builder + JVM args + process launch
└── ui/               # Launcher UI (later)
```

## License

TBD (likely GPL-3.0 or LGPL to stay compatible with the ecosystem)

---

Made with ❤️ + Grok
