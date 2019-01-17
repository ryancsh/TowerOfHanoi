class Disc{
  private int size;
  
  public Disc(int size){
    this.size = size;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if(size == 0) return " ";
    else return "" + size;
  }
}
