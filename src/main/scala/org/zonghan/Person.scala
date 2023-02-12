package org.zonghan

/**
  * Created by wuzonghan on 17/2/14.
  */
class Person(val name:String,val age:Int)
//伴生对象
object Person{
  def getIdentityNo()= {"test"}
}
//ScalaInJava.java文件中定义了ScalaInJava类
//直接调用Scala中的Person类
