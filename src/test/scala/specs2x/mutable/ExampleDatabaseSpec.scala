package specs2x.mutable

/**
 * @author Yaroslav Klymko
 */

class ExampleDatabaseSpec extends DatabaseSpecWithJUnit(database) {
  "ExampleDatabase" should {
    "insert record" in success  // each will be called in separate session
    "read record"   in success  // also DatabaseSpec is sequential by default
    "delete record" in success  // if any will fail, we will not go further (sequential ^ stopOnFail)
  }
}
