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
      theSet += new Position(newBoardWithout.add(pawn, aheadSquare), position.opponent)
    } else if (isPromotionRow(aheadSquare, pawn.color)) {
      theSet += new Position(newBoardWithout.add(Piece(Queen(), pawn.color), aheadSquare), position.opponent)
      theSet += new Position(newBoardWithout.add(Piece(Rook(), pawn.color), aheadSquare), position.opponent)
      theSet += new Position(newBoardWithout.add(Piece(Bishop(), pawn.color), aheadSquare), position.opponent)
      theSet += new Position(newBoardWithout.add(Piece(Knight(), pawn.color), aheadSquare), position.opponent)
    }
    if (isStartRow(square, pawn.color) && position.board.isVacant(twoAheadSquare)) {
      theSet += new Position(newBoardWithout.add(pawn, twoAheadSquare), position.opponent)
    }
    if (canTakeRight(square, position)._1) {
      theSet += new Position(newBoardWithout
        .without(canTakeRight(square, position)._2.get), position.opponent)
    }
    if (canTakeLeft(square, position)._1) {
      theSet += new Position(newBoardWithout
        .without(canTakeLeft(square, position)._2.get), position.opponent)
    }
    if (position.enPassantRow.nonEmpty) {
      //todo
    }
    theSet.toSet.filter(isLegal)
  }

  //todo - make sure you didnt expose a self-check or something..
  def isLegal(pos: Position): Boolean = true

  def canTakeRight(square: Square, pos: Position) : (Boolean, Option[Square]) = {
    val toSquare: Option[Square] = pawnAheadSquare(square, pos.inTheMove).right()
    if(toSquare.nonEmpty) {
      val pieceAt: Option[Piece] = pos.board.pieceAt(toSquare.get)
      if(pieceAt.nonEmpty && pieceAt.get.color != pos.inTheMove) {
        (true, toSquare)
      }
    }
    (false, None)
  }

  def canTakeLeft(square: Square, pos: Position) : (Boolean, Option[Square]) = {
    val toSquare: Option[Square] = pawnAheadSquare(square, pos.inTheMove).left()
    if(toSquare.nonEmpty) {
      val pieceAt: Option[Piece] = pos.board.pieceAt(toSquare.get)
      if(pieceAt.nonEmpty && pieceAt.get.color != pos.inTheMove) {
        (true, toSquare)
      }
    }
    (false, None)
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

object MoveChecker extends App {

  private val printer = ChessBoardPrinter
  private val checker: MoveChecker = new MoveChecker()
  private val board = ChessBoardBuilder.newBoard()
  private val position = new Position(board, White)
  val whitePawns = position.board.occupants.filter(p => p._1.color == position.inTheMove && p._1.pieceType == Pawn())
  private val pawnOpenings = whitePawns.flatMap(checker.possiblePositions(position, _))
  pawnOpenings.map(_.board).foreach(ChessBoardPrinter.printz)

}
