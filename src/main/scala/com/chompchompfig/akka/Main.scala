package com.chompchompfig.akka

import akka.actor.ActorSystem

object Main {

  val system = ActorSystem("CoffeeShop")
  val customer = system.actorOf(Customer.props, "customer")
  val barista = system.actorOf(Barista.props, "barista")

  def main(args : Array[String]): Unit = {
    customer ! CoffeeShop.OrderCoffee("latte")
    barista ! CoffeeShop.TotalCoffeesOrdered

    Thread.sleep(10000)
    barista ! CoffeeShop.Blow

    Thread.sleep(10000)
    barista ! CoffeeShop.TotalCoffeesOrdered
  }

}
