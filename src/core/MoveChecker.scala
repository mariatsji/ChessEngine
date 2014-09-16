package core

class MoveChecker {



  def possiblePositions(pos: Position, ps: (Piece,Square)) : Set[Position] = {
    val piece = ps._1
    piece.pieceType match {
      case Pawn() => PawnChecker.pawnCanGoTo(pos, ps)
      case Knight() => KnightChecker.knightCanGoTo(pos, ps)
      case Bishop() => bishopCanGoTo(pos, ps)
      case Rook() => rookCanGoTo(pos, ps)
      case Queen() => queenCanGoTo(pos, ps)
      case King() => kingCanGoTo(pos, ps)
    }
  }

  def bishopCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def rookCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def queenCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def kingCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???


}

object MoveChecker {

  //todo - make sure you didnt expose a self-check or something..
  def isLegal(pos: Position): Boolean = true

}
