class Board{
  static final int DefaultTowers = 3;

  private int numDiscs;
  private Tower[] towers;

  public Board(){
    this(DefaultTowers);
  }

  public Board(int numDiscs){
    this(numDiscs, DefaultTowers);
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

    for(int j = 0; j < towers[0].size(); j++){
      for(int i = 0; i < towers.length; i++){
        s.append(towers[i].getDisc(j));
        s.append("\t");
      }
      s.append("\n");
    }

    return s.toString();
  }

  public void solve(){
  }
}
