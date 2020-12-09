package dk.versio.aoc2020

import scala.annotation.tailrec

object Dec09 extends App {

  @tailrec
  def compute(pre: List[Long], rest: List[Long]): Long =
    if (pre.combinations(2).exists(_.sum == rest.head))
      compute(pre.drop(1) :+ rest.head, rest.drop(1)) else rest.head

  @tailrec
  def isWeak(pre: List[Long], weak: Long, pos: Int = 2): Option[List[Long]] =
    if (pre.take(pos).sum == weak) Option(pre.take(pos))
    else if (pre.take(pos).sum > weak) None else isWeak(pre, weak, pos + 1)

  def findWeak(input: List[Long], weak: Long) = input.zipWithIndex.find(l =>
    isWeak(input.drop(l._2), weak).isDefined).flatMap(l => isWeak(input.drop(l._2), weak).map(p => p.min + p.max))

  val input = Common.loadNumbers("09.txt")
  val weak = Dec09.compute(input.take(25), input.drop(25))
  println(weak)
  println(findWeak(input, weak))
}