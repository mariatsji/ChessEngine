object ChessApp {

  def main(args: Array[String]) {
    val board = ChessBoardBuilder.build()
    ChessBoardPrinter.printz(board)
  }
  
}
