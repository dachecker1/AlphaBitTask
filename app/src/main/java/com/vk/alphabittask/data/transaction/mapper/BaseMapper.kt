package com.vk.alphabittask.data.transaction.mapper

import java.util.ArrayList

abstract class BaseMapper<VO, ITEM> {
    abstract fun transform(item: ITEM): VO

    fun transform(items: List<ITEM>): MutableList<VO> {
        val objects: MutableList<VO> = ArrayList(items.size)

        for (item in items) {
            objects.add(transform(item))
        }

        return objects
    }
}