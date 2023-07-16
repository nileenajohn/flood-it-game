import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import tester.Tester;
import java.awt.Color;

// Example class and testing class
class ExamplesFloodIt {
  // examples of cells
  Cell cell1;
  Cell cell2;
  Cell cell3;
  Cell cell4;
  Cell cell5;
  Cell cell6;
  Cell cell7;
  Cell cell8;

  // examples of flood it worlds
  FloodItWorld testWorld1;
  FloodItWorld testWorld2;
  FloodItWorld testWorld3;
  FloodItWorld testWorld2NotEnd;
  FloodItWorld testWorld3NotEnd;
  FloodItWorld testWorld4;
  FloodItWorld testWorld5;

  // list of the possible colors used in the game
  ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.red, Color.orange,
      Color.yellow, Color.green, Color.blue, Color.pink, Color.gray, Color.magenta));
  // list of all but the first color used in the game
  ArrayList<Color> not1colors = new ArrayList<Color>(Arrays.asList(Color.orange, Color.yellow,
      Color.green, Color.blue, Color.pink, Color.gray, Color.magenta));
  // list of all but the first three colors used in the game
  ArrayList<Color> not3colors = new ArrayList<Color>(
      Arrays.asList(Color.green, Color.blue, Color.pink, Color.gray, Color.magenta));
  // list of all but the first six colors used in the game
  ArrayList<Color> not6colors = new ArrayList<Color>(Arrays.asList(Color.gray, Color.magenta));
  // list of all but the first two colors used in the game
  ArrayList<Color> not2colors = new ArrayList<Color>(
      Arrays.asList(Color.yellow, Color.green, Color.blue, Color.pink, Color.gray, Color.magenta));

  // initialize cells
  void initCell() {
    this.cell1 = new Cell(10, 10, Color.RED);
    this.cell2 = new Cell(10, 10, Color.ORANGE);
    this.cell3 = new Cell(10, 10, Color.YELLOW);
    this.cell4 = new Cell(10, 10, Color.GREEN);
    this.cell5 = new Cell(10, 10, Color.BLUE);
    this.cell6 = new Cell(10, 10, Color.PINK);
    this.cell7 = new Cell(10, 10, Color.GRAY);
    this.cell8 = new Cell(10, 10, Color.MAGENTA);
  }

  // initialize worlds
  void initWorld() {
    this.testWorld1 = new FloodItWorld(5, 1, new Random(1), 7);
    this.testWorld2 = new FloodItWorld(2, 3, new Random(2), 4);
    this.testWorld3 = new FloodItWorld(3, 6, new Random(3), 12);
    this.testWorld2NotEnd = new FloodItWorld(2, 3, new Random(2), 3);
    this.testWorld3NotEnd = new FloodItWorld(3, 6, new Random(3), 1);
    this.testWorld4 = new FloodItWorld(5, 2, new Random(4), 4);
    this.testWorld5 = new FloodItWorld(10, 8, new Random(5), 21);
  }

  // test for the method flood
  void testFlood(Tester t) {
    initCell();
    t.checkExpect(this.cell1.flooded, false);
    this.cell1.flood();
    t.checkExpect(this.cell1.flooded, true);

    t.checkExpect(this.cell2.flooded, false);
    this.cell2.flood();
    t.checkExpect(this.cell2.flooded, true);

    t.checkExpect(this.cell3.flooded, false);
    this.cell3.flood();
    t.checkExpect(this.cell3.flooded, true);

    t.checkExpect(this.cell4.flooded, false);
    this.cell4.flood();
    t.checkExpect(this.cell4.flooded, true);

    t.checkExpect(this.cell5.flooded, false);
    this.cell5.flood();
    t.checkExpect(this.cell5.flooded, true);

    t.checkExpect(this.cell6.flooded, false);
    this.cell6.flood();
    t.checkExpect(this.cell6.flooded, true);

    t.checkExpect(this.cell7.flooded, false);
    this.cell7.flood();
    t.checkExpect(this.cell7.flooded, true);

    t.checkExpect(this.cell8.flooded, false);
    this.cell8.flood();
    t.checkExpect(this.cell8.flooded, true);
  }

  // test for the method checkColor
  void testCheckColor(Tester t) {
    initCell();
    t.checkExpect(this.cell1.checkColor(this.cell1.color), true);
    t.checkExpect(this.cell2.checkColor(this.cell2.color), true);
    t.checkExpect(this.cell3.checkColor(this.cell3.color), true);
    t.checkExpect(this.cell4.checkColor(this.cell4.color), true);
    t.checkExpect(this.cell5.checkColor(this.cell5.color), true);
    t.checkExpect(this.cell6.checkColor(this.cell6.color), true);
    t.checkExpect(this.cell7.checkColor(this.cell7.color), true);
    t.checkExpect(this.cell8.checkColor(this.cell8.color), true);

    t.checkExpect(this.cell1.checkColor(Color.red), true);
    t.checkExpect(this.cell2.checkColor(Color.orange), true);
    t.checkExpect(this.cell3.checkColor(Color.yellow), true);
    t.checkExpect(this.cell4.checkColor(Color.green), true);
    t.checkExpect(this.cell5.checkColor(Color.blue), true);
    t.checkExpect(this.cell6.checkColor(Color.pink), true);
    t.checkExpect(this.cell7.checkColor(Color.gray), true);
    t.checkExpect(this.cell8.checkColor(Color.magenta), true);

    t.checkExpect(this.cell1.checkColor(Color.magenta), false);
    t.checkExpect(this.cell2.checkColor(Color.blue), false);
    t.checkExpect(this.cell3.checkColor(Color.pink), false);
    t.checkExpect(this.cell4.checkColor(Color.red), false);
    t.checkExpect(this.cell5.checkColor(Color.green), false);
    t.checkExpect(this.cell6.checkColor(Color.gray), false);
    t.checkExpect(this.cell7.checkColor(Color.blue), false);
    t.checkExpect(this.cell8.checkColor(Color.yellow), false);

    // mutate the colors of the cell
    cell1.color = Color.magenta;
    cell2.color = Color.blue;
    cell3.color = Color.pink;
    cell4.color = Color.red;
    cell5.color = Color.green;
    cell6.color = Color.gray;
    cell7.color = Color.blue;
    cell8.color = Color.yellow;

    t.checkExpect(this.cell1.checkColor(Color.magenta), true);
    t.checkExpect(this.cell2.checkColor(Color.blue), true);
    t.checkExpect(this.cell3.checkColor(Color.pink), true);
    t.checkExpect(this.cell4.checkColor(Color.red), true);
    t.checkExpect(this.cell5.checkColor(Color.green), true);
    t.checkExpect(this.cell6.checkColor(Color.gray), true);
    t.checkExpect(this.cell7.checkColor(Color.blue), true);
    t.checkExpect(this.cell8.checkColor(Color.yellow), true);
  }

  // runs the game by creating a world of size 5x5 and 1 color and calling bigBang
  boolean testFloodIt1(Tester t) {
    FloodItWorld starterWorld = new FloodItWorld(5, 1);
    int sceneSize = 350;
    starterWorld.bigBang(sceneSize, sceneSize, 1);
    return true;
  }

  // runs the game by creating a world of size 2x2 and 3 colors and calling
  // bigBang
  boolean testFloodIt2(Tester t) {
    FloodItWorld starterWorld = new FloodItWorld(2, 3);
    int sceneSize = 200;
    starterWorld.bigBang(sceneSize, sceneSize, 1);
    return true;
  }

  // runs the game by creating a world of size 3x3 and 6 colors and calling
  // bigBang
  boolean testFloodIt3(Tester t) {
    FloodItWorld starterWorld = new FloodItWorld(3, 6);
    int sceneSize = 200;
    starterWorld.bigBang(sceneSize, sceneSize, 1);
    return true;
  }

  // runs the game by creating a world of size 5x5 and 2 colors and calling
  // bigBang
  boolean testFloodIt4(Tester t) {
    FloodItWorld starterWorld = new FloodItWorld(5, 2);
    int sceneSize = 350;
    starterWorld.bigBang(sceneSize, sceneSize);
    return true;
  }

  // runs the game by creating a world of size 10x10 and 6 colors and calling
  // bigBang
  boolean testFloodIt5(Tester t) {
    FloodItWorld starterWorld = new FloodItWorld(10, 8);
    int sceneSize = 600;
    starterWorld.bigBang(sceneSize, sceneSize);
    return true;
  }
