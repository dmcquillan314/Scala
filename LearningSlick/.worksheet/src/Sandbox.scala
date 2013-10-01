import org.postgresql.ds.PGSimpleDataSource
import scala.slick.session.Database.forDataSource

object Sandbox {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(227); 

  def database = {
    val ds = new PGSimpleDataSource
    ds.setDatabaseName("sandbox")
    forDataSource(ds)
  };System.out.println("""database: => scala.slick.session.Database""");$skip(48); 
   
  println("Welcome to the Scala worksheet")}
}
