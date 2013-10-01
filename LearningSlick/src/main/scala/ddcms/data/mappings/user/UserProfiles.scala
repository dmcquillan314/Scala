package ddcms.data.mappings.user

import scala.slick.driver.MySQLDriver.simple._

case class UserProfile(id: Int, firstName: String, lastName: String)

object UserProfiles extends Table[UserProfile]("USER_PROFILE") {
	def id = column[Int]("USER_PROFILE_ID", O.PrimaryKey)
	def firstName = column[String]("FIRST_NAME")
	def lastName = column[String]("LAST_NAME")
	
	def * = id ~ firstName ~ lastName <> (UserProfile, UserProfile.unapply _)
	
    def byId = createFinderBy(_.id)
}