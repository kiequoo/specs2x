package specs2x

/**
 * @author Yaroslav Klymko
 */
trait Database {
  def start()
  def stop()
  def withSession[T](f: => T): T
}
