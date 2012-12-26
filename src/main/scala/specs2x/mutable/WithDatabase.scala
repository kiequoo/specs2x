package specs2x.mutable

import org.specs2.execute.Result
import org.specs2.specification.{AroundExample, Step, Fragments}
import org.specs2.mutable.Specification
import specs2x.Database

/**
 * @author Yaroslav Klymko
 */
trait WithDatabase extends Specification with AroundExample {

  sequential ^ stopOnFail

  protected def around[T <% Result](t: => T) = database.withSession(t)

  abstract override def map(fs: => Fragments): Fragments =
    Step(database.start()) ^ super.map(fs) ^ Step(database.stop())

  def database: Database
}