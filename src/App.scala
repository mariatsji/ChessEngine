class App {

  def main(args: Array[String]) {
    val board = ChessBoardBuilder.build()
    ChessBoardPrinter.print(board)
  }
  
}
