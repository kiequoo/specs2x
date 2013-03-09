package specs2x

import org.specs2.execute.{Result, AsResult}

/**
 * @author Yaroslav Klymko
 */
package object mutable {
  implicit val database = new Database {
    def start() {
      // setup database
    }

    def withSession[T](f: => T)(implicit x: AsResult[T]): Result = {
      // create session
      x.asResult(f)
      // submit session
    }

    def stop() {
      // clean and stop database
    }
  }
}
