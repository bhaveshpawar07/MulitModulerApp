package com.wednesday.core_common.mappers.base

interface Mapper<FROM, TO> {

    fun map(from: FROM): TO

    fun map(from: List<FROM>): List<TO> = from.map(::map)
}
