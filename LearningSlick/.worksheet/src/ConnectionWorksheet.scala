import scala.slick.driver.PostgresDriver.simple._
object ConnectionWorksheet {
	/*val session = Sandbox.database.createSession
  val pquery = tableToQuery(Supplier) map (s => s.snum ~ s.sname)
  pquery.selectStatement


  val query = tableToQuery(Supplier)
  query.selectStatement
  query.first()(session)
	query.foreach( println(_) )(session)

	val rquery = Supplier.filter(p => p.city === "London")
	rquery.selectStatement
	rquery.foreach(println(_))(session)
	
	val prquery = Supplier.filter( _.city === "London").map(_.sname)
	prquery.selectStatement
	prquery.foreach( println(_) )(session)
	
	val uquery = Supplier.filter(p => p.sname === "Clark" || p.sname === "Adams").map(_.city)
	uquery.updateStatement
	uquery.update("Rome")(session)
	
	Supplier.map(s => s.snum ~ s.sname).foreach(println(_))(session)
	query.foreach(println(_))(session)

	val projection = Supplier.snum ~ Supplier.city ~ Supplier.sname ~ Supplier.status
	projection.insertStatement
	projection.insert("S6", "Mount Prospect", "Me!", 30)(session)
	query.foreach(println(_))(session)
	
	val dquery = Supplier.filter( _.snum === "S6" )
	dquery.deleteStatement
	dquery.delete(session)
	
	session.close()*/
	import Database.threadLocalSession;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1242); 
	
	val db = Database.mysql;

object Cities extends Table[(Int, String, String, String, Int)]("city") {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def country = column[String]("countrycode")
  def district = column[String]("district")
  def population = column[Int]("population")
  def * = id ~ name ~ country ~ district ~ population
};System.out.println("""db  : <error> = """ + $show(db ));$skip(502); 

val mysql = Database.forURL(
    "jdbc:mysql://localhost/slick",
    user = "root",
    password = "snow314eagle159",
    driver = "com.mysql.jdbc.Driver");System.out.println("""mysql  : scala.slick.session.Database = """ + $show(mysql ));$skip(16); 

val db = mysql;System.out.println("""db  : scala.slick.session.Database = """ + $show(db ));$skip(314); 

db withSession {
  println("\nFirst 5 cities returned:")
  val q1 = Query(Cities)

  // becomes LIMIT 5 in SQL
  q1 take(5) foreach {
      println(_)
  }

  println("\nCities in Indiana:")
  val q2 = for ( c <- Cities; if c.district === "Indiana") yield (c.id, c.name)
  q2.list foreach {
      println(_)
  }
}}
}
