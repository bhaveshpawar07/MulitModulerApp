package com.wednesday.core_common.mappers.weather

import com.wednesday.core_common.mappers.base.Mapper
import com.wednesday.core_database.model.geoCoding.LocalLocation
import com.wednesday.core_domain.model.weather.City
import timber.log.Timber

interface LocalCityMapper : Mapper<City, LocalLocation>

class LocalCityMapperImpl : LocalCityMapper {

    override fun map(from: City): LocalLocation {
        Timber.tag(TAG).d("map: from = $from")
        return LocalLocation(
            country = from.country,
            name = from.title,
            lat = from.lat,
            lon = from.lon,
            state = from.state,
        )
    }

    companion object {
        private const val TAG = "LocalCityMapperImpl"
    }
}
