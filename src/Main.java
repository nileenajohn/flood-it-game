public class Main {
  public static void main(String[] args) {
    int dimensions = 10;
    int colors = 8;
    FloodItWorld starterWorld = new FloodItWorld(dimensions, colors);
    int sceneSize = 600;
    starterWorld.bigBang(sceneSize, sceneSize);
  }
}
