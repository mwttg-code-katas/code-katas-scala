package org.sudoku2.helper

import scala.util.Try

object StringHelper {

  implicit class IsNumberHelper(input: String) {
    def isNumber: Boolean = Try(input.toInt).isSuccess
  }
}
