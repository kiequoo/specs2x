package specs2x

import org.specs2.execute.{Result, AsResult}

/**
 * @author Yaroslav Klymko
 */
trait Database {
  def start()
  def stop()
  def withSession[T: AsResult](f: => T): Result
}
