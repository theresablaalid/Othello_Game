package inf101.sem2.game;

import inf101.grid.GridDirection;
import inf101.grid.Location;
import inf101.sem2.player.Player;

/**
 * Othello is a 2 player game where the game is played on a 8x8 grid,
 * where each player places a piece with a black side and a white side
 * on the game boar, and turning pieces of the opponent's suit,
 * depending on the placement of their own and the opponent's pieces.
 *
 * The goal is to get the most pieces of your own colour on the grid when
 * the game ends.
 */

public class Othello extends Game {

	/**
	 * Constructs a Othello game with 2 players where p1 starts the game
	 *
	 * @param graphics - The graphics used to display the game for the human players
	 * @param p1       - First player
	 * @param p2       - Second player
	 */

	public Othello(Graphics graphics, Player p1, Player p2) {
		this(graphics);
		players.add(p1);
		players.add(p2);
		board.set(new Location(3, 3), p2);
		board.set(new Location(4, 4), p2);
		board.set(new Location(3, 4), p1);
		board.set(new Location(4, 3), p1);
	}

	public Othello(Graphics graphics) {
		super(new GameBoard(8, 8), graphics);

	}

	public Othello(Graphics graphics, Iterable<Player> players) {
		super(new GameBoard(8, 8), graphics, players);
		int i = 0;
		for (Player p : players) {
			board.set(new Location(3, 4 - i), p);
			board.set(new Location(4, 3 + i), p);
			i++;
		}
	}

	@Override
	public Game copy() {
		Othello game = new Othello(graphics);
		copyTo(game);
		return game;
	}

	@Override
	public boolean isWinner(Player player) {
		int playerCounterFirstPlayer = 0;
		int playerCounterSecondPLayer = 0;
		for(Player p : players()) {
			if (p == player){
				playerCounterFirstPlayer = countsBricksForPlayer(p);
			}else{
				playerCounterSecondPLayer = countsBricksForPlayer(p);
			}
		}
		return playerCounterFirstPlayer > playerCounterSecondPLayer;
	}
	/**
	 * Counts how many bricks each player has
	 * @param - player
	 * @return - counter
	* */
	public int countsBricksForPlayer(Player player){
		int counter = 0;
		for (int row = 0; row < getGameBoard().numRows(); row++) {
			for (int col = 0; col < getGameBoard().numColumns(); col++) {
				var tempLoc = board.get(new Location(row, col));
				if (tempLoc == player) {
					counter++;
				}
			}
		}
		return counter;
	}



	@Override
	public boolean isLooser(Player player) {
		for(Player p : players()) {
			if(p != player && isWinner(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean gameOver() {
		if(getPossibleMoves().isEmpty()) {
				return true;
			}
		return false;
	}

	@Override
	public String getName() {
		return "Othello";
	}

	@Override
	public boolean canPlace(Location loc) {
		if(board.canPlace(loc)) {
			for(GridDirection dir: GridDirection.EIGHT_DIRECTIONS) {
				if(checkDirection(loc, dir)) {
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * The game has rules for where the players can place.
	 * This method checks if there are any valid moves in the given directions.
	 *
	 * @param loc - the location to the current player
	 * @param dir - the direction we want to check
	 * @return true if it is a valid move, false otherwise.
	 */
	public boolean checkDirection(Location loc, GridDirection dir) {
		var neighbor = loc.getNeighbor(dir);
		if (!board.isOnGrid(neighbor)) {
			return false;
		}
		var cell = board.get(neighbor);
		if(!(cell == getCurrentPlayer()) && cell != null) {
			Location temp = neighbor;
			while(board.canGo(temp,dir) && neighbor != null){
				var nextNeighbor = temp.getNeighbor(dir);
				if (board.get(nextNeighbor) == null) return false;
				if (board.get(nextNeighbor) == getCurrentPlayer()) {
					return true;
				}
				temp = nextNeighbor;

			}
			return false;
		}
		return false;
	}

	@Override
	public void makeMove(Location loc) {
		if (!canPlace(loc)) {
			throw new IllegalArgumentException("Can not make that move");
		}
		board.set(loc, getCurrentPlayer());
		for(GridDirection dir: GridDirection.EIGHT_DIRECTIONS) {
			if(checkDirection(loc, dir)) {
				Location temporaryNeighbor = loc.getNeighbor(dir);
				var temp2 = board.get(temporaryNeighbor);
				while(board.get(temporaryNeighbor) != getCurrentPlayer() && board.get(temporaryNeighbor) != null) {
					board.changeColor(temporaryNeighbor, getCurrentPlayer());
					temporaryNeighbor = temporaryNeighbor.getNeighbor(dir);
				}
			}
		}
		players.nextPlayer();
		if(getPossibleMoves().isEmpty()) {
			players.nextPlayer();
		}
	}



}
