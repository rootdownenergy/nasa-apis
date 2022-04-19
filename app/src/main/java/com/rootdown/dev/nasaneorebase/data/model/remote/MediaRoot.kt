package com.rootdown.dev.nasaneorebase.data.model.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.google.gson.annotations.Expose

@JsonClass(generateAdapter = true)
data class MediaRoot(
    @Json(name = "collection")
    @Expose
    val collection: Collection?
) {
    @JsonClass(generateAdapter = true)
    data class Collection(
        @Json(name = "href")
        @Expose
        val href: String?, // http://images-api.nasa.gov/search?q=stars
        @Json(name = "items")
        @Expose
        val items: List<Item?>?,
        @Json(name = "links")
        @Expose
        val links: List<Link?>?,
        @Json(name = "metadata")
        @Expose
        val metadata: Metadata?,
        @Json(name = "version")
        @Expose
        val version: String? // 1.0
    ) {
        @JsonClass(generateAdapter = true)
        data class Item(
            @Json(name = "data")
            @Expose
            val data: List<Data?>?,
            @Json(name = "href")
            @Expose
            val href: String?, // https://images-assets.nasa.gov/image/hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o/collection.json
            @Json(name = "links")
            @Expose
            val links: List<Link?>?
        ) {
            @JsonClass(generateAdapter = true)
            data class Data(
                @Json(name = "album")
                @Expose
                val album: List<String?>?,
                @Json(name = "center")
                @Expose
                val center: String?, // GSFC
                @Json(name = "date_created")
                @Expose
                val dateCreated: String?, // 2015-03-21T00:00:00Z
                @Json(name = "description")
                @Expose
                val description: String?, // Astronomers using NASA’s Hubble Space Telescope have uncovered surprising new clues about a hefty, rapidly aging star whose behavior has never been seen before in our Milky Way galaxy. In fact, the star is so weird that astronomers have nicknamed it “Nasty 1,” a play on its catalog name of NaSt1. The star may represent a brief transitory stage in the evolution of extremely massive stars.  First discovered several decades ago, Nasty 1 was identified as a Wolf-Rayet star, a rapidly evolving star that is much more massive than our sun. The star loses its hydrogen-filled outer layers quickly, exposing its super-hot and extremely bright helium-burning core.  But Nasty 1 doesn’t look like a typical Wolf-Rayet star. The astronomers using Hubble had expected to see twin lobes of gas flowing from opposite sides of the star, perhaps similar to those emanating from the massive star Eta Carinae, which is a Wolf-Rayet candidate.   Instead, Hubble revealed a pancake-shaped disk of gas encircling the star. The vast disk is nearly 2 trillion miles wide, and may have formed from an unseen companion star that snacked on the outer envelope of the newly formed Wolf-Rayet.  Based on current estimates, the nebula surrounding the stars is just a few thousand years old, and as close as 3,000 light-years from Earth.  Credits: NASA/Hubble
                @Json(name = "description_508")
                @Expose
                val description508: String?, // Soar through this cosmic landscape filled with bright nebulas, as well as runaway, massive and young stars.
                @Json(name = "keywords")
                @Expose
                val keywords: List<String?>?,
                @Json(name = "location")
                @Expose
                val location: String?, // Marshall Space Flight Center
                @Json(name = "media_type")
                @Expose
                val mediaType: String?, // image
                @Json(name = "nasa_id")
                @Expose
                val nasaId: String?, // hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o
                @Json(name = "photographer")
                @Expose
                val photographer: String?, // James Bilbrey, Joe Kuner
                @Json(name = "secondary_creator")
                @Expose
                val secondaryCreator: String?, // NASA/JPL-Caltech
                @Json(name = "title")
                @Expose
                val title: String? // Hubble Observes One-of-a-Kind Star Nicknamed ‘Nasty’
            )

            @JsonClass(generateAdapter = true)
            data class Link(
                @Json(name = "href")
                @Expose
                val href: String?, // https://images-assets.nasa.gov/image/hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o/hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o~thumb.jpg
                @Json(name = "rel")
                @Expose
                val rel: String?, // preview
                @Json(name = "render")
                @Expose
                val render: String? // image
            )
        }

        @JsonClass(generateAdapter = true)
        data class Link(
            @Json(name = "href")
            @Expose
            val href: String?, // http://images-api.nasa.gov/search?q=stars&page=2
            @Json(name = "prompt")
            @Expose
            val prompt: String?, // Next
            @Json(name = "rel")
            @Expose
            val rel: String? // next
        )

        @JsonClass(generateAdapter = true)
        data class Metadata(
            @Json(name = "total_hits")
            @Expose
            val totalHits: Int? // 6739
        )
    }
}