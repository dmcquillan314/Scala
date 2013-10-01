package ddcms.data.mappings.user

import scala.slick.driver.MySQLDriver.simple._

case class Group(id: Int, groupName: String, groupDesc: String)

object Groups extends Table[Group]("GROUP") {
	def id = column[Int]("GROUP_ID", O.PrimaryKey)
	def groupName = column[String]("GROUP_NAME")
	def groupDesc = column[String]("GROUP_DESC")
	
	def * = id ~ groupName ~ groupDesc <> (Group, Group.unapply _)
	
	def ins = groupName returning id
	
	def byId = createFinderBy(_.id)
	
}