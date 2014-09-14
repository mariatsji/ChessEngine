package core

class MoveChecker {

  def possiblePositions(pos: Position, ps: (Piece,Square)) : Set[Position] = {
    val piece = ps._1
    piece.pieceType match {
      case Pawn() => pawnCanGoTo(pos, ps)
      case Knight() => knightCanGoTo(pos, ps)
      case Bishop() => bishopCanGoTo(pos, ps)
      case Rook() => rookCanGoTo(pos, ps)
      case Queen() => queenCanGoTo(pos, ps)
      case King() => kingCanGoTo(pos, ps)
    }
  }

  def pawnCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = {
    val theSet = new scala.collection.mutable.HashSet[Position]
    val (pawn, square) = tuple
    val newBoardWithout = position.board.without(square)
    val aheadSquare = pawnAheadSquare(square, pawn.color)
    val twoAheadSquare = pawnAheadSquare(aheadSquare, pawn.color)
    if(position.board.isVacant(aheadSquare) && !isPromotionRow(aheadSquare, pawn.color)) {
      theSet += new Position(newBoardWithout.add(pawn, aheadSquare), position.opponent, false)
    } else if (isPromotionRow(aheadSquare, pawn.color)) {
      theSet += new Position(newBoardWithout.add(Piece(Queen(), pawn.color), aheadSquare), position.opponent, false)
      theSet += new Position(newBoardWithout.add(Piece(Rook(), pawn.color), aheadSquare), position.opponent, false)
      theSet += new Position(newBoardWithout.add(Piece(Bishop(), pawn.color), aheadSquare), position.opponent, false)
      theSet += new Position(newBoardWithout.add(Piece(Knight(), pawn.color), aheadSquare), position.opponent, false)
    } else if (isStartRow(square, pawn.color) && position.board.isVacant(twoAheadSquare)) {
      theSet += new Position(newBoardWithout.add(pawn, twoAheadSquare), position.opponent, true)
    } //TODO take
    theSet.toSet
    //TODO en passant
  }

  

  private val pawnAheadSquare : ((Square, Color) => Square) = (square, color) =>
    Square(square.file, (square.row + 1).toShort)

  private def isPromotionRow(square: Square, color:Color) = if(color == White) square.row == 8 else square.row == 1

  private def isStartRow(square: Square, color:Color) = if(color == White) square.row == 2 else square.row == 7

  def knightCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def bishopCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def rookCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def queenCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def kingCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???


}
