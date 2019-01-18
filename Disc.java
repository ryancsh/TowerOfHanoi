class Disc{
  private int size;
  private String stringRepresentation;
  
  public Disc(int size){
    this.size = size;

    StringBuilder s = new StringBuilder();
    for(int i = 0; i < size; i++){
      s.append('*');
    }
    s.append(' ');
    stringRepresentation = s.toString();
  }

  public int size(){
    return size;
  }

  public String toString(){
    return stringRepresentation;
  }
}
