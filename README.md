# skrap-json4k [![Circle CI](https://circleci.com/gh/yyYank/Kebab/tree/master.svg?style=shield)](https://circleci.com/gh/skrap-json4k/skrap-json4k/tree/master) 

Kotlin用のjsonライブラリ


## Usage

```Kotlin
val json = "{\"age\":28, \"name\":\"yank\"}"
val hoge = jsonToObject(json, Person::class)
val (age, name) = hoge.age to hoge.name
```


```Kotlin 
val person = Person()
person.name = "yank"
person.age = 28
val json = objectToJson(person)
```
