package dk.versio.aoc2020

import scala.io.Source

object Dec04 extends App {

  def loadPassports(file: String) = Source
    .fromResource(file).getLines()
    .foldLeft(List(List[String]()))((list, line) =>
      if (line.isEmpty) list :+ List() else list.init :+ (list.last ::: line.split(" ").toList))

  def getValid(file: String) = loadPassports(file)
    .map(_.filter(!_.startsWith("cid:"))).filter(_.length >= 7)

  def getValidExtended(file: String) = getValid(file)
    .map(_.map(_.split(":")))
    .filter(!_.exists {
      case Array("byr", v) => v.toInt < 1920 || v.toInt > 2002
      case Array("iyr", v) => v.toInt < 2010 || v.toInt > 2020
      case Array("eyr", v) => v.toInt < 2020 || v.toInt > 2030
      case Array("hgt", v) if v.endsWith("cm") => v.stripSuffix("cm").toInt < 150 || v.stripSuffix("cm").toInt > 193
      case Array("hgt", v) if v.endsWith("in") => v.stripSuffix("in").toInt < 59 || v.stripSuffix("in").toInt > 76
      case Array("hcl", v) => !v.matches("#[0-9a-f]{6}")
      case Array("ecl", v) => !v.matches("(amb|blu|brn|gry|grn|hzl|oth)")
      case Array("pid", v) => !v.matches("[0-9]{9}")
      case _ => true // Mark invalid formats as error
    })

  println(getValid("04.txt").length)
  println(getValidExtended("04.txt").length)
}