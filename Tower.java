class Tower{
  static final int DefaultSize = 5;
  Disc[] tower;
  int numDiscs;

  public Tower(){
    this(DefaultSize);
  }

  public Tower(int initialSize){
    tower = new Disc[initialSize];
    numDiscs = 0;
  }

  public void add(Disc d){
    tower[numDiscs] = d;
    numDiscs++;
  }

  public Disc remove(){
    Disc returnValue = tower[0];

    for(int i = 1; i < numDiscs; i++){
      tower[i-1] = tower[i];
    }
    numDiscs--;

    return returnValue;
  }
}
