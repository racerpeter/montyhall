package monty

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}

object Times {
  val NUM = 10000000
}

object Monty extends App {
  protected val system = ActorSystem("monty")

  protected val resultsActor = system.actorOf(Props[ResultsActor], name = "results")

  protected val simulatorActor = {
    val routees = Vector.fill(4) {
      val r = system.actorOf(Props(new SimulatorActor(resultsActor)))
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  sys.addShutdownHook({
    system.shutdown()
  })

  1 to Times.NUM foreach { _ => simulatorActor route(monty.SimulatorActor.SimRequest, ActorRef.noSender) }
}
