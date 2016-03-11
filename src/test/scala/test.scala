/**
  * Created by adam on 11.03.16.
  */

import geotrellis.slick.PostGisSupport
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import slick.driver.PostgresDriver

import   geotrellis.vector._
class Example extends FunSuite with BeforeAndAfter with ScalaFutures {

  val driver = PostgresDriver
  import driver.simple._

  val postgis = new PostGisSupport(driver)

  import postgis._


  class City(tag: Tag) extends Table[(Int,String,Point)](tag, "cities") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def geom = column[Point]("geom")

    def * = (id, name, geom)

  }



  implicit override val patienceConfig = PatienceConfig(timeout = Span(50, Seconds))




  before {
    db = Database.forURL("mongodb://localhost:27017/test") // MongoDB binds to 127.0.0.1  in travis
  }

  var db: Database = _


}

