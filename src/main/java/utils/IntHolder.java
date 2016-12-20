package utils;

/**
 * Mutable reference to an integer
 */
public class IntHolder {
  int i;

  public IntHolder (int i) {
    this.i = i;
  }

  public void increment () {
    i++;
  }

  public int getI () {
    return i;
  }

}
