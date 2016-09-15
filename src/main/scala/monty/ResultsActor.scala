package monty

import akka.actor.Actor

object ResultsActor {
  case class SimResult(tacticOneDidWin: Int, tacticTwoDidWin: Int)
  case class SimResults(averageTacticOne: Float, averageTacticTwo: Float)
}

class ResultsActor extends Actor {
  import monty.ResultsActor._

  protected var numResults: Long = 0
  protected var runningTotalTacticOne: Long = 0
  protected var runningTotalTacticTwo: Long = 0
  protected var start: Long = 0

  override def preStart(): Unit = {
    start = System.currentTimeMillis
    super.preStart()
  }

  def receive = {
    case result: SimResult =>
      runningTotalTacticOne += result.tacticOneDidWin
      runningTotalTacticTwo += result.tacticTwoDidWin
      numResults += 1

      if(numResults >= Times.NUM) {
        val averageOne = runningTotalTacticOne / numResults.asInstanceOf[Float]
        val averageTwo = runningTotalTacticTwo / numResults.asInstanceOf[Float]
        val time = (System.currentTimeMillis - start) / 1000.0

        println(s"Finished ${Times.NUM} runs with ${averageOne}% / ${averageTwo}% in ${time} seconds.")
        context.system.shutdown()
      }
  }
}
