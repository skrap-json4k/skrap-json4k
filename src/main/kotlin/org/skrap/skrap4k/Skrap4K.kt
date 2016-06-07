package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.databind.ObjectMapper
import sun.jvm.hotspot.oops.Klass

/**
 * Created by yy_yank on 2016/05/21.
 */


/**
 * json文字列をクラスインスタンスに変換
 */
fun  <T> jsonToObject(jsonString : String, clazz : Class<T>) : T {
    val mapper = ObjectMapper();
    return mapper.readValue(jsonString, clazz)
}

/**
 * クラスインスタンスをjson文字列に変換
 */
fun <T> objectToJson(obj : T) : String {
    val mapper = ObjectMapper();
    return mapper.writeValueAsString(obj)
}
