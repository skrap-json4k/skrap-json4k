package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import kotlin.reflect.KClass

/**
 * Created by yy_yank on 2016/05/21.
 */


/**
 * json文字列をクラスインスタンスに変換
 */
fun  <T : Any> jsonToObject(jsonString : String, clazz : KClass<T>) = mapper().readValue(jsonString, clazz.java)


/**
 * クラスインスタンスをjson文字列に変換
 */
fun <T> objectToJson(obj : T) = mapper().writeValueAsString(obj)

/**
 * jsonをListに変換
 */
fun <T : Any> jsonToList(json : String) = mapper().readValue(json, List::class.java)


fun mapper() = ObjectMapper()