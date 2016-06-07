package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`


/**
 * Created by yy_yank on 2016/05/21.
 */

class Skrap4KTest {
    @Test
    fun testJsonToObject() {
        val json = "{\"age\":28, \"name\":\"yank\"}"
        val hoge = jsonToObject(json, Person::class)
        val (age, name) = hoge.age to hoge.name
        println("age = ${age} name = ${name}")
        assertThat(age, `is`(28))
        assertThat(name, `is`("yank"))
    }

    @Test
    fun testObjectToJson() {
        var person = Person()
        person.name = "yank"
        person.age = 28
        val json = objectToJson(person)
        val expected = "{\"age\":28,\"name\":\"yank\"}"
        assertThat(json, `is`(expected))
    }
}

class Person() {
    var age: Int? = null
    var name: String? = null
}
