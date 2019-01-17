class Tower{
  private Disc[] tower;
  int numDiscs;
  Disc emptyDisc = new Disc(0);

  public Tower(int initialSize){
    tower = new Disc[initialSize];
    numDiscs = 0;
  }

  public void add(Disc d){
    if (numDiscs > 0 && d.size() > tower[0].size()) throw new RuntimeException("Trying to move larger disc above a smaller disc");

    for(int i = numDiscs; i > 0; i--){
      tower[i] = tower[i-1];
    }

    tower[0] = d;
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

  public int maxCapacity(){
    return tower.length;
  }

  public int size(){
    return numDiscs;
  }

  public Disc getDisc(int slotNumber){
    int index = slotNumber + numDiscs - tower.length;

    if(index < 0) return emptyDisc;
    else return tower[index];
  }
}
