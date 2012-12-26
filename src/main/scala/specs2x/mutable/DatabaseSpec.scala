package specs2x.mutable

import specs2x.Database
import org.specs2.mutable.Specification

/**
 * @author Yaroslav Klymko
 */
abstract class DatabaseSpec(implicit val database: Database) extends Specification with WithDatabase
