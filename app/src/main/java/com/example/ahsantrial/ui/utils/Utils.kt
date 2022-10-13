package com.example.ahsantrial.ui.utils

import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.entities.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray

object Utils {

    fun jsonToAny(`object`: Any?, type: Class<*>): Any? {
        if (`object` == null)
            return null
        val gsn = Gson()
        var gsnString = gsn.toJson(`object`)
        var any: Any?
        val clazz = type.javaClass
        if (`object` is ArrayList<*>) {
            val objects = ArrayList<Any>()
            for (objectA in (`object` as ArrayList<*>?)!!) {
                gsnString = gsn.toJson(objectA)
                any = gsn.fromJson<Any>(gsnString, type)
                objects.add(any)
            }
            return objects
        } else {
            any = gsn.fromJson<Any>(gsnString, type)
        }
        return any
    }

    fun jsonToList(item: Any): MutableList<Item> {
        val gson = Gson()
        val listString = gson.toJson(
            item,
            object : TypeToken<ArrayList<Item?>?>() {}.type
        )

        val jArr = JSONArray(listString)


        val list: MutableList<Item> = ArrayList()
        for (i in 0 until jArr.length()) {
            val item: Item = Gson().fromJson(jArr.get(i).toString(), Item::class.java)
            list.add(item)

        }

        return list
    }

}