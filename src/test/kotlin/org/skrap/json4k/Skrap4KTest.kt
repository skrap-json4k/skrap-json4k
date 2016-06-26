package main.kotlin.org.skrap.skrap4k

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


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

    @Test
    fun testObjectToJson2() {
        var person = Person2.new(28, "yank")
        val json = objectToJson(person)
        val expected = "{\"age\":28,\"name\":\"yank\"}"
        assertThat(json, `is`(expected))
    }

    @Test
    fun testObjectToJson3() {
        var person = ReflectiveJsonCreator.createArg2(Person2::class, 28, "yank")
        val json = objectToJson(person)
        val expected = "{\"age\":28,\"name\":\"yank\"}"
        assertThat(json, `is`(expected))
    }


    @Test
    fun testJsonToList() {
        val json = "[{\"age\":15, \"name\":\"hoge\"}, {\"age\":16, \"name\":\"fuga\"}]";
        val actual = jsonToList<Person>(json).size
        val expected = 2
        assertThat(actual, `is`(expected))
    }
}

class Person() {
    var age: Int? = null
    var name: String? = null
}

class Person2(val age : Int, val name : String) {
    companion object {
        @JsonCreator
        fun new(@JsonProperty age: Int, @JsonProperty name: String) = Person2(age, name)
    }
}

