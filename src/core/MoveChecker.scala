package core

import scala.collection.parallel.mutable

class MoveChecker {

  def canMoveTo(pos: Position, ps: (Piece,Square)) : Set[(Piece,Square)] = {
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

  def pawnCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = {
    //TODO continue here
    val (pawn, square) = tuple


  }

  def knightCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = ???

  def bishopCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = ???

  def rookCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = ???

  def queenCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = ???

  def kingCanGoTo(position: Position, tuple: (Piece, Square)): Set[(Piece, Square)] = ???


}
