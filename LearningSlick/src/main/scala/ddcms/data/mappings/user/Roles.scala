package ddcms.data.mappings.user

import scala.slick.driver.MySQLDriver.simple._

case class Role(id: Int, role: String)

object Roles extends Table[Role]("ROLE") {
	def id = column[Int]("ROLE_ID", O.PrimaryKey)
	def role = column[String]("ROLE")
	
	def * = id ~ role <> (Role, Role.unapply _)
	
	def ins = role returning id
	
	def byId = createFinderBy(_.id)
}