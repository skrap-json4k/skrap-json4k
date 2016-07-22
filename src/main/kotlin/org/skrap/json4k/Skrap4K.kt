package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import kotlin.reflect.KClass

/**
 * Created by yy_yank on 2016/05/21.
 */


/**
 * json文字列をクラスインスタンスに変換
 */
fun  <T : Any> jsonToObject(jsonString : String, clazz : KClass<T>, pretty : Boolean = false) = mapper(pretty).readValue(jsonString, clazz.java)


/**
 * クラスインスタンスをjson文字列に変換
 */
fun <T> objectToJson(obj : T, pretty : Boolean = false) = mapper(pretty).writeValueAsString(obj)


/**
 * クラスインスタンスをjsonバイトに変換
 */
fun <T> objectToJsonBytes(obj : T, pretty : Boolean = false) = mapper(pretty).writeValueAsBytes(obj)

/**
 * jsonをListに変換
 */
fun <T : Any> jsonToList(json : String, pretty : Boolean = false) = mapper(pretty).readValue(json, List::class.java)

/**
 * ObjectMapperインスタンス生成
 */
fun mapper(pretty : Boolean) = if(pretty){ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)} else {ObjectMapper()}


class ReflectiveJsonCreator {

    companion object {
        fun <T : Any, P1> createArg1(clazz: KClass<T>, arg1: P1): T {
            val fields = clazz.java.declaredFields
            val creator = @JsonCreator fun(@JsonProperty arg1: P1) =
                    clazz.java.getConstructor(
                            fields.get(0).type
                    ).newInstance(arg1)
            return creator(arg1)
        }

        fun <T : Any, P1, P2> createArg2(clazz: KClass<T>, arg1: P1, arg2: P2): T {
            val fields = clazz.java.declaredFields
            val creator = @JsonCreator fun(@JsonProperty arg1: P1, @JsonProperty arg2: P2) =
                    clazz.java.getConstructor(
                            fields.get(0).type, fields.get(1).type
                    ).newInstance(arg1, arg2)
            return creator(arg1, arg2)
        }

        fun <T : Any, P1, P2, P3> createArg3(clazz: KClass<T>, arg1: P1, arg2: P2, arg3: P3): T {
            val fields = clazz.java.declaredFields
            val creator = @JsonCreator fun(@JsonProperty arg1: P1, @JsonProperty arg2: P2, @JsonProperty arg3: P3) =
                    clazz.java.getConstructor(
                            fields.get(0).type, fields.get(1).type, fields.get(2).type
                    ).newInstance(arg1, arg2, arg3)
            return creator(arg1, arg2, arg3)
        }
    }
}
