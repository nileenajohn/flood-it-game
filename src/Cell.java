import java.awt.Color;

// Represents a single square of the game area
class Cell {
  // represents the position of the cell in the game board as x and y coordinates
  // Design Note: we chose to have fields to represent the position so it we could
  // easily access where in the board the cell is
  int x;
  int y;
  Color color;
  // whether cell is flooded or not
  boolean flooded;
  // the four adjacent cells to the cell we are making
  // Design Note: we chose to have fields for the adjacent cells because
  // it would make it easier to determine the linked cells and which cells to
  // consider when flooding
  Cell left;
  Cell top;
  Cell right;
  Cell bottom;

  // Constructor
  Cell(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.flooded = false;
  }

  // floods this cell
  // EFFECT: makes this cell flooded
  void flood() {
    this.flooded = true;
  }

  // checks if the color of this cell is the same as the given color
  boolean checkColor(Color c) {
    return this.color.equals(c);
  }
  
  // Changes the color of this cell
  // Effect: Changes the color value of this cell to the input string.
  void setColor(Color color) {
    this.color = color;
  }
  
  void update(Color color) {
    if (this.left != null
        && !this.left.flooded
        && this.left.color.equals(color)) {
      this.left.flooded = true;
    }
    if (this.top != null
        && !this.top.flooded 
        && this.top.color.equals(color)) {
      this.top.flooded = true;
    }
    if (this.right != null
        && !this.right.flooded
        && this.right.color.equals(color)) {
      this.right.flooded = true;
    }
    if (this.bottom != null
        && !this.bottom.flooded 
        && this.bottom.color.equals(color)) {
      this.bottom.flooded = true;
    }
  }
}