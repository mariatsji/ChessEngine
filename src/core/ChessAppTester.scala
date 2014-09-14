package core

import engine.Evaluation

object ChessAppTester {

  def main(args: Array[String]) {
    val board = ChessBoardBuilder.newBoard()
    val evaluation: Evaluation = new Evaluation()

    ChessBoardPrinter.printz(programmedMoves(board))
    print(
      evaluation.of(programmedMoves(board))
    )
  }

  def programmedMoves(board : ChessBoard) : ChessBoard = {
    board
      .without(Square('E',2))
      .add(Piece(new Pawn(), White), Square('E',4))

  }

}
