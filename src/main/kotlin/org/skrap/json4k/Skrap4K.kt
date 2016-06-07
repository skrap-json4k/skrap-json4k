package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.reflect.KClass

/**
 * Created by yy_yank on 2016/05/21.
 */


/**
 * json文字列をクラスインスタンスに変換
 */
fun  <T : Any> jsonToObject(jsonString : String, clazz : KClass<T>) = ObjectMapper().readValue(jsonString, clazz.java)


/**
 * クラスインスタンスをjson文字列に変換
 */
fun <T> objectToJson(obj : T) = ObjectMapper().writeValueAsString(obj)

