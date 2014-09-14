package engine

import core.{Black, White, ChessBoard}

class Evaluation {

  private def whitePieceValue(board: ChessBoard) =
    board.occupants.filter(p => p._1.color == White)
      .foldLeft(0f)((a,c) => a + c._1.pieceType.value)

  private def blackPieceValue(board: ChessBoard) =
    board.occupants.filter(p => p._1.color == Black)
    .foldLeft(0f)((a,c) => a + c._1.pieceType.value)

  def of(board: ChessBoard) : Float = {
    whitePieceValue(board) - blackPieceValue(board)
  }

}
