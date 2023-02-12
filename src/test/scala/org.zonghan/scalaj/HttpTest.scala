package org.zonghan.scalaj

import scalaj.http.Http

object HttpTest extends App {

  val response = Http("http://www.baidu.com").asString
  println(response.code)
  println(response.body)
}
