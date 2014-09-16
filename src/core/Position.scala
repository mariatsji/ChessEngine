package core

case class Position(board: ChessBoard, inTheMove: Color, enPassantRow: Option[Char] = None) {

  def opponent = if (inTheMove == White) Black else White

}

object Position {

  def ownPieceOccupySquare(pos: Position, square: Square) : Boolean = {
    pos.board.pieceAt(square) match {
      case None => false
      case Some(piece) => piece.color == pos.inTheMove
    }
  }

}
