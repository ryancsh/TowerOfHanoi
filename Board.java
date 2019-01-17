import java.util.concurrent.TimeUnit;

class Board{
  static final int DefaultTowers = 3;
  static final int DefaultDiscs = 7;

  private int numDiscs;
  private Tower[] towers;

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
    StringBuilder s = new StringBuilder();
    s.append("\n");

    for(int j = 0; j < towers[0].maxCapacity(); j++){
      for(int i = 0; i < towers.length; i++){
        s.append(towers[i].getDisc(j));
        s.append("\t");
      }
      s.append("\n");
    }

    return s.toString();
  }

  public void move(int from, int to){
    towers[to].add(towers[from].remove());
    display();
    try{
      TimeUnit.MILLISECONDS.sleep(500);
    }
    catch (Exception e){
    }
  }

  public void move(int from, int to, int num, int holding){
    if(num == 1) move(from, to);
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
    display();
    move(0, 2, 7, 1);
  }
}
