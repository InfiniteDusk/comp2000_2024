import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Actor a: actors) {
      a.paint(g);
    }
    //Easier
    Optional<Cell> mouseCell = grid.cellAtPoint(mouseLoc);
      if(mouseCell.isPresent()){
        g.drawString(mouseCell.get().info(), 800,64);
      }
    //Tricker
    //grid.cellAtPoint(mouseLoc).ifPresent(cell -> g.drawString(cell.info(), 800, 64))
  }
}
