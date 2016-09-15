package monty

import akka.actor.{Actor, ActorRef, Props}

import scala.util.Random

object SimulatorActor {
  case object SimRequest
  case object Goat
  case object Motorcycle
}

class SimulatorActor(resultsActor: ActorRef) extends Actor {
  import monty.SimulatorActor._

  def receive = {
    case SimRequest =>
      //do stuff
      val shuffled = Random.shuffle(Seq(Goat, Goat, Motorcycle))

      val resultOne:Int = shuffled match {
        case Seq(Motorcycle, _, _) => 1
        case _ => 0
      }

      val resultTwo:Int = shuffled match {
        case Seq(Goat, _, _) => 1
        case Seq(_, Goat, _) => 0
      }

      resultsActor ! monty.ResultsActor.SimResult(resultOne, resultTwo)
  }
}
