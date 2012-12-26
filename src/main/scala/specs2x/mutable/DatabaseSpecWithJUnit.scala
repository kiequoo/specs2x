package specs2x.mutable

import org.specs2.mutable.SpecificationWithJUnit
import specs2x.Database

/**
 * @author Yaroslav Klymko
 */
abstract class DatabaseSpecWithJUnit(implicit val database: Database)
  extends SpecificationWithJUnit
  with WithDatabase