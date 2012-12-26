# Specs2x [![Build Status](https://secure.travis-ci.org/t3hnar/specs2x.png)](http://travis-ci.org/t3hnar/specs2x)

Extension for [Specs2](http://etorreborre.github.com/specs2/)

## Examples

### DatabaseSpec

Need to create an implicit `Database` instance, which will be used in specs

```scala
implicit val database = new Database {
  def start() {
    // setup database
  }

  def withSession[T](f: => T) = {
    // create session
    f
    // submit session
  }

  def stop() {
    // clean and stop database
  }
}
```

Then your database will be `implicitly` passed to your specification

```scala
class ExampleDatabaseSpec extends DatabaseSpecWithJUnit {
  "ExampleDatabase" should {
    "insert record" in success  // each will be called in separate session
    "read record"   in success  // also DatabaseSpec is sequential by default
    "delete record" in success  // if any will fail, we will not go further (sequential ^ stopOnFail)
  }
}
```

And you get clean specification, without boilerplate code for managing database

You can pass database manually as well

```scala
class ExampleDatabaseSpec extends DatabaseSpecWithJUnit( database )

```

## Setup

1. Add this repository to your pom.xml:
```xml
    <repository>
        <id>thenewmotion</id>
        <name>The New Motion Repository</name>
        <url>http://nexus.thenewmotion.com/content/repositories/releases-public</url>
    </repository>
```

2. Add dependency to your pom.xml:
```xml
    <dependency>
        <groupId>ua.t3hnar.specs2x</groupId>
        <artifactId>specs2x_2.9.2</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
```