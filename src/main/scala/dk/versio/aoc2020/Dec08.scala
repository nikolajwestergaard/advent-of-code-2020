package dk.versio.aoc2020

import scala.annotation.tailrec
import scala.io.Source

object Dec08 extends App {
  type InstSet = List[(String, Int)]

  def load(file: String): InstSet = Source.fromResource(file).getLines().map(_.split(" ")).map(a => (a(0), a(1).toInt)).toList

  @tailrec
  def compute(program: InstSet, pos: Int = 0, acc: Int = 0, history: List[Int] = List()): Either[Int, Int] = {
    if (history.contains(pos)) return Right(acc)
    if (program.length <= pos) return Left(acc)
    program(pos) match {
      case ("nop", _) => compute(program, pos + 1, acc, history :+ pos)
      case ("acc", a) => compute(program, pos + 1, acc + a, history :+ pos)
      case ("jmp", j) => compute(program, pos + j, acc, history :+ pos)
    }
  }

  def findValid(program: InstSet) = program.zipWithIndex.filter(_._1._1 == "jmp")
    .find(p => compute(program.updated(p._2, ("nop", 0))).isLeft).map(p => compute(program.updated(p._2, ("nop", 0))))

  println(compute(load("08.txt")))
  println(findValid(load("08.txt")))
}