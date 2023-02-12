package org.zonghan.interview

import scala.collection.mutable

object TestBBB extends App {

  /*
  * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。

    在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。

    例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

    示例 1：

    输入：numCourses = 2, prerequisites = [[1,0]]
    输出：true
    解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    示例 2：

    输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    输出：false
    解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

    提示：

      1 <= numCourses <= 105
      0 <= prerequisites.length <= 5000
      prerequisites[i].length == 2
      0 <= ai, bi < numCourses
      prerequisites[i] 中的所有课程对 互不相同
  * */

  val map = new mutable.HashMap[Int, Set[Int]]()
  map.put(2, Set(1))
  // 2 -> Set(2)
  // 1 -> Set(1,2)
  map.put(1, Set(0))
  // 0 -> Set(0, 1,2)
  map.put(0, Set(2))
  // stop Set(0,1,2).contains(2)

  val fineSet = Set(2)
  // Set(2,1,3,4,5,6)

  map.put(2, Set(1, 3))
  // Set(2)
  // Set(2,1)
  map.put(1, Set(3, 4))
  // Set(2,1,3)
  map.put(3, Set(5, 6))

  map.put(10, Set(2))
  // Set(2,1,3,5,6)
  // Set(2,1,3)
  // Set(2,1)
  // Set(2,1,4)
  // Set(2,1)

  val courses = List(0, 1, 2)

  for (i <- courses) {
    for (j <- courses) {
      if (i != j) {
        if (map(i).contains(j) && map(j).contains(i)) {
          //          return false
        }
      }
    }
  }
  //  return true

}