/*
  // test for exceptions
  void testExceptions(Tester t) {
    t.checkConstructorException(new IllegalArgumentException("You can't have more than 8 colors!"),
        "FloodItWorld", 10, 9);
    t.checkConstructorException(new IllegalArgumentException("You can't have more than 8 colors!"),
        "FloodItWorld", 1, 9);
    t.checkConstructorException(new IllegalArgumentException("You can't have more than 8 colors!"),
        "FloodItWorld", 20, 10);
    t.checkConstructorException(new IllegalArgumentException("You can't have more than 8 colors!"),
        "FloodItWorld", 5, 12);
  }

  // test for the method makeBoard
  void testMakeBoard(Tester t) {
    initWorld();
    // empties the board created by constructor
    testWorld1.board = new ArrayList<Cell>();
    testWorld1.makeBoard(5, 1);
    t.checkExpect(testWorld1.board.size(), 25);
    for (Cell c : testWorld1.board) {
      // checks that the colors of the cells are provided in the list of colors
      t.checkExpect(this.colors.contains(c.color), true);
      // checks that no cells are the same color as the colors outside the range of
      // colors specified
      t.checkExpect(this.not1colors.contains(c.color), false);
    }
    // empties the board created by constructor
    testWorld2.board = new ArrayList<Cell>();
    testWorld2.makeBoard(2, 3);
    t.checkExpect(testWorld2.board.size(), 4);
    for (Cell c : testWorld2.board) {
      t.checkExpect(this.colors.contains(c.color), true);
      t.checkExpect(this.not3colors.contains(c.color), false);
    }
    // empties the board created by constructor
    testWorld3.board = new ArrayList<Cell>();
    testWorld3.makeBoard(3, 6);
    t.checkExpect(testWorld3.board.size(), 9);
    for (Cell c : testWorld3.board) {
      t.checkExpect(this.colors.contains(c.color), true);
      t.checkExpect(this.not6colors.contains(c.color), false);
    }
    // empties the board created by constructor
    testWorld4.board = new ArrayList<Cell>();
    testWorld4.makeBoard(5, 2);
    t.checkExpect(testWorld4.board.size(), 25);
    for (Cell c : testWorld4.board) {
      t.checkExpect(this.colors.contains(c.color), true);
      t.checkExpect(this.not2colors.contains(c.color), false);
    }
    // empties the board created by constructor
    testWorld5.board = new ArrayList<Cell>();
    testWorld5.makeBoard(10, 8);
    t.checkExpect(testWorld5.board.size(), 100);
    for (Cell c : testWorld5.board) {
      t.checkExpect(this.colors.contains(c.color), true);
    }

  }

  // test for the method linkCells
  void testLinkCells(Tester t) {
    initWorld();
    testWorld1.linkCells();
    Cell world1c1 = this.testWorld1.board.get(0);
    Cell world1c2 = this.testWorld1.board.get(1);
    Cell world1c3 = this.testWorld1.board.get(2);
    Cell world1c4 = this.testWorld1.board.get(3);
    Cell world1c5 = this.testWorld1.board.get(4);
    Cell world1c6 = this.testWorld1.board.get(5);
    Cell world1c7 = this.testWorld1.board.get(6);
    Cell world1c8 = this.testWorld1.board.get(7);
    Cell world1c9 = this.testWorld1.board.get(8);
    Cell world1c10 = this.testWorld1.board.get(9);
    Cell world1c11 = this.testWorld1.board.get(10);
    Cell world1c12 = this.testWorld1.board.get(11);
    Cell world1c13 = this.testWorld1.board.get(12);
    Cell world1c14 = this.testWorld1.board.get(13);
    Cell world1c15 = this.testWorld1.board.get(14);
    Cell world1c16 = this.testWorld1.board.get(15);
    Cell world1c17 = this.testWorld1.board.get(16);
    Cell world1c18 = this.testWorld1.board.get(17);
    Cell world1c19 = this.testWorld1.board.get(18);
    Cell world1c20 = this.testWorld1.board.get(19);
    Cell world1c21 = this.testWorld1.board.get(20);
    Cell world1c22 = this.testWorld1.board.get(21);
    Cell world1c23 = this.testWorld1.board.get(22);
    Cell world1c24 = this.testWorld1.board.get(23);
    Cell world1c25 = this.testWorld1.board.get(24);
    t.checkExpect(world1c1.left, null);
    t.checkExpect(world1c1.top, null);
    t.checkExpect(world1c1.right, world1c2);
    t.checkExpect(world1c1.bottom, world1c6);

    t.checkExpect(world1c2.left, world1c1);
    t.checkExpect(world1c2.top, null);
    t.checkExpect(world1c2.right, world1c3);
    t.checkExpect(world1c2.bottom, world1c7);

    t.checkExpect(world1c3.left, world1c2);
    t.checkExpect(world1c3.top, null);
    t.checkExpect(world1c3.right, world1c4);
    t.checkExpect(world1c3.bottom, world1c8);

    t.checkExpect(world1c4.left, world1c3);
    t.checkExpect(world1c4.top, null);
    t.checkExpect(world1c4.right, world1c5);
    t.checkExpect(world1c4.bottom, world1c9);

    t.checkExpect(world1c5.left, world1c4);
    t.checkExpect(world1c5.top, null);
    t.checkExpect(world1c5.right, null);
    t.checkExpect(world1c5.bottom, world1c10);

    t.checkExpect(world1c6.left, null);
    t.checkExpect(world1c6.top, world1c1);
    t.checkExpect(world1c6.right, world1c7);
    t.checkExpect(world1c6.bottom, world1c11);

    t.checkExpect(world1c7.left, world1c6);
    t.checkExpect(world1c7.top, world1c2);
    t.checkExpect(world1c7.right, world1c8);
    t.checkExpect(world1c7.bottom, world1c12);

    t.checkExpect(world1c8.left, world1c7);
    t.checkExpect(world1c8.top, world1c3);
    t.checkExpect(world1c8.right, world1c9);
    t.checkExpect(world1c8.bottom, world1c13);

    t.checkExpect(world1c9.left, world1c8);
    t.checkExpect(world1c9.top, world1c4);
    t.checkExpect(world1c9.right, world1c10);
    t.checkExpect(world1c9.bottom, world1c14);

    t.checkExpect(world1c10.left, world1c9);
    t.checkExpect(world1c10.top, world1c5);
    t.checkExpect(world1c10.right, null);
    t.checkExpect(world1c10.bottom, world1c15);

    t.checkExpect(world1c11.left, null);
    t.checkExpect(world1c11.top, world1c6);
    t.checkExpect(world1c11.right, world1c12);
    t.checkExpect(world1c11.bottom, world1c16);

    t.checkExpect(world1c12.left, world1c11);
    t.checkExpect(world1c12.top, world1c7);
    t.checkExpect(world1c12.right, world1c13);
    t.checkExpect(world1c12.bottom, world1c17);

    t.checkExpect(world1c13.left, world1c12);
    t.checkExpect(world1c13.top, world1c8);
    t.checkExpect(world1c13.right, world1c14);
    t.checkExpect(world1c13.bottom, world1c18);

    t.checkExpect(world1c14.left, world1c13);
    t.checkExpect(world1c14.top, world1c9);
    t.checkExpect(world1c14.right, world1c15);
    t.checkExpect(world1c14.bottom, world1c19);

    t.checkExpect(world1c15.left, world1c14);
    t.checkExpect(world1c15.top, world1c10);
    t.checkExpect(world1c15.right, null);
    t.checkExpect(world1c15.bottom, world1c20);

    t.checkExpect(world1c16.left, null);
    t.checkExpect(world1c16.top, world1c11);
    t.checkExpect(world1c16.right, world1c17);
    t.checkExpect(world1c16.bottom, world1c21);

    t.checkExpect(world1c17.left, world1c16);
    t.checkExpect(world1c17.top, world1c12);
    t.checkExpect(world1c17.right, world1c18);
    t.checkExpect(world1c17.bottom, world1c22);

    t.checkExpect(world1c18.left, world1c17);
    t.checkExpect(world1c18.top, world1c13);
    t.checkExpect(world1c18.right, world1c19);
    t.checkExpect(world1c18.bottom, world1c23);

    t.checkExpect(world1c19.left, world1c18);
    t.checkExpect(world1c19.top, world1c14);
    t.checkExpect(world1c19.right, world1c20);
    t.checkExpect(world1c19.bottom, world1c24);

    t.checkExpect(world1c20.left, world1c19);
    t.checkExpect(world1c20.top, world1c15);
    t.checkExpect(world1c20.right, null);
    t.checkExpect(world1c20.bottom, world1c25);

    t.checkExpect(world1c21.left, null);
    t.checkExpect(world1c21.top, world1c16);
    t.checkExpect(world1c21.right, world1c22);
    t.checkExpect(world1c21.bottom, null);

    t.checkExpect(world1c22.left, world1c21);
    t.checkExpect(world1c22.top, world1c17);
    t.checkExpect(world1c22.right, world1c23);
    t.checkExpect(world1c22.bottom, null);

    t.checkExpect(world1c23.left, world1c22);
    t.checkExpect(world1c23.top, world1c18);
    t.checkExpect(world1c23.right, world1c24);
    t.checkExpect(world1c23.bottom, null);

    t.checkExpect(world1c24.left, world1c23);
    t.checkExpect(world1c24.top, world1c19);
    t.checkExpect(world1c24.right, world1c25);
    t.checkExpect(world1c24.bottom, null);

    t.checkExpect(world1c25.left, world1c24);
    t.checkExpect(world1c25.top, world1c20);
    t.checkExpect(world1c25.right, null);
    t.checkExpect(world1c25.bottom, null);

    testWorld3.linkCells();
    Cell world3c1 = this.testWorld3.board.get(0);
    Cell world3c2 = this.testWorld3.board.get(1);
    Cell world3c3 = this.testWorld3.board.get(2);
    Cell world3c4 = this.testWorld3.board.get(3);
    Cell world3c5 = this.testWorld3.board.get(4);
    Cell world3c6 = this.testWorld3.board.get(5);
    Cell world3c7 = this.testWorld3.board.get(6);
    Cell world3c8 = this.testWorld3.board.get(7);
    Cell world3c9 = this.testWorld3.board.get(8);

    t.checkExpect(world3c1.left, null);
    t.checkExpect(world3c1.top, null);
    t.checkExpect(world3c1.right, world3c2);
    t.checkExpect(world3c1.bottom, world3c4);

    t.checkExpect(world3c2.left, world3c1);
    t.checkExpect(world3c2.top, null);
    t.checkExpect(world3c2.right, world3c3);
    t.checkExpect(world3c2.bottom, world3c5);

    t.checkExpect(world3c3.left, world3c2);
    t.checkExpect(world3c3.top, null);
    t.checkExpect(world3c3.right, null);
    t.checkExpect(world3c3.bottom, world3c6);

    t.checkExpect(world3c4.left, null);
    t.checkExpect(world3c4.top, world3c1);
    t.checkExpect(world3c4.right, world3c5);
    t.checkExpect(world3c4.bottom, world3c7);

    t.checkExpect(world3c5.left, world3c4);
    t.checkExpect(world3c5.top, world3c2);
    t.checkExpect(world3c5.right, world3c6);
    t.checkExpect(world3c5.bottom, world3c8);

    t.checkExpect(world3c6.left, world3c5);
    t.checkExpect(world3c6.top, world3c3);
    t.checkExpect(world3c6.right, null);
    t.checkExpect(world3c6.bottom, world3c9);

    t.checkExpect(world3c7.left, null);
    t.checkExpect(world3c7.top, world3c4);
    t.checkExpect(world3c7.right, world3c8);
    t.checkExpect(world3c7.bottom, null);

    t.checkExpect(world3c8.left, world3c7);
    t.checkExpect(world3c8.top, world3c5);
    t.checkExpect(world3c8.right, world3c9);
    t.checkExpect(world3c8.bottom, null);

    t.checkExpect(world3c9.left, world3c8);
    t.checkExpect(world3c9.top, world3c6);
    t.checkExpect(world3c9.right, null);
    t.checkExpect(world3c9.bottom, null);

    testWorld2.linkCells();
    Cell c1 = this.testWorld2.board.get(0);
    Cell c2 = this.testWorld2.board.get(1);
    Cell c3 = this.testWorld2.board.get(2);
    Cell c4 = this.testWorld2.board.get(3);
    t.checkExpect(c1.left, null);
    t.checkExpect(c1.top, null);
    t.checkExpect(c1.right, c2);
    t.checkExpect(c1.bottom, c3);
    t.checkExpect(c2.left, c1);
    t.checkExpect(c2.top, null);
    t.checkExpect(c2.right, null);
    t.checkExpect(c2.bottom, c4);
    t.checkExpect(c3.left, null);
    t.checkExpect(c3.top, c1);
    t.checkExpect(c3.right, c4);
    t.checkExpect(c3.bottom, null);
    t.checkExpect(c4.left, c3);
    t.checkExpect(c4.top, c2);
    t.checkExpect(c4.right, null);
    t.checkExpect(c4.bottom, null);
  }

  // test for the method randomColor
  void testRandomColor(Tester t) {
    initWorld();
    t.checkExpect(this.testWorld1.randomColor(1), Color.RED);
    t.checkExpect(this.testWorld2.randomColor(2), Color.RED);
    t.checkExpect(this.testWorld3.randomColor(3), Color.ORANGE);
    t.checkExpect(this.testWorld4.randomColor(6), Color.GREEN);
    t.checkExpect(this.testWorld5.randomColor(5), Color.RED);
    t.checkExpect(this.testWorld1.randomColor(4), Color.YELLOW);
    t.checkExpect(this.testWorld2.randomColor(7), Color.ORANGE);
    t.checkExpect(this.testWorld3.randomColor(8), Color.PINK);
  }

  // test for the method checkWin
  void testCheckWin(Tester t) {
    initWorld();
    t.checkExpect(this.testWorld1.checkWin(), false);
    // flood each cell in the world
    for (Cell c : testWorld1.board) {
      c.flood();
    }
    t.checkExpect(this.testWorld1.checkWin(), true);

    t.checkExpect(this.testWorld2.checkWin(), false);
    // flood each cell in the world
    for (Cell c : testWorld2.board) {
      c.flood();
    }
    t.checkExpect(this.testWorld2.checkWin(), true);

    t.checkExpect(this.testWorld3.checkWin(), false);
    // flood each cell in the world
    for (Cell c : testWorld3.board) {
      c.flood();
    }
    t.checkExpect(this.testWorld3.checkWin(), true);

    t.checkExpect(this.testWorld4.checkWin(), false);
    // flood each cell in the world
    for (Cell c : testWorld4.board) {
      c.flood();
    }
    t.checkExpect(this.testWorld4.checkWin(), true);

    t.checkExpect(this.testWorld5.checkWin(), false);
    // flood each cell in the world
    for (Cell c : testWorld5.board) {
      c.flood();
    }
    t.checkExpect(this.testWorld5.checkWin(), true);
  }

  // test for the method checkLose
  void testCheckLose(Tester t) {
    initWorld();
    t.checkExpect(this.testWorld1.checkLose(), false);
    t.checkExpect(this.testWorld2.checkLose(), true);
    t.checkExpect(this.testWorld3.checkLose(), true);
    t.checkExpect(this.testWorld4.checkLose(), false);
    t.checkExpect(this.testWorld5.checkLose(), true);
  }

  // test for the method makeScene
  void testMakeScene(Tester t) {
    initWorld();
    WorldScene drawWorld1 = new WorldScene(270, 270);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 35);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 35);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 35);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 35);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 35);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 85);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 85);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 85);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 85);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 85);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 135);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 135);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 135);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 135);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 135);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 185);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 185);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 185);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 185);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 185);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 235);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 235);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 235);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 235);
    drawWorld1.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 235);
    drawWorld1.placeImageXY(new TextImage("Moves: 7/10", 20, Color.BLACK), 125, 295);
    t.checkExpect(this.testWorld1.makeScene(), drawWorld1);

    WorldScene drawWorld2NotEnd = (new WorldScene(120, 120));
    drawWorld2NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 35,
        35);
    drawWorld2NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 35);
    drawWorld2NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.YELLOW), 35,
        85);
    drawWorld2NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 85,
        85);
    drawWorld2NotEnd.placeImageXY(new TextImage("Moves: 4/4", 8, Color.BLACK), 50, 130);
    t.checkExpect(this.testWorld2NotEnd.makeScene(), drawWorld2NotEnd);

    // test lose scene
    WorldScene drawWorld2 = (new WorldScene(120, 120));
    drawWorld2.placeImageXY(new TextImage("You lose!", 20, Color.RED), 50, 50);
    t.checkExpect(this.testWorld2.makeScene(), drawWorld2);

    WorldScene drawWorld3NotEnd = (new WorldScene(170, 170));
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.YELLOW), 35,
        35);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.YELLOW), 85,
        35);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135,
        35);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 35,
        85);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 85);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135,
        85);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.GREEN), 35,
        135);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.BLUE), 85,
        135);
    drawWorld3NotEnd.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 135,
        135);
    drawWorld3NotEnd.placeImageXY(new TextImage("Moves: 12/6", 8, Color.BLACK), 75, 185);
    t.checkExpect(this.testWorld3NotEnd.makeScene(), drawWorld3NotEnd);

    // test lose scene
    WorldScene drawWorld3 = (new WorldScene(170, 170));
    drawWorld3.placeImageXY(new TextImage("You lose!", 30, Color.RED), 75, 75);
    t.checkExpect(this.testWorld3.makeScene(), drawWorld3);

    WorldScene drawWorld4 = (new WorldScene(270, 270));
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 35, 35);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 85, 35);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 135, 35);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 185, 35);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 235, 35);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 85);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 85, 85);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 85);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 185, 85);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 85);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 135);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 85, 135);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 135, 135);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 185, 135);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 235, 135);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 35, 185);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 85, 185);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 135, 185);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 185, 185);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 235, 185);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 35, 235);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 85, 235);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.RED), 135, 235);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 185, 235);
    drawWorld4.placeImageXY(new RectangleImage(50, 50, OutlineMode.SOLID, Color.ORANGE), 235, 235);
    drawWorld4.placeImageXY(new TextImage("Moves: 4/10", 20, Color.BLACK), 125, 295);
    t.checkExpect(this.testWorld4.makeScene(), drawWorld4);

    // flood each cell in testWorld5 so it is considered a "win"
    for (Cell c : this.testWorld5.board) {
      c.flooded = true;
    }
    // test win scene
    WorldScene drawWorld5 = (new WorldScene(520, 520));
    drawWorld5.placeImageXY(new TextImage("You won in ", 80, Color.GREEN), 250, 250);
    drawWorld5.placeImageXY(new TextImage("21 moves!", 80, Color.GREEN), 250, 350);
    t.checkExpect(this.testWorld5.makeScene(), drawWorld5);
  }

  // test for the method onMouseClicked
  void testOnMouseClicked(Tester t) {
    initWorld();
    t.checkExpect(this.testWorld1.board.get(0).color, Color.RED);
    t.checkExpect(this.testWorld1.movesCount, 7);
    this.testWorld1.onMouseClicked(new Posn(136, 131));
    // moves count and colors stays the same because the color of the cell chosen
    // was the color of already flooded area
    t.checkExpect(this.testWorld1.movesCount, 7);
    t.checkExpect(this.testWorld1.board.get(0).color, Color.RED);
    for (Cell c : this.testWorld1.board) {
      t.checkExpect(c.flooded, true);
    }
    t.checkExpect(this.testWorld1.checkWin(), true);

    t.checkExpect(this.testWorld2.board.get(0).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.board.get(1).color, Color.RED);
    t.checkExpect(this.testWorld2.board.get(2).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(3).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.movesCount, 4);
    this.testWorld2.onMouseClicked(new Posn(85, 85));
    // moves count and colors stays the same because the color of the cell chosen
    // was the color of already flooded area
    t.checkExpect(this.testWorld2.movesCount, 4);
    for (Cell c : this.testWorld1.board) {
      t.checkExpect(c.flooded, true);
    }
    t.checkExpect(this.testWorld1.checkWin(), true);

    t.checkExpect(this.testWorld2.board.get(0).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.board.get(1).color, Color.RED);
    t.checkExpect(this.testWorld2.board.get(2).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(3).color, Color.ORANGE);

    this.testWorld2.onMouseClicked(new Posn(85, 40));
    t.checkExpect(this.testWorld2.movesCount, 5);
    t.checkExpect(this.testWorld2.board.get(0).color, Color.RED);
    t.checkExpect(this.testWorld2.board.get(1).color, Color.RED);
    t.checkExpect(this.testWorld2.board.get(2).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(3).color, Color.ORANGE);

    this.testWorld2.onMouseClicked(new Posn(55, 65));
    t.checkExpect(this.testWorld2.movesCount, 6);
    t.checkExpect(this.testWorld2.board.get(0).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(1).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(2).color, Color.YELLOW);
    t.checkExpect(this.testWorld2.board.get(3).color, Color.ORANGE);

    this.testWorld2.onMouseClicked(new Posn(100, 100));
    t.checkExpect(this.testWorld2.movesCount, 7);
    t.checkExpect(this.testWorld2.board.get(0).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.board.get(1).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.board.get(2).color, Color.ORANGE);
    t.checkExpect(this.testWorld2.board.get(3).color, Color.ORANGE);
    for (Cell c : this.testWorld2.board) {
      t.checkExpect(c.flooded, true);
    }
    t.checkExpect(this.testWorld2.checkWin(), true);

    t.checkExpect(this.testWorld3NotEnd.movesCount, 1);
    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    this.testWorld3NotEnd.onMouseClicked(new Posn(40, 80));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 2);
    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    this.testWorld3NotEnd.onMouseClicked(new Posn(80, 40));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 3);
    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.YELLOW);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    this.testWorld3NotEnd.onMouseClicked(new Posn(140, 40));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 4);

    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.RED);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    t.checkExpect(this.testWorld3NotEnd.board.get(0).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).flooded, true);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).flooded, false);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).flooded, false);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).flooded, false);

    this.testWorld3NotEnd.onMouseClicked(new Posn(80, 140));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 5);

    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.BLUE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    t.checkExpect(this.testWorld3NotEnd.checkLose(), false);

    this.testWorld3NotEnd.onMouseClicked(new Posn(40, 140));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 6);

    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.GREEN);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    t.checkExpect(this.testWorld3NotEnd.checkLose(), true);

    this.testWorld3NotEnd.onMouseClicked(new Posn(140, 140));
    t.checkExpect(this.testWorld3NotEnd.movesCount, 7);

    t.checkExpect(this.testWorld3NotEnd.board.get(0).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(1).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(2).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(3).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(4).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(5).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(6).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(7).color, Color.ORANGE);
    t.checkExpect(this.testWorld3NotEnd.board.get(8).color, Color.ORANGE);

    for (Cell c : this.testWorld3NotEnd.board) {
      t.checkExpect(c.flooded, true);
    }
  }

  // test for the method onKeyEvent;
  void testOnKeyEvent(Tester t) {
    initWorld();
    // checks that movesCount is how much convenience constructor originally set it
    // to be
    t.checkExpect(this.testWorld1.movesCount, 7);
    this.testWorld1.onKeyEvent("r");
    // checks that the board size stays the same
    t.checkExpect(testWorld1.board.size(), 25);
    // checks that movesCount has been reset to 0
    t.checkExpect(this.testWorld1.movesCount, 0);
    // checks that colorCount stays the same
    t.checkExpect(this.testWorld1.colorCount, 1);
    // checks that only first cell in the board is flooded
    t.checkExpect(this.testWorld1.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld1.board.size(); i++) {
      t.checkExpect(this.testWorld1.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld2.movesCount, 4);
    this.testWorld2.onKeyEvent("r");
    t.checkExpect(testWorld2.board.size(), 4);
    t.checkExpect(this.testWorld2.movesCount, 0);
    t.checkExpect(this.testWorld2.colorCount, 3);
    t.checkExpect(this.testWorld2.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld2.board.size(); i++) {
      t.checkExpect(this.testWorld2.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld3.movesCount, 12);
    this.testWorld3.onKeyEvent("r");
    t.checkExpect(testWorld3.board.size(), 9);
    t.checkExpect(this.testWorld3.movesCount, 0);
    t.checkExpect(this.testWorld3.colorCount, 6);
    t.checkExpect(this.testWorld3.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld3.board.size(); i++) {
      t.checkExpect(this.testWorld3.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld4.movesCount, 4);
    this.testWorld4.onKeyEvent("r");
    t.checkExpect(testWorld4.board.size(), 25);
    t.checkExpect(this.testWorld4.movesCount, 0);
    t.checkExpect(this.testWorld4.colorCount, 2);
    t.checkExpect(this.testWorld4.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld4.board.size(); i++) {
      t.checkExpect(this.testWorld4.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld5.movesCount, 21);
    this.testWorld5.onKeyEvent("r");
    t.checkExpect(testWorld5.board.size(), 100);
    t.checkExpect(this.testWorld5.movesCount, 0);
    t.checkExpect(this.testWorld5.colorCount, 8);
    t.checkExpect(this.testWorld5.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld5.board.size(); i++) {
      t.checkExpect(this.testWorld5.board.get(i).flooded, false);
    }
  }

  // test for the method resetGame
  void testResetGame(Tester t) {
    initWorld();
    // checks that movesCount is how much convenience constructor originally set it
    // to be
    t.checkExpect(this.testWorld1.movesCount, 7);
    this.testWorld1.resetGame();
    // checks that the board size stays the same
    t.checkExpect(testWorld1.board.size(), 25);
    // checks that movesCount has been reset to 0
    t.checkExpect(this.testWorld1.movesCount, 0);
    // checks that colorCount stays the same
    t.checkExpect(this.testWorld1.colorCount, 1);
    // checks that only first cell in the board is flooded
    t.checkExpect(this.testWorld1.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld1.board.size(); i++) {
      t.checkExpect(this.testWorld1.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld2.movesCount, 4);
    this.testWorld2.resetGame();
    t.checkExpect(testWorld2.board.size(), 4);
    t.checkExpect(this.testWorld2.movesCount, 0);
    t.checkExpect(this.testWorld2.colorCount, 3);
    t.checkExpect(this.testWorld2.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld2.board.size(); i++) {
      t.checkExpect(this.testWorld2.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld3.movesCount, 12);
    this.testWorld3.resetGame();
    t.checkExpect(testWorld3.board.size(), 9);
    t.checkExpect(this.testWorld3.movesCount, 0);
    t.checkExpect(this.testWorld3.colorCount, 6);
    t.checkExpect(this.testWorld3.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld3.board.size(); i++) {
      t.checkExpect(this.testWorld3.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld4.movesCount, 4);
    this.testWorld4.resetGame();
    t.checkExpect(testWorld4.board.size(), 25);
    t.checkExpect(this.testWorld4.movesCount, 0);
    t.checkExpect(this.testWorld4.colorCount, 2);
    t.checkExpect(this.testWorld4.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld4.board.size(); i++) {
      t.checkExpect(this.testWorld4.board.get(i).flooded, false);
    }
    t.checkExpect(this.testWorld5.movesCount, 21);
    this.testWorld5.resetGame();
    t.checkExpect(testWorld5.board.size(), 100);
    t.checkExpect(this.testWorld5.movesCount, 0);
    t.checkExpect(this.testWorld5.colorCount, 8);
    t.checkExpect(this.testWorld5.board.get(0).flooded, true);
    for (int i = 1; i < this.testWorld5.board.size(); i++) {
      t.checkExpect(this.testWorld5.board.get(i).flooded, false);
    }
  }*/
}