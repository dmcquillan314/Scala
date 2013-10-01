package ddcms.data.mappings.user.joins

import scala.slick.driver.MySQLDriver.simple._

import ddcms.data.mappings.user.{Users,Roles}

case class UserRole(userId: Int, roleId: Int)

object UserRoles extends Table[UserRole]("USER_ROLES") {
	def userId = column[Int]("USER_ID")
	def roleId = column[Int]("GROUP_ID")
	
	// Foreign Keys
	def user = foreignKey("USER_ROLES_USER_FK", userId, Users)(_.id)
	def role = foreignKey("USER_ROLES_ROLE_FK", roleId, Roles)(_.id)

	def * = userId ~ roleId <> (UserRole, UserRole.unapply _)
	
}