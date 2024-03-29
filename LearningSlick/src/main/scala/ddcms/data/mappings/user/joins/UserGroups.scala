package ddcms.data.mappings.user.joins

import scala.slick.driver.MySQLDriver.simple._

import ddcms.data.mappings.user.{Users,Groups}

case class UserGroup(userId: Int, groupId: Int)

object UserGroups extends Table[UserGroup]("USER_GROUPS") {
	def userId = column[Int]("USER_ID")
	def groupId = column[Int]("GROUP_ID")
	
	// Foreign Keys
	def user = foreignKey("USER_GROUPS_USER_FK", userId, Users)(_.id)
	def group = foreignKey("USER_GROUPS_GROUP_FK", groupId, Groups)(_.id)

	def * = userId ~ groupId <> (UserGroup, UserGroup.unapply _)
	
}