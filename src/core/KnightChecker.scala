package core

class KnightChecker extends AbstractMoveChecker {

  def squareSet(square: Square) =  {
    val twoUpOneLeft = Square((square.file.toInt - 1).toChar, (square.row + 2).toShort)
    val twoUpOneRight = Square((square.file.toInt + 1).toChar, (square.row + 2).toShort)
    val twoDownOneLeft = Square((square.file.toInt - 1).toChar, (square.row - 2).toShort)
    val twoDownOneRight = Square((square.file.toInt + 1).toChar, (square.row - 2).toShort)
    val oneUpTwoLeft = Square((square.file.toInt - 2).toChar, (square.row + 1).toShort)
    val oneUpTwoRight = Square((square.file.toInt + 2).toChar, (square.row + 1).toShort)
    val oneDownTwoLeft = Square((square.file.toInt - 2).toChar, (square.row - 1).toShort)
    val oneDownTwoRight = Square((square.file.toInt + 2).toChar, (square.row - 1).toShort)

    Set(twoUpOneLeft, twoUpOneRight, twoDownOneLeft, twoDownOneRight, oneUpTwoLeft,
      oneUpTwoRight, oneDownTwoLeft, oneDownTwoRight)
  }

  override def positionsReachable(position: Position, tuple: (Piece, Square)): Set[Position] = {
    val (knight, fromSquare) = tuple
    val newBoardWithout = position.board.without(fromSquare)

    val vacantSquares = squareSet(fromSquare).filter(s => s.inside).filter(newBoardWithout.isVacant)

    val takingSquares = squareSet(fromSquare).filter(s => s.inside).filter(s => newBoardWithout.hasThisColorPieceAtSquare(s, position.opponent))

    val vacantPositions = vacantSquares
      .map {
        toSquare => new Position(
          newBoardWithout
            .add(Piece(Knight(), knight.color), toSquare), position.opponent)
      }

    val takingPositions = takingSquares
      .map{
        toSquare => new Position(
          newBoardWithout
            .without(toSquare)
            .add(Piece(Knight(), knight.color), toSquare), position.opponent)
      }

    vacantPositions ++ takingPositions
  }

}

object KnightCheckerApp extends App {

  private val checker: MoveChecker = new MoveChecker()
  private val board = ChessBoardBuilder.newBoard()
  private val position = new Position(board, White)
  val whiteKnights = position.board.occupants.filter(p => p._1.color == position.inTheMove && p._1.pieceType == Knight())
  private val knightOpenings = whiteKnights.flatMap(checker.possiblePositions(position, _))
  knightOpenings.map(_.board).foreach(ChessBoardPrinter.printz)

}
