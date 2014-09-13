class ChessBoard(val occupants: List[(Piece, Square)]) {
  def add(piece: Piece, square: Square): ChessBoard = new ChessBoard(occupants.::(piece, square))
  def without(square: Square): ChessBoard = new ChessBoard(occupants.filter(t => t._2 != square))
}

case class Piece(pieceType: PieceType, color: Color)

trait Color
object White extends Color
object Black extends Color

trait PieceType
object Pawn extends PieceType
object Knight extends PieceType
object Bishop extends PieceType
object Rook extends PieceType
object Queen extends PieceType
object King extends PieceType

case class Square(file: Char, row: Short) {
  require(row >= 0 && row <=8)
  require(List('A','B','C','D','E','F','G','H').contains(file))
}

object ChessBoardBuilder {

  def build() =
    new ChessBoard(List((Piece(Rook, White), Square('A', 1))))
      .add(Piece(Knight, White), Square('B', 1))
      .add(Piece(Bishop, White), Square('C', 1))
      .add(Piece(Queen, White), Square('D', 1))
      .add(Piece(King, White), Square('E', 1))
      .add(Piece(Bishop, White), Square('F', 1))
      .add(Piece(Knight, White), Square('G', 1))
      .add(Piece(Rook, White), Square('H', 1))
      .add(Piece(Pawn, White), Square('A', 2))
      .add(Piece(Pawn, White), Square('B', 2))
      .add(Piece(Pawn, White), Square('C', 2))
      .add(Piece(Pawn, White), Square('D', 2))
      .add(Piece(Pawn, White), Square('E', 2))
      .add(Piece(Pawn, White), Square('F', 2))
      .add(Piece(Pawn, White), Square('G', 2))
      .add(Piece(Pawn, White), Square('H', 2))
      .add(Piece(Pawn, Black), Square('A', 7))
      .add(Piece(Pawn, Black), Square('B', 7))
      .add(Piece(Pawn, Black), Square('C', 7))
      .add(Piece(Pawn, Black), Square('D', 7))
      .add(Piece(Pawn, Black), Square('E', 7))
      .add(Piece(Pawn, Black), Square('F', 7))
      .add(Piece(Pawn, Black), Square('G', 7))
      .add(Piece(Pawn, Black), Square('H', 7))
      .add(Piece(Rook, Black), Square('A', 8))
      .add(Piece(Knight, Black), Square('B', 8))
      .add(Piece(Bishop, Black), Square('C', 8))
      .add(Piece(Queen, Black), Square('D', 8))
      .add(Piece(King, Black), Square('E', 8))
      .add(Piece(Bishop, Black), Square('F', 8))
      .add(Piece(Knight, Black), Square('G', 8))
      .add(Piece(Rook, Black), Square('H', 8))
}
