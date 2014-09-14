package core


object ChessBoardPrinter {

  private def unicodeChessSymbol(piece: Piece): String = {
    piece match {
      case Piece(Pawn(), color) => if (color == White) "\u2659" else "\u265F"
      case Piece(Knight(), color) => if (color == White) "\u2658" else "\u265E"
      case Piece(Bishop(), color) => if (color == White) "\u2657" else "\u265D"
      case Piece(Rook(), color) => if (color == White) "\u2656" else "\u265C"
      case Piece(Queen(), color) => if (color == White) "\u2655" else "\u265B"
      case Piece(King(), color) => if (color == White) "\u2654" else "\u265A"
    }
  }

  def printz(board: ChessBoard): Unit = {
    def pieceAt(square: Square) : (Square, Option[Piece]) = {
      val opt: Option[(Piece, Square)] =
        board.occupants.find(t => t._2.row == square.row && t._2.file == square.file)
      if (opt.isEmpty) {
        (square, None)
      } else {
        (square, Option(opt.get._1))
      }
    }
    def stringFrom(o: (Square, Option[Piece])) : String = {
      if (o._2.isEmpty && o._1.file != 'H') {
        " "
      } else if (o._2.isEmpty) {
        " \n"
      } else if (o._1.file != 'H') {
        unicodeChessSymbol(o._2.get)
      } else {
        unicodeChessSymbol(o._2.get) + "\n"
      }
    }
    val strings = for (
      row <- List(8,7,6,5,4,3,2,1);
      file <- List('A','B','C','D','E','F','G','H')) yield
        stringFrom(pieceAt(Square(file, row.toShort)))
    strings.foreach(print)

  }

}
