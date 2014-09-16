package core

abstract class AbstractMoveChecker {

  def canGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = {

    val toVacantMoves: Set[Position] = possibleVacantSquareMoves(position, tuple)
    val takingMoves: Set[Position] = possibleTakes(position, tuple)
    (toVacantMoves  ++ takingMoves).filter(p => p.isLegal)
  }

  def possibleVacantSquareMoves(position: Position, tuple: (Piece, Square)): Set[Position]

  def possibleTakes(position: Position, tuple: (Piece, Square)): Set[Position]

}
