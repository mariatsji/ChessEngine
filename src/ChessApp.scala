object ChessApp {

  def main(args: Array[String]) {
    val board = ChessBoardBuilder.build()

    ChessBoardPrinter.printz(board)

  }

  def programmedMoves(board : ChessBoard) : ChessBoard = {
    board
      .without(Square('E',2))
      .add(Piece(Pawn, White), Square('E',4))
  }

  //def move(board:ChessBoard, algebra: String) : ChessBoard = {
  //}



}
