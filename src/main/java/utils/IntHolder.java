package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Mutable reference to an integer
 */
@AllArgsConstructor
public class IntHolder {
  @Getter int i;

  public void increment () {
    i++;
  }
}
