package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestMain {

  @Test
  public void testValidInputExampleOne() {
    Main input1 = new Main();
    char ValidTest = '1';
    boolean isValid = input1.check(ValidTest);
    assertTrue(isValid);
  }
}
