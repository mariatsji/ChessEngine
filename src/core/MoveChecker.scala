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

  def pawnCanGoTo (position: Position, tuple: (Piece, Square)): Set[Position] =
    whitePawnCanGoTo(position, tuple) ++ blackPawnCanGoTo(position, tuple)

  def blackPawnCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???


  def whitePawnCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = {
    val theSet = new scala.collection.mutable.HashSet[Position]
    val (pawn, square) = tuple
    val newBoardWithout = position.board.without(square)
    val aheadSquare = Square(square.file, (square.row + 1).toShort)
    val twoAheadSquare = Square(square.file, (square.row + 2).toShort)
    if(position.board.isVacant(aheadSquare) && aheadSquare.row != 8) {
      theSet += new Position(newBoardWithout.add(pawn, aheadSquare), Black, false)
    } else if (aheadSquare.row == 8) {
      val newQueen = Piece(Queen(), pawn.color)
      val newRook = Piece(Rook(), pawn.color)
      val newBishop = Piece(Bishop(), pawn.color)
      val newKnight = Piece(Knight(), pawn.color)
      theSet += new Position(newBoardWithout.add(newQueen, aheadSquare), Black, false)
      theSet += new Position(newBoardWithout.add(newRook, aheadSquare), Black, false)
      theSet += new Position(newBoardWithout.add(newBishop, aheadSquare), Black, false)
      theSet += new Position(newBoardWithout.add(newKnight, aheadSquare), Black, false)
    } else if ((square.row == 2) && position.board.isVacant(twoAheadSquare)) {
      theSet += new Position(newBoardWithout.add(pawn, twoAheadSquare), Black, false)//TODO: enPassant
    } //TODO take
    theSet.toSet
  }

  def knightCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def bishopCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def rookCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def queenCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???

  def kingCanGoTo(position: Position, tuple: (Piece, Square)): Set[Position] = ???


}
