package engine.download

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

/**
 * Official Mojang / piston-meta endpoints.
 * Always prefer these over hard-coded version lists.
 */
object MojangMeta {

    const val VERSION_MANIFEST_V2 =
        "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"

    private val json = Json { ignoreUnknownKeys = true }

    @Serializable
    data class VersionManifest(
        val latest: Latest,
        val versions: List<VersionEntry>
    )

    @Serializable
    data class Latest(
        val release: String,
        val snapshot: String
    )

    @Serializable
    data class VersionEntry(
        val id: String,
        val type: String,
        val url: String,
        val time: String,
        val releaseTime: String
    )

    fun fetchVersionManifest(): VersionManifest {
        val connection = URL(VERSION_MANIFEST_V2).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = 15_000
        connection.readTimeout = 30_000

        connection.inputStream.use { stream ->
            val text = stream.bufferedReader().readText()
            return json.decodeFromString(text)
        }
    }

    // TODO: fetchVersionJson(url: String)
    // TODO: downloadClientJar + verify sha1
    // TODO: process libraries with rules
    // TODO: download assets by hash
}
