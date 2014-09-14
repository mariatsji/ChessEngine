package core

case class Position(board: ChessBoard, inTheMove: Color, anPassantPossible: Boolean = false) {

  def opponent = if (inTheMove == White) Black else White

}
