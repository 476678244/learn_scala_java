package org.zonghan

/**
  * Created by wuzonghan on 17/2/14.
  */
import java.util._
/**
  * Created by 摇摆少年梦 on 2015/8/16.
  */
case class Person2(val name:String,val age:Int)
//在Java中Comparator是这么用的：Comparator<Person>
//而在Scala中，是这么用的：Comparator[Person]
class PersonComparator extends Comparator[Person2]{
  override def compare(o1: Person2, o2: Person2): Int = if(o1.age>o2.age) 1 else -1
}
object ScalaUseJavaComparator extends  App{
  val p1=Person2("摇摆少年梦",27)
  val p2=Person2("李四",29)
  val personComparator=new PersonComparator()
  if(personComparator.compare(p1,p2)>0) println(p1)
  else println(p2)

}
