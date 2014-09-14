package core

object ChessApp {

  def main(args: Array[String]) {
    val board = ChessBoardBuilder.build()
    ChessBoardPrinter.printz(programmedMoves(board))
  }

  def programmedMoves(board : ChessBoard) : ChessBoard = {
    board
      .without(Square('E',2))
      .add(Piece(new Pawn(), White), Square('E',4))
      .without(Square('E',7))
      .add(Piece(new Pawn(), Black), Square('E',5))
  }

  //def move(board:ChessBoard, algebra: String) : ChessBoard = {
  //}

}
