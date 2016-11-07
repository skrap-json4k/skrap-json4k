# skrap-json4k [![Circle CI](https://circleci.com/gh/yyYank/Kebab/tree/master.svg?style=shield)](https://circleci.com/gh/skrap-json4k/skrap-json4k/tree/master) 

JSON Library for Kotlin.


## Usage

* Json to Object
```Kotlin
val json = "{\"age\":28, \"name\":\"yank\"}"
val hoge = jsonToObject(json, Person::class)
val (age, name) = hoge.age to hoge.name
```


* Object to Json
```Kotlin 
val person = Person()
person.name = "yank"
person.age = 28
val json = objectToJson(person)
```

* Json to List
```Kotlin 
val json = "[{\"age\":15, \"name\":\"hoge\"}, {\"age\":16, \"name\":\"fuga\"}]";
val list = jsonToList<Person>(json)
```
* JsonCreator
```Kotlin
var person = ReflectiveJsonCreator.createArg2(Person2::class, 28, "yank")
val json = objectToJson(person)
val expected = "{\"age\":28,\"name\":\"yank\"}"
assertThat(json, `is`(expected))
```

# Licence

Apache License, Version 2.0
