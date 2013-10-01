import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession
import ddcms.data.mappings.user.{Groups,Roles,Users,UserProfiles}
import ddcms.data.mappings.user.joins.{UserGroups,UserRoles}

object TestDb {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(456); 
  	implicit val session = Database.forURL(
											"jdbc:mysql://localhost:3306/slick",
											driver = "com.mysql.jdbc.Driver",
											user = "root",
											password = "snow314eagle159"
									  ).createSession();System.out.println("""session  : scala.slick.session.Session = """ + $show(session ));$skip(283); 
									  
	session withTransaction {
	
		// Standard tables
		UserProfiles.ddl.create(session)
		Groups.ddl.create(session)
		Roles.ddl.create(session)
		
		// Tables with foreign keys
		Users.ddl.create(session)
		UserGroups.ddl.create(session)
		UserRoles.ddl.create(session)
	}}
	
	
}
