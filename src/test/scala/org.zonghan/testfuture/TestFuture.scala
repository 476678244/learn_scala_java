package org.zonghan.testfuture

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
  * Created by wuzonghan on 2017/12/12.
  */
object TestFuture extends App {

  val future = Future {
    Thread.sleep(1000 * 1)
    1
  }

  println("future created!")

  Await.result(future, Duration.fromNanos(1000 * 1000 * 1000 * 2))

  future.onComplete {
    case Success(x) => println("yay!" + x)
    case Failure(_) => println("On no!")
  }

  val tasks: Seq[Future[Int]] = for (i <-(1 to  10).toList.zipWithIndex) yield Future {
    println("Executing task " + i)
    1
  }

  val aggregated: Future[Seq[Int]] = Future.sequence(tasks)

  val squares: Seq[Int] = Await.result(aggregated, Duration.Inf)
}
