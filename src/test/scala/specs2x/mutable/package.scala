package specs2x

/**
 * @author Yaroslav Klymko
 */
package object mutable {
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
}
