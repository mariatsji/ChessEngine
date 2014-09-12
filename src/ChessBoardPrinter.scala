
object ChessBoardPrinter {

  private def unicodeChessSymbol(piece: Piece): String = {
    piece match {
      case Piece(Pawn, color) => if (color == White) "\u2659" else "\u265F"
      case Piece(Knight, color) => if (color == White) "\u2658" else "\u265E"
      case Piece(Bishop, color) => if (color == White) "\u2657" else "\u265D"
      case Piece(Rook, color) => if (color == White) "\u2656" else "\u265C"
      case Piece(Queen, color) => if (color == White) "\u2655" else "\u265B"
      case Piece(King, color) => if (color == White) "\u2654" else "\u265A"
    }
  }

  def print(board: ChessBoard): Unit = {
    //TODO pick up the progress here..

  }


}
