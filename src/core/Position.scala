package core

case class Position(board: ChessBoard, inTheMove: Color, enPassantRow: Option[Char] = None) {

  def opponent = if (inTheMove == White) Black else White

  def ownPieceOccupySquare(square: Square) : Boolean = {
    board.pieceAt(square) match {
      case None => false
      case Some(piece) => piece.color == inTheMove
    }
  }

  //todo - make sure you didnt expose a self-check or something..
  def isLegal: Boolean = board.isLegal

  def isCheck: Boolean = ???

  def isMate: Boolean = ???

}
