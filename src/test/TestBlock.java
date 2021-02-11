package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import project-group_Kailani_Robert_Zack.src.Block;
import org.junit.Test;

public class TestBlock {
  @Test
  public void testGenesisBlockVote() {
    Block genesisBlockVote = new Block(0, "", "", "");
    assertSame(Block(0, "", "", ""), genesisBlockVote);
  }

  @Test
  public void testVote1() {
    Block voteOne = new Block(1, "1", "One", "1");
    assertSame(Block(1, "1", "One", "1"), voteOne);
  }

  @Test
  public void testVote2() {
    Block voteTwo = new Block(2, "2", "Two", "2");
    assertSame(Block(2, "2", "Two", "2"), voteTwo);
  }

  @Test
  public void testVote3() {
    Block voteThree = new Block(3, "3", "Three", "3");
    assertSame(Block(3, "3", "Three", "3"), voteThree);
  }

  @Test
  public void testVote4() {
    Block voteFour = new Block(4, "4", "Four", "1");
    assertSame(Block(4, "4", "Four", "1"), voteFour);
  }

  @Test
  public void testVote5() {
    Block BlockVote5 = new Block(5, "5", "five", "1");
    assertSame(Block(5, "5", "five", "1"), BlockVote5);
  }

  @Test
  public void testVote6() {
    Block BlockVote6 = new Block(6, "6", "six", "1");
    assertSame(Block(6, "6", "six", "1"), BlockVote6);
  }

  @Test
  public void testVote5() {
    Block BlockVote7 = new Block(7, "7", "seven", "1");
    assertSame(Block(7, "7", "seven", "1"), BlockVote7);
  }

  @Test
  public void testVote8() {
    Block BlockVote8 = new Block(8, "8", "eight", "1");
    assertSame(Block(8, "8", "eight", "1"), BlockVote8);
  }

  @Test
  public void testVote9() {
    Block BlockVote9 = new Block(9, "9", "nine", "1");
    assertSame(Block(9, "9", "nine", "1"), BlockVote9);
  }
}
