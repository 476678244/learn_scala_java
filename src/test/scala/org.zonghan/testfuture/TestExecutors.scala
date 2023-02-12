package org.zonghan.testfuture

import java.util.concurrent.{Callable, ExecutorService, Executors}

/**
  * Created by wuzonghan on 2017/12/12.
  */
object TestExecutors extends App {

  val pool: ExecutorService = Executors.newFixedThreadPool(10)

  val calls = Range(0, 1000).map(index => {
    new Callable[Int] {
      override def call(): Int = {
        Thread.sleep(10)
        println("start " + index)
        index
      }
    }
  })

  val futures = calls.map(call => {
    pool.submit(call)
  })

  pool.shutdown()

  futures.foreach(future => {
    println("finish " + future.get())
  })
}
