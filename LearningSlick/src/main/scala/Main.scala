

import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession
import ddcms.data.mappings.user.{Groups,Roles,Users,UserProfiles}
import ddcms.data.mappings.user.joins.{UserGroups,UserRoles}



object Main extends App {
	implicit val session = Database.forURL(
											"jdbc:mysql://some-host:3306/slick",
											driver = "com.mysql.jdbc.Driver",
											user = "root",
											password = "snow314eagle159"
									  ).createSession()
	session withTransaction {
		Users.ddl.create(session)
		Groups.ddl.create(session)
		Roles.ddl.create(session)
	}								 
}