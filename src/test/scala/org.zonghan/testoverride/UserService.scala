package org.zonghan.testoverride

/**
  * Created by wuzonghan on 2017/4/21.
  */
trait UserService {
  def login(credentials: Credentials): UserSession

  def logout(session: UserSession): Unit
  def isLoggedIn(session: UserSession): Boolean
  def changePassword(session: UserSession, credentials: Credentials): Boolean
}

class UserSession

class Credentials