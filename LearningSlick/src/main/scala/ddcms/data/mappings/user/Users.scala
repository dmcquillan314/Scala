package ddcms.data.mappings.user

import scala.slick.driver.MySQLDriver.simple._

case class User(id: Int, username: String, password: String, profileId: Int)

object Users extends Table[User]("USER") {
	def id = column[Int]("USER_ID", O.PrimaryKey)
	def username = column[String]("USER_NAME")
	def password = column[String]("PASSWORD")
	def profileId = column[Int]("USER_PROFILE_ID")
	
	def * = id ~ username ~ password ~ profileId <> (User, User.unapply _)
	
	// Foreign Keys
	def userProfile = foreignKey("USERS_USER_PROFILE_FK", profileId, UserProfiles)(_.id)
	
    // A method that returns an instance by specified property
    def byId = createFinderBy(_.id)
}