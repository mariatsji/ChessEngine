package core

import scala.util.matching.Regex

/** examples of each type of algebraic move:
e2 <- pawn move
exd4 <- take (always the same)
g8Q <- pawn promotion
g8Q+ <- pawn promotion with check
s3g8 <- disamb move row
shg8 <- disamb move file
s3xa8 <- disamb take file
shxa8 <- disamb take row
sd3+ <- check
sd3# <- mate


 */
class MoveParser {

  def toSquareString(algebraic: String) : (String,String) = {
    val r: Regex = "[a-hA-H][1-8]".r
    (r.findFirstIn(algebraic).getOrElse(""), r.replaceFirstIn(algebraic, ""))
  }

  def parse(board:ChessBoard, algebraic:String) : ChessBoard = {
    val (toSquareS, restAlg) = toSquareString(algebraic)
    //found the to square
    //from square/piece -> find piece that can legally move to that square
    board//TODO
  }

}

object MoveParser extends App {
  List(
    new MoveParser().toSquareString("e4"),
    new MoveParser().toSquareString("exd4"),
    new MoveParser().toSquareString("g8Q"),
    new MoveParser().toSquareString("g8Q+"),
    new MoveParser().toSquareString("shg8"),
    new MoveParser().toSquareString("s3xa8"),
    new MoveParser().toSquareString("sdxa8")
  ).foreach(println)
}
