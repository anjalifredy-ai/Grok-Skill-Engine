# Architecture — Grok Skill Engine

## High-level modules

### 1. Runtime
- Mobile OpenJDK (8/17/21) packaging for arm64 / arm32 / x86_64
- Custom classloader supporting Fabric/Forge layered loading
- Native bridge for Android lifecycle, input, sensors

### 2. Graphics
- Renderer abstraction
- Holy GL4ES (default)
- ANGLE (Vulkan)
- Zink / LTW fallbacks
- Preload `.so` before JVM start

### 3. Download System
- Mojang version_manifest_v2 + per-version JSON
- Libraries + assets with SHA1 verification
- Parallel download + resume + retry
- Cache with forced re-verify option

### 4. Loaders (first-class engine components)
- **Fabric / Quilt**: meta API → generate version profile → merge libraries + mainClass
- **Forge / NeoForge**: modern installer profile support (install_profile.json + processors)
- **OptiFine**: special handling as library or mod

### 5. Launch
- Resolve version → ensure files → extract natives → build classpath
- Mobile-tuned JVM args (heap, GC, renderer library)
- Isolated game directories per instance

## Design rules
- Official sources only
- No hard-coded outdated URLs
- SHA1 always verified
- Clean module boundaries
- Ultra optimization from day one
