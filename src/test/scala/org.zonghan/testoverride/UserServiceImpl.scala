package org.zonghan.testoverride

/**
 * Created by wuzonghan on 2017/4/21.
 */
trait UserServiceImpl extends UserService {
  override def login(credentials: Credentials): UserSession = new UserSession {}

  def logout(session: UserSession): Unit
  override def isLoggedIn(session: UserSession): Boolean = true
  override def changePassword(session: UserSession, credentials: Credentials): Boolean = true
}
