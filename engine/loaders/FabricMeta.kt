package engine.loaders

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

/**
 * Fabric Meta API (v2)
 * Used to resolve loader + intermediary + launcherMeta for a given Minecraft version.
 */
object FabricMeta {

    const val BASE = "https://meta.fabricmc.net/v2"

    private val json = Json { ignoreUnknownKeys = true }

    @Serializable
    data class LoaderVersion(
        val separator: String? = null,
        val build: Int? = null,
        val maven: String,
        val version: String,
        val stable: Boolean = false
    )

    /**
     * Returns list of compatible loaders for the given game version (newest first).
     */
    fun getLoadersForGame(gameVersion: String): List<LoaderVersion> {
        val url = "$BASE/versions/loader/$gameVersion"
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = 15_000
        connection.readTimeout = 30_000

        connection.inputStream.use { stream ->
            val text = stream.bufferedReader().readText()
            // The response is an array of objects that contain loader + intermediary.
            // For simplicity we parse just the loader parts later.
            // TODO: proper typed parsing of the nested structure
            return emptyList() // placeholder
        }
    }

    // TODO: getLauncherMeta(gameVersion, loaderVersion) → libraries + mainClass
    // TODO: generateVersionProfile(vanillaId, launcherMeta) for the engine
}
