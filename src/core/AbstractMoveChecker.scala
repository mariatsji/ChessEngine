package core

abstract class AbstractMoveChecker {

  def canGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = {

    val (piece, square) = tuple
    val newBoardWithout = position.board.without(square)

    allPossibleSquares(position, tuple)
      .filter(Square.isInsideBoard)
      .filter(!Position.ownPieceOccupySquare(position, _))
      .map {
      s => new Position(newBoardWithout.without(s).add(piece, s), position.opponent//todo don't take the king here..
      )
    }.filter(MoveChecker.isLegal)
  }

  def allPossibleSquares(position: Position, tuple: (Piece, Square)): Set[Square]

}
