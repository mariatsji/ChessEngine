package core

class ChessBoard(val occupants: List[(Piece, Square)]) {

  def add(piece: Piece, square: Square): ChessBoard = new ChessBoard(occupants.::(piece, square))

  def without(square: Square): ChessBoard = new ChessBoard(occupants.filter(t => t._2 != square))

  def isVacant(square: Square) = !occupants.exists(ps => ps._2 == square)

  def hasThisColorPieceAtSquare(square: Square, color: Color) = pieceAt(square) match {
    case None => false
    case Some(piece) => piece.color == color
  }

  def pieceAt(square: Square): Option[Piece] = {
    val filtered: List[(Piece, Square)] = occupants.filter(t => t._2 == square)
    if (filtered.isEmpty) {
      None
    } else {
      Some(filtered.head._1)
    }
  }

  def isLegal = noPiecesOutsideBoard && onlyOnePiecePrSquare

  def noPiecesOutsideBoard = occupants.exists(p => !inside(p._2))

  def onlyOnePiecePrSquare = occupants.map(_._2).distinct.size == occupants.size

  private def inside(s: Square) = List('A','B','C','D','E','F','G','H').contains(s.file) && s.row >= 1 && s.row <=8

}

case class Piece(pieceType: PieceType, color: Color)

trait Color
object White extends Color
object Black extends Color

class PieceType(val value: Float)
case class Pawn() extends PieceType(1f)
case class Knight() extends PieceType(3f)
case class Bishop() extends PieceType(3f)
case class Rook() extends PieceType(5f)
case class Queen() extends PieceType(9f)
case class King() extends PieceType(999f)

case class Square(file: Char, row: Short) {

  def right() = Square((file.toInt + 1).toChar, row)
  def left() = Square((file.toInt - 1).toChar, row)
  def up() =  Square(file, (row + 1).toShort)
  def down() = Square(file, (row + 1).toShort)

  def rightOption() : Option[Square] = if (file != 'H') Some(Square((file.toInt + 1).toChar, row)) else None
  def leftOption() : Option[Square] = if (file != 'A') Some(Square((file.toInt - 1).toChar, row)) else None
  def upOption() : Option[Square] = if (row != 8) Some(Square(file, (row + 1).toShort)) else None
  def downOption() : Option[Square] = if (row != 8) Some(Square(file, (row + 1).toShort)) else None

}

object ChessBoardBuilder {

  def newBoard() =
    new ChessBoard(List((Piece(Rook(), White), Square('A', 1))))
      .add(Piece(Knight(), White), Square('B', 1))
      .add(Piece(Bishop(), White), Square('C', 1))
      .add(Piece(Queen(), White), Square('D', 1))
      .add(Piece(King(), White), Square('E', 1))
      .add(Piece(Bishop(), White), Square('F', 1))
      .add(Piece(Knight(), White), Square('G', 1))
      .add(Piece(Rook(), White), Square('H', 1))
      .add(Piece(Pawn(), White), Square('A', 2))
      .add(Piece(Pawn(), White), Square('B', 2))
      .add(Piece(Pawn(), White), Square('C', 2))
      .add(Piece(Pawn(), White), Square('D', 2))
      .add(Piece(Pawn(), White), Square('E', 2))
      .add(Piece(Pawn(), White), Square('F', 2))
      .add(Piece(Pawn(), White), Square('G', 2))
      .add(Piece(Pawn(), White), Square('H', 2))
      .add(Piece(Pawn(), Black), Square('A', 7))
      .add(Piece(Pawn(), Black), Square('B', 7))
      .add(Piece(Pawn(), Black), Square('C', 7))
      .add(Piece(Pawn(), Black), Square('D', 7))
      .add(Piece(Pawn(), Black), Square('E', 7))
      .add(Piece(Pawn(), Black), Square('F', 7))
      .add(Piece(Pawn(), Black), Square('G', 7))
      .add(Piece(Pawn(), Black), Square('H', 7))
      .add(Piece(Rook(), Black), Square('A', 8))
      .add(Piece(Knight(), Black), Square('B', 8))
      .add(Piece(Bishop(), Black), Square('C', 8))
      .add(Piece(Queen(), Black), Square('D', 8))
      .add(Piece(King(), Black), Square('E', 8))
      .add(Piece(Bishop(), Black), Square('F', 8))
      .add(Piece(Knight(), Black), Square('G', 8))
      .add(Piece(Rook(), Black), Square('H', 8))
}
