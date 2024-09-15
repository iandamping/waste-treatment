package com.junemon.wastetreatment

import com.junemon.wastetreatment.core.data.model.response.ItemWasteResponse
import com.junemon.wastetreatment.core.data.model.response.WasteResponse
import com.junemon.wastetreatment.util.parser.MoshiParser
import com.junemon.wastetreatment.util.parser.MoshiParserImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Assert
import org.junit.Test

class MoshiParserTest {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private var moshiParser: MoshiParser = MoshiParserImpl(moshi)

    @Test
    fun `moshi to Json`() {

        val response = WasteResponse(
            itemWaste = listOf(
                ItemWasteResponse(
                    id = "omittantur",
                    name = "Scotty Payne",
                    priceCollector = 8185,
                    priceCitizen = 3896,
                    priceTotal = 1406,
                    image = "simul"
                ),
                ItemWasteResponse(
                    id = "audire",
                    name = "Lizzie Swanson",
                    priceCollector = 4460,
                    priceCitizen = 9336,
                    priceTotal = 3589,
                    image = "civibus"
                ),
            )
        )

        val types =
            Types.newParameterizedType(
                WasteResponse::class.java,
                String::class.java
            )


        val data = moshiParser.toJson(response, types)

        Assert.assertEquals(
            data,
            "{\"items\":[{\"id\":\"omittantur\",\"name\":\"Scotty Payne\",\"price_pengepul\":8185,\"price_warga\":3896,\"price_total\":1406,\"image_url\":\"simul\"},{\"id\":\"audire\",\"name\":\"Lizzie Swanson\",\"price_pengepul\":4460,\"price_warga\":9336,\"price_total\":3589,\"image_url\":\"civibus\"}]}"
        )

    }

    @Test
    fun `moshi from Json`() {
        val stringResponse =
            "{\"items\":[{\"id\":\"omittantur\",\"name\":\"Scotty Payne\",\"price_pengepul\":8185,\"price_warga\":3896,\"price_total\":1406,\"image_url\":\"simul\"},{\"id\":\"audire\",\"name\":\"Lizzie Swanson\",\"price_pengepul\":4460,\"price_warga\":9336,\"price_total\":3589,\"image_url\":\"civibus\"}]}"

        val types = Types.newParameterizedType(
            WasteResponse::class.java, WasteResponse::class.java
        )
        val data = moshiParser.fromJson<WasteResponse>(stringResponse, types)

        Assert.assertEquals(2, data?.itemWaste?.size)

    }
}