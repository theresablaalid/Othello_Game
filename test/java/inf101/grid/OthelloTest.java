package inf101.grid;

import inf101.sem2.game.ConnectFour;
import inf101.sem2.game.Game;
import inf101.sem2.game.Othello;
import inf101.sem2.game.TicTacToe;
import inf101.sem2.player.ConsolePlayer;
import inf101.sem2.player.DumbPlayer;
import inf101.sem2.player.GuiPlayer;
import inf101.sem2.player.Player;
import inf101.sem2.terminal.TerminalGraphics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OthelloTest {


	@Test
	void canGoTest(){
		Player p1 = new ConsolePlayer('X', "P1");
		Player p2 = new ConsolePlayer('O',"P2");
		Game game = new Othello(new TerminalGraphics(), p1, p2);
		//game.run();
		//test if a player can't place on a illegal place according to the game rules
		assertFalse(game.canPlace(new Location(3, 5)));
		//test if a player can't place on a place with no neighbours
		assertFalse(game.canPlace(new Location(0, 0)));
		//test if a player can place on a valid location
		assertTrue(game.canPlace(new Location(2, 3)));
	}

	@Test
	void makeMoveTest() {
		Player p1 = new ConsolePlayer('X', "P1");
		Player p2 = new ConsolePlayer('O',"P2");
		Game game = new Othello(new TerminalGraphics(), p1, p2);

		//checks if player2 on a location changes to player1 when player1 has bricks at both sides of player2
		game.makeMove(new Location(3, 2));
		var board = game.getGameBoard();
		var neighborPlayerLoc = board.get(new Location(3, 3));
		assertEquals(neighborPlayerLoc, p1);
		//checks if player1 on a location changes to player2 when player2 has bricks at both sides of player1
		game.makeMove(new Location(4,2));
		var board2 = game.getGameBoard();
		var neighborPlayerLoc2 = board2.get(new Location(4,3));
		assertEquals(neighborPlayerLoc2, p2);
	}
/*
	@Test
	void outOfValidMovesTest() {
		Player p1 = new ConsolePlayer('X', "P1");
		Player p2 = new ConsolePlayer('O',"P2");
		Game game = new Othello(new TerminalGraphics(), p1, p2);
		var board = game.getGameBoard();

		//placing player 1 and player 2 on positions so that there are no more valid moves
		board.set(new Location(1, 7), p1);
		board.set(new Location(2, 7), p1);
		board.set(new Location(3, 7), p1);
		board.set(new Location(4, 7), p1);
		board.set(new Location(5, 7), p1);
		board.set(new Location(6, 7), p1);
		board.set(new Location(2, 6), p1);
		board.set(new Location(3, 6), p1);
		board.set(new Location(4, 6), p1);
		board.set(new Location(5, 6), p1);
		board.set(new Location(3, 5), p1);
		board.set(new Location(4, 5), p1);
		board.set(new Location(2, 5), p2);
		board.set(new Location(5, 5), p2);
		board.set(new Location(2, 4), p2);
		board.set(new Location(5, 4), p2);
		board.set(new Location(5, 3), p2);
		board.set(new Location(5, 2), p2);
		board.set(new Location(6,3), p2);
		board.set(new Location(7,3), p2);
		assertEquals(game.getCurrentPlayer(), p1);
		//It's player 2's turn
		game.makeMove(new Location(4,2));
		//Should now be player 2's turn again, since player 1 don't have any valid moves
		assertEquals(game.getCurrentPlayer(), p2);
	}
 */

	@Test
	public void gameOverAndIsWinnerTest() {
		Player p1 = new ConsolePlayer('X', "P1");
		Player p2 = new ConsolePlayer('O',"P2");
		Game game = new Othello(new TerminalGraphics(), p1, p2);

		game.makeMove(new Location(2,3));
		game.makeMove(new Location(2,4));
		game.makeMove(new Location(1,5));
		game.makeMove(new Location(3,2));
		game.makeMove(new Location(2,1));
		game.makeMove(new Location(1,4));
		game.makeMove(new Location(1,3));
		game.makeMove(new Location(0,4));
		game.makeMove(new Location(4,5));
		game.makeMove(new Location(5,4));
		game.makeMove(new Location(6,3));
		game.makeMove(new Location(4,2));
		game.makeMove(new Location(4,1));
		game.makeMove(new Location(5,3));
		game.makeMove(new Location(6,2));
		game.makeMove(new Location(7,3));
		game.makeMove(new Location(6,4));
		game.makeMove(new Location(4,0));
		game.makeMove(new Location(3,1));
		game.makeMove(new Location(1,0));
		game.makeMove(new Location(1,1));
		game.makeMove(new Location(0,1));
		game.makeMove(new Location(2,0));
		game.makeMove(new Location(3,0));
		game.makeMove(new Location(0,5));
		game.makeMove(new Location(7,4));
		game.makeMove(new Location(6,5));
		game.makeMove(new Location(0,3));
		game.makeMove(new Location(5,0));
		game.makeMove(new Location(0,6));
		game.makeMove(new Location(1,6));
		game.makeMove(new Location(6,0));
		game.makeMove(new Location(3,5));
		game.makeMove(new Location(5,2));
		game.makeMove(new Location(6,1));
		game.makeMove(new Location(4,6));
		game.makeMove(new Location(2,5));
		game.makeMove(new Location(0,7));
		game.makeMove(new Location(1,7));
		game.makeMove(new Location(7,0));
		game.makeMove(new Location(5,7));
		game.makeMove(new Location(2,7));
		game.makeMove(new Location(5,5));
		game.makeMove(new Location(3,7));
		game.makeMove(new Location(6,6));
		game.makeMove(new Location(7,5));
		game.makeMove(new Location(0,2));
		game.makeMove(new Location(7,7));
		game.makeMove(new Location(6,7));
		game.makeMove(new Location(4,7));
		game.makeMove(new Location(0,0));
		game.makeMove(new Location(7,2));
		game.makeMove(new Location(7,1));
		game.makeMove(new Location(7,6));
		game.makeMove(new Location(2,6));
		game.makeMove(new Location(5,6));
		game.makeMove(new Location(2,2));
		game.makeMove(new Location(1,2));
		game.makeMove(new Location(5,1));
		game.makeMove(new Location(3,6));


		//game should be over because all 64 cells are taken
		assertEquals(game.gameOver(), true);
		//from the youtube film (https://www.youtube.com/watch?v=sJgLi32jMo0) we knoe that p2 is the winner
		assertEquals(game.isWinner(p2), true);


	}
}
