import java.util.concurrent.TimeUnit;

class Board{
  static final boolean DisplayEachIteration = true;
  static final int WaitTimeMillis = 50;


  static final int DefaultTowers = 3;   //do not use tower numbers other than 3, not implemented
  static final int DefaultDiscs = 7;

  private int numDiscs;
  private Tower[] towers;
  private int numMoves = 0;

  public Board(){
    this(DefaultDiscs, DefaultTowers);
  }

  public Board(int numDiscs, int numTowers){
    towers = new Tower[numTowers];
    this.numDiscs = numDiscs;

    for(int i = 0; i < towers.length; i++){
      towers[i] = new Tower(numDiscs);
    }

    for(int i = numDiscs; i > 0; i--){
      towers[0].add(new Disc(i));
    }
  }

  public String toString(){
    StringBuilder format = new StringBuilder();
    format.append('%');
    format.append(numDiscs + 5);
    format.append("s\t");
    String f = format.toString();

    StringBuilder s = new StringBuilder();
    s.append('\n');
    
    for(int j = 0; j < towers[0].maxCapacity(); j++){
      for(int i = 0; i < towers.length; i++){
        s.append(String.format(f, towers[i].getDisc(j), towers[i].getDisc(j).size()));
        s.append("\t");
      }
      s.append("\n");
    }
    if(s.charAt(s.length() - 1) == '\n') s.setLength(s.length() - 1);
    return s.toString();
  }

  public void move(int from, int to){
    towers[to].add(towers[from].remove());

    if(DisplayEachIteration){
      display();
      try{
        TimeUnit.MILLISECONDS.sleep(WaitTimeMillis);
      }
      catch (Exception e){
      }
    }

    numMoves++;
  }

  public void move(int from, int to, int num, int holding){
    if(num == 1){
      move(from, to);
    }
    else{
      move(from, holding, num - 1, to);
      move(from, to);
      move(holding, to, num - 1, from);
    }
  }

  public void display(){
    System.out.println(this);
  }

  public void solve(){
    if(DisplayEachIteration) display();
    move(0, 2, numDiscs, 1);
    System.out.printf("Total number of moves made: %5d\n", numMoves);
  }
}
