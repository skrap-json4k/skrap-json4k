package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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


fun <T : Any, P1> reflectiveJsonBuilderArg1(clazz : KClass<T>, arg1 : P1) : T {
    val fields = clazz.java.declaredFields
    val creator = @JsonCreator fun (@JsonProperty arg1: P1) =
            clazz.java.getConstructor(
                    fields.get(0).type
            ).newInstance(arg1)
    return creator(arg1)
}

fun <T : Any, P1, P2> reflectiveJsonBuilderArg2(clazz : KClass<T>, arg1 : P1, arg2 : P2) : T {
    val fields = clazz.java.declaredFields
    val creator = @JsonCreator fun (@JsonProperty arg1: P1, @JsonProperty arg2: P2) =
            clazz.java.getConstructor(
                    fields.get(0).type,fields.get(1).type
            ).newInstance(arg1, arg2)
    return creator(arg1,arg2)
}

fun <T : Any, P1, P2, P3> reflectiveJsonBuilderArg3(clazz : KClass<T>, arg1 : P1, arg2 : P2, arg3 : P3) : T {
    val fields = clazz.java.declaredFields
    val creator = @JsonCreator fun (@JsonProperty arg1: P1, @JsonProperty arg2: P2, @JsonProperty arg3: P3) =
            clazz.java.getConstructor(
                    fields.get(0).type,fields.get(1).type,fields.get(2).type
            ).newInstance(arg1, arg2, arg3)
    return creator(arg1,arg2, arg3)
}

