import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javalib.impworld.World;
import javalib.impworld.WorldScene;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;

// Makes a flood it world
class FloodItWorld extends World {
  // All the cells of the game
  // Design Note: we chose to do an ArrayList instead of a 2D ArrayList
  // because we could then access the cell by finding its index in the list
  // rather than having to traverse 2 lists
  ArrayList<Cell> board;
  // The number of colors in the game
  int colorCount;
  // The number of moves left
  // Design Note: we chose to have a field tracking the moves count so that
  // we could constantly update the game based on the player's number of moves
  int movesCount;
  // The number of total moves
  // Design Note: we chose to have a field tracking the total moves so that
  // we could easily check whether the number of moves hit the max amount of moves
  int totalMoves;
  // a random number
  Random rand;

  // Constructs a new game world with the given board size and number of colors
  // constructor for playing
  FloodItWorld(int size, int colorCount) {
    this.rand = new Random();
    this.board = new ArrayList<Cell>();
    // Design Note: we chose to have a limit of 8 colors because we felt that 8 was reasonable
    // enough so that the player could play with a variety of colors, to their choosing
    // but also wouldn't be to many colors
    if (colorCount > 8) {
      throw new IllegalArgumentException("You can't have more than 8 colors!");
    }
    else {
      this.colorCount = colorCount;
    }
    // makes the board with the specified size and number of colors 
    this.makeBoard(size, colorCount);
    this.linkCells();
    // floods only the first cell in the board
    this.board.get(0).flood();
    this.movesCount = 0;
    this.totalMoves = size * 2;
  }

  // constructor for testing
  FloodItWorld(int size, int colorCount, Random rand, int movesCount) {
    this.rand = rand;
    this.board = new ArrayList<Cell>();
    if (colorCount > 8) {
      throw new IllegalArgumentException("You can't have more than 8 colors!");
    }
    else {
      this.colorCount = colorCount;
    }
    this.makeBoard(size, colorCount);
    linkCells();
    // floods only the first cell in the board
    this.board.get(0).flood();
    this.movesCount = movesCount;
    this.totalMoves = size * 2;
  }

  // initializes the board
  // EFECT: based on the size of board, adds the correct number of cells, each
  // with a random color
  void makeBoard(int size, int colorCount) {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        Color color = this.randomColor(colorCount);
        Cell cell = new Cell(col, row, color);
        this.board.add(cell);
      }
    }
  }

  // Links the adjacent cells in the board
  // EFFECT: links each cell with the correct left, right, top, and bottom cell
  void linkCells() {
    int size = (int) Math.sqrt(this.board.size());
    // Design note: We chose to go through each cell and ensure that it was linked
    // to the correct top, bottom, left, and right cell to make sure each cell was linked
    for (int i = 0; i < this.board.size(); i++) {
      Cell cell = this.board.get(i);
      int col = cell.x;
      int row = cell.y;
      if (col > 0) {
        cell.left = this.board.get(i - 1);
      }
      if (row > 0) {
        cell.top = this.board.get(i - size);
      }
      if (col < size - 1) {
        cell.right = this.board.get(i + 1);
      }
      if (row < size - 1) {
        cell.bottom = this.board.get(i + size);
      }
    }
  }

  // produces a random color from the given number of colors
  Color randomColor(int colorCount) {
    // Design note: We chose to use an ArrayList holding the colors so that we could choose
    // from a max of 8 colors and also chose from just 1, 2, 3, 4, 5,.. etc of the same colors
    ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.RED, Color.ORANGE,
        Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.GRAY, Color.MAGENTA));

    int index = this.rand.nextInt(colorCount);
    return colors.get(index);
  }

  // Checks if the player has won the game
  boolean checkWin() {
    boolean endGame = true;
    for (Cell cell : this.board) {
      if (!cell.flooded) {
        endGame = false;
      }
    }
    return endGame;
  }

  // Checks if the player has lost the game
  boolean checkLose() {
    return this.movesCount >= this.totalMoves;
  }

  // produces a world scene of the game and the correct ending scene based on
  // whether user wins or loses
  public WorldScene makeScene() {
    int cellSize = 50;
    int filling = 10;
    int size = (int) Math.sqrt(this.board.size());
    WorldScene scene = new WorldScene(cellSize * size + filling * 2, cellSize * size + filling * 2);

    for (Cell cell : this.board) {
      int x = cell.x * cellSize + filling;
      int y = cell.y * cellSize + filling;
      RectangleImage rect = new RectangleImage(cellSize, cellSize, OutlineMode.SOLID, cell.color);
      scene.placeImageXY(rect, x + cellSize / 2, y + cellSize / 2);
    }
    scene.placeImageXY(
        new TextImage("Moves: " + this.movesCount + "/" + this.totalMoves, size * 4, Color.BLACK),
        size * 25, size * 55 + 20);
    if (checkLose()) {
      scene = new WorldScene(cellSize * size + filling * 2, cellSize * size + filling * 2);
      scene.placeImageXY(new TextImage("You lose!", size * 10, Color.RED), size * 25, size * 25);
    }
    if (checkWin()) {
      scene = new WorldScene(cellSize * size + filling * 2, cellSize * size + filling * 2);
      scene.placeImageXY(new TextImage("You won in ", size * 8, Color.GREEN), size * 25, size * 25);
      scene.placeImageXY(new TextImage(this.movesCount + " moves!", size * 8, Color.GREEN),
          size * 25, size * 35);
    }
    return scene;
  }

  // Handles mouse events
  // EFFECT: updates the color of the flooded cells based on the color of the cell
  // clicked on
  public void onMouseClicked(Posn pos) {
    int cellSize = 50;
    int filling = 10;
    int x = (pos.x - filling) / cellSize;
    int y = (pos.y - filling) / cellSize;
    int size = (int) Math.sqrt(this.board.size());
    if (x >= 0 && x < size && y >= 0 && y < size) {
      Color color = this.board.get(y * (int) Math.sqrt(this.board.size()) + x).color;
      if (!this.board.get(0).color.equals(color)) {
        movesCount++;
      }
      for (Cell c : this.board) {
        if (c.flooded) {
          //c.color = color;
          if (c.left != null) {
            if (c.left.checkColor(color)) {
              c.left.flood();
            }
          }
          if (c.right != null) {
            if (c.right.checkColor(color)) {
              c.right.flood();
            }
          }
          if (c.top != null) {
            if (c.top.checkColor(color)) {
              c.top.flood();
            }
          }
          if (c.bottom != null) {
            if (c.bottom.checkColor(color)) {
              c.bottom.flood();
            }
          }
        }
      }
    }
  }

  // Handles key events
  // EFFECT: if r key is pressed, game is reset
  public void onKeyEvent(String key) {
    if (key.equals("r")) {
      resetGame();
    }
  }

  // resets the game
  // EFFECT: clears the board, remakes the board, relinks cells, sets movesCount
  // to 0 and floods the first cell
  void resetGame() {
    this.board.clear();
    this.makeBoard(this.totalMoves / 2, this.colorCount);
    linkCells();
    this.movesCount = 0;
    this.board.get(0).flood();
  }
  
  public void onTick() {
    updateWorld();
  }
  
  public void updateWorld() {
    Color newColor = this.board.get(0).color;
    for (int i = 0; i < board.size(); i++) {
      Cell cell = board.get(i);
      if (cell.flooded) {
        cell.color = newColor;
        cell.update(newColor);
      }
      makeScene();
    }
  }
}