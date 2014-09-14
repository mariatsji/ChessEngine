package core

case class Position(board: ChessBoard, inTheMove: Color, enPassantRow: Option[Char] = None) {

  def opponent = if (inTheMove == White) Black else White

}
