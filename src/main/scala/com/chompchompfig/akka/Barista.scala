package com.chompchompfig.akka

import akka.actor.{ActorLogging, Props}
import akka.persistence.PersistentActor


object Events {

  abstract class Event {}
  case class CoffeeOrdered(val name : String, val quantity: Int) extends Event {}

}

object Barista {

  def props() : Props = {
    Props(classOf[Barista])
  }

}

class Barista extends PersistentActor with ActorLogging {

  var coffeesDeliveredToday = 0

  override def persistenceId: String = "barista"

  override def receiveRecover: Receive = {
    case Events.CoffeeOrdered(name, quantity) => {
      coffeesDeliveredToday += quantity
      log.info(s"----- coffee $name order recovered. total coffees ordered so far $coffeesDeliveredToday")
    }
  }

  override def receiveCommand: Receive = {
    case CoffeeShop.OrderCoffee(name) => persist(Events.CoffeeOrdered(name, 1)) {
      event => {
        coffeesDeliveredToday += event.quantity
        log.info(s"----- ${event.quantity} coffee(s) ${event.name} has/have been ordered, and the barista is now working")
      }
    }
    case CoffeeShop.TotalCoffeesOrdered => log.info(s" .... Total coffees ordered $coffeesDeliveredToday")
    case CoffeeShop.Blow => throw new IllegalArgumentException("The barista is not feeling well")
  }

}
