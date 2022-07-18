package com.wednesday.feature_search.mappers

import com.wednesday.core_common.mappers.base.Mapper2
import com.wednesday.core_model.weather.City
import com.wednesday.core_presentation.model.base.UIList
import timber.log.Timber

interface UICitySearchResultsMapper : Mapper2<List<City>, List<City>, UIList>

class UICitySearchResultsMapperImpl(
    private val cityMapper: UICityMapper
) : UICitySearchResultsMapper {

    override fun map(from1: List<City>, from2: List<City>): UIList {
        Timber.tag(TAG).d("map: from1 = $from1, from2 = $from2")
        val uiCityList = from2.map {
            val isFavourite = from1.contains(it)
            cityMapper.map(it, isFavourite)
        }
        return UIList(uiCityList)
    }

    companion object {
        private const val TAG = "UICitySearchResultsMapperImpl"
    }
}
