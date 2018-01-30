package com.chompchompfig.akka

object CoffeeShop {

  abstract class Command() {}

  case class OrderCoffee(name : String) extends Command {}
  case class TotalCoffeesOrdered() extends Command {}
  case class Blow() extends Command {}

}
