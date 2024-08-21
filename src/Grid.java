import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  private static final int Margin = 10;
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(colToLabel(i), j, Margin+Cell.size*i, Margin+Cell.size*j);
      }
    }
  }

  private char colToLabel(int col) {
    return (char) (col + Character.valueOf('A'));
  }

  private int labelToCol(char col) {
    return (int) (col - Character.valueOf('A'));
  }

  public void paint(Graphics g, Point mousePos) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if (c<0 || c>=cells.length || r<0 || r>=cells[c].length){
      return Optional.empty();
    }
    return Optional.ofNullable(cells[c][r]);
  }

  public Optional<Cell> cellAtColRow(char c, int r){
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    if(p == null){
      return Optional.empty();
    }

    int col = (p.x - Margin)/Cell.size;
    int row = (p.y - Margin)/Cell.size;

    return cellAtPoint(col, row);
  }

  private Optional<Cell> cellAtPoint(int col, int row) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'cellAtPoint'");
  }


}
