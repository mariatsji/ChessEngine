package core

class ChessBoard(val occupants: List[(Piece, Square)]) {
  def add(piece: Piece, square: Square): ChessBoard = new ChessBoard(occupants.::(piece, square))
  def without(square: Square): ChessBoard = new ChessBoard(occupants.filter(t => t._2 != square))
}

case class Piece(pieceType: PieceType, color: Color)

trait Color
object White extends Color
object Black extends Color

class PieceType
case class Pawn() extends PieceType
case class Knight() extends PieceType
case class Bishop() extends PieceType
case class Rook() extends PieceType
case class Queen() extends PieceType
case class King() extends PieceType

case class Square(file: Char, row: Short) {
  require(row >= 0 && row <=8)
  require(List('A','B','C','D','E','F','G','H').contains(file))
}

object ChessBoardBuilder {

  def build() =
    new ChessBoard(List((Piece(new Rook(), White), Square('A', 1))))
      .add(Piece(new Knight(), White), Square('B', 1))
      .add(Piece(new Bishop(), White), Square('C', 1))
      .add(Piece(new Queen(), White), Square('D', 1))
      .add(Piece(new King, White), Square('E', 1))
      .add(Piece(new Bishop(), White), Square('F', 1))
      .add(Piece(new Knight(), White), Square('G', 1))
      .add(Piece(new Rook(), White), Square('H', 1))
      .add(Piece(new Pawn(),White), Square('A', 2))
      .add(Piece(new Pawn(),White), Square('B', 2))
      .add(Piece(new Pawn(),White), Square('C', 2))
      .add(Piece(new Pawn(),White), Square('D', 2))
      .add(Piece(new Pawn(),White), Square('E', 2))
      .add(Piece(new Pawn(),White), Square('F', 2))
      .add(Piece(new Pawn(),White), Square('G', 2))
      .add(Piece(new Pawn(),White), Square('H', 2))
      .add(Piece(new Pawn(),Black), Square('A', 7))
      .add(Piece(new Pawn(),Black), Square('B', 7))
      .add(Piece(new Pawn(),Black), Square('C', 7))
      .add(Piece(new Pawn(),Black), Square('D', 7))
      .add(Piece(new Pawn(),Black), Square('E', 7))
      .add(Piece(new Pawn(),Black), Square('F', 7))
      .add(Piece(new Pawn(),Black), Square('G', 7))
      .add(Piece(new Pawn(),Black), Square('H', 7))
      .add(Piece(new Rook(), Black), Square('A', 8))
      .add(Piece(new Knight(), Black), Square('B', 8))
      .add(Piece(new Bishop(), Black), Square('C', 8))
      .add(Piece(new Queen(), Black), Square('D', 8))
      .add(Piece(new King(), Black), Square('E', 8))
      .add(Piece(new Bishop(), Black), Square('F', 8))
      .add(Piece(new Knight, Black), Square('G', 8))
      .add(Piece(new Rook, Black), Square('H', 8))
}
