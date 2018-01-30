package com.chompchompfig.akka

import akka.actor.{Actor, ActorLogging, Props}
import com.chompchompfig.akka.CoffeeShop.OrderCoffee

object Customer {

  def props(): Props = {
    Props(classOf[Customer])
  }
}

class Customer extends Actor with ActorLogging {

  val baristaSelection = context.actorSelection("/user/barista")

  override def receive() : Receive = {
    case OrderCoffee(name) => {
      baristaSelection ! OrderCoffee(name)
      log.info(s"---- customer ordered coffee $name to ... $baristaSelection")
    }
  }
}
