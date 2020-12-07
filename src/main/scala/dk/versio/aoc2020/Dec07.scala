package dk.versio.aoc2020

import scala.io.Source

object Dec07 extends App {
  type BagGraph = List[((String, String), (String, String, Int))]

  def loadBags(file: String): BagGraph = Source.fromResource(file).getLines().toList.filter(!_.contains("contain no"))
    .flatMap(l => {
      val bag = l.split(" ", 8).toList
      ((bag.head, bag(1)), (bag(5), bag(6), bag(4).toInt)) +: l.split(", ").drop(1).map(_.split(" ").toList)
        .map(p => ((bag.head, bag(1)), (p(1), p(2), p.head.toInt))).toList
    })

  def getCombinations(bagGraph: BagGraph, target: (String, String)): List[(String, String)] = {
    val l = bagGraph.filter(b => target.equals((b._2._1, b._2._2)))
    (l.map(_._1) ::: l.flatMap(b => getCombinations(bagGraph, b._1))).distinct
  }

  def countBags(bagGraph: BagGraph, target: (String, String)): Int = bagGraph.filter(_._1.equals(target))
    .map(b => b._2._3 + (b._2._3 * countBags(bagGraph, (b._2._1, b._2._2)))).sum

  println(getCombinations(loadBags("07.txt"), ("shiny", "gold")).length)
  println(countBags(loadBags("07.txt"), ("shiny", "gold")))
}