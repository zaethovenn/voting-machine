package src.blockchain;

import java.io.Serializable;

public class Block implements Serializable {

  /** Inner class to implement Voting mechanism.
  */
  public class Vote implements Serializable {
    private String votedID;
    private String voterName;
    private String voteParty;

    /** Constructor for the Vote class.
    */
    public Vote(String vi, String vn, String vp) {
      voterName = vn;
      voterID = vi;
      voterParty = vp;
    }

    /** Mutator method for setting voter ID.
    */
    public String setVoterID(String vi) {
      voterID = vi;
    }

    /** Accessor method for obtaining voter ID.
    */
    public String getVoterID() {
      return voterID;
    }

    /** Mutator method for setting voter name.
    */
    public String setVoterName(String vn) {
      voterName = vn;
    }

    /** Accessor method for obtaining voter name.
    */
    public String getVoterName() {
      return voterName;
    }

    /** Mutator method for setting vote party.
    */
    public String setVoteParty(String vp) {
      voteParty = vp;
    }

    /** Accessor method for obtaining vote party.
    */
    public String getVoteParty() {
      return voteParty;
    }
  }

  // Create vote object
  private Vote vote;

  // Create objects for previous and current hashes.
  private int previousHash;
  private int blockHash;

  /** Constructor for the Block class.
  */
  public Block(int ph, String vi, String vn, String vp) {
    previousHash = ph;
    vote = new Vote(vi, vn, vp);
    Object[] contents = {vote.hashCode(), previousHash};
    blockHash = contents.hashCode();
  }

  /** Mutator method for setting vote.
  */
  public void setVote(Vote v) {
    vote = v;
  }

  /** Accessor method for obtaining vote.
  */
  public Vote getVote() {
    return vote;
  }

  /** Mutator method for setting previous hash.
  */
  public void setPreviousHash(int ph) {
    previousHash = ph;
  }

  /** Accessor method for obtaining previous hash.
  */
  public int getPreviousHash() {
    return previousHash;
  }

  /** Mutator method for setting previous hash.
  */
  public void setBlockHash(int bh) {
    blockHash = bh;
  }

  /** Accessor method for obtaining block hash.
  */
  public int getBlockHash() {
    return blockHash;
  }

  /** Method to override already existing toString() method.
  */
  @Override
  public String toString() {
    return "Voter ID: " + vote.voterID + "\nVoter Name: " + vote.voterName + "\Voted for Party: " + vote.voteParty;
  }
}
