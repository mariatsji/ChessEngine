package core

abstract class AbstractMoveChecker {

  def canGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = {
    val toVacantMoves: Set[Position] = positionsReachable(position, tuple)
    toVacantMoves.filter(p => p.isLegal)
  }

  def positionsReachable(position: Position, tuple: (Piece, Square)): Set[Position]

}
