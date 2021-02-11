import java.util.*;

/**
* The Main class consists of framework that is intended to simulate voting using Blockchain.
*/
public class Main {
  public static void main(String[] args) {
    // Display menu for user to view their options
    menuDisplay(true);
    // Create scanner object to read user input from the terminal
    Scanner sc = new Scanner(System.in);
    char action = Character.toUpperCase(sc.next().charAt(0)); // Save input to variable action
    while (!validateChoice(action, true)) {
      menuDisplay(true);
      action = Character.toUpperCase(sc.next().charAt(0)); // Save action to action variable
    }
    System.out.println("");

    // Create HashSet to ensure there are no repeat votes according to VoterID
    HashSet<String> hashVotes = new HashSet<>();
    // Create BlockList to store votes as a Blockchain
    ArrayList<Block> blockList = new ArrayList<>();
    // Create "Genesis Block" to be the first block of the chain
    Block genesisBlock = new Block(0, "", "", "");
    blockList.add(genesisBlock); // Add genesisBlock to the blockchain

    // Candidates ArrayList for potential candidates to vote for
    ArrayList<String> candidates = new ArrayList<>();
    // Add candidates to the candidates ArrayList
    candidates.add("Kanye West");
    candidates.add("Chompers");
    candidates.add("Chiddy Bang");

    // Initialize variables necessary as parameters for the Blockchain
    String voterID = "";
    String voterName = "";
    String voteParty = "";
    int prevHash = 0;

    // Do-while loop to ensure the program runs through at least once
    do {
      // Option 1: Voting for Candidates
      if (action == '1') {
        // Greet users into the Voting Machine
        System.out.println("Welcome to the Voting Machine!");
        // Prompt user for voter ID
        System.out.println("Enter voter ID: ");
        sc.nextLine(); // Lineskip to fix strange error
        voterID = sc.nextLine(); // Save ID to voterID
        // Prompt user for their name
        System.out.println("Enter voter name: ");
        voterName = sc.nextLine(); // Save name to voterName

        // Indicate break to show list of candidates
        System.out.println("\n**** Vote for Candidates ****");

        // Print candidates to the terminal for voters to see
        for (int i = 0; i < candidates.size(); i++) {
          System.out.println((i+1) + ". " + candidates.get(i));
        }

        // Prompt user for their vote
        System.out.println("Enter your vote: ");
        voteParty = sc.nextLine(); // Save vote to voteParty
        // Add vote to the blockchain
        Block vote = new Block(prevHash, voterID, voterName, candidates.get(Integer.parseInt(voteParty)-1));

        // Ensure vote is properly valid by means of no repeated voter IDs
        if (checkValidity(vote, hashVotes)) {
          hashVotes.add(voterID); // Add voterID to hashset of hashVotes
          prevHash = vote.getBlockHash(); // previousHash = the current block hash
          // Add vote to blockchain
          blockList.add(vote);
        // if voterID already exists within the hashset
        } else {
          // Print alert to user
          System.out.println("Vote invalid!");
        }

        // Prompt user to continue voting or to stop
        System.out.println("\nDo you want to continue voting? (Y/N)");
        char answer = Character.toUpperCase(sc.next().charAt(0)); // Save answer to answer variable
        // If answer is no, display main menu again
        if (answer == 'N') {
          // Display menu for user to view their options
          menuDisplay(false);
          action = Character.toUpperCase(sc.next().charAt(0)); // Save action to action variable
          while (!validateChoice(action, false)) {
            menuDisplay(false);
            action = Character.toUpperCase(sc.next().charAt(0)); // Save action to action variable
          }

          // If action = 0, then quit the program
          if (action == '0') {
            break;
          }
        }

      // Option 2: Display Votes on the Blockchain
      } else if (action == '2') {
        // Header for displaying votes
        System.out.println("\n**** Displaying Votes ****\n");

        // for loop to continuously display votes
        for (int i = 1; i < blockList.size(); i++) {
          System.out.println(blockList.get(i).toString());
          System.out.println("\n**************************\n"); // Asterisks for pretty
        }

        // Alert user that they are being defaulted back to the main menu
        System.out.println("\nDefaulting back to main menu...\n");
        menuDisplay(false);
        action = Character.toUpperCase(sc.next().charAt(0)); // Save action to action variable
        menuDisplay(false);
        while (!validateChoice(action, false)) {
          menuDisplay(false);
          action = Character.toUpperCase(sc.next().charAt(0)); // Save action to action variable
        }
        // If action = 0, then quit the program
        if (action == '0') {
          break;
        }
      }
    } while (true); // Continously operate this do-while loop until user elects to quit

    int c1Count = 0, c2Count = 0, c3Count = 0;

    // Final counting of the votes
    System.out.println("\n**** Results of the Election ****");
    for (int i = 0; i < blockList.size(); i++) {
      if (blockList.get(i).getVote().getVoteParty().equals(candidates.get(0))) {
        c1Count++;
      } else if (blockList.get(i).getVote().getVoteParty().equals(candidates.get(1))) {
        c2Count++;
      } else if (blockList.get(i).getVote().getVoteParty().equals(candidates.get(2))) {
        c3Count++;
      }
    }

    for (int i = 0; i < candidates.size(); i++) {
      int count = 0;
      if (i == 0)
        count = c1Count;
      else if (i == 1)
        count = c2Count;
      else if (i == 2)
        count = c3Count;
      System.out.println(candidates.get(i) + ": " + count);
    }

    System.out.println("*********************************\n");

    String winner = "";

    if (c1Count > c2Count && c1Count > c3Count) {
      winner = candidates.get(0);
    } else if (c2Count > c1Count && c2Count > c3Count) {
      winner = candidates.get(1);
    } else if (c3Count > c1Count && c3Count > c2Count) {
      winner = candidates.get(2);
    } else if (c1Count == c2Count || c2Count == c3Count || c3Count == c1Count) {
      winner = "tie";
    }

    if (winner.equals("tie")) {
      System.out.println("There appears to be a tie! We must revote!");
    } else {
      System.out.println("The winner of the election is " + winner + "!");
    }

    // Thank user for using the Voting Machine
    System.out.println("\nThank you for using the Voting Machine!");
  }

  /** checkValidity method evaluates if the voterID already exists within the HashSet.
  */
  public static boolean checkValidity(Block b, HashSet hv) {
    if (hv.contains((String)b.getVote().getVoterID()))
    return false;
    else
    return true;
  }

  /** Method for displaying interactive menu in order to avoid repeating code
     */
  public static void menuDisplay(boolean first){
    if (first) {
      System.out.println("\n**** MAIN MENU ****");
      System.out.println("1. Cast Votes");
      System.out.println("2. View Votes on Blockchain");
    } else {
      System.out.println("\n**** MAIN MENU ****");
      System.out.println("1. Cast Votes");
      System.out.println("2. View Votes on Blockchain");
      System.out.println("0. Exit Program");
    }
    System.out.println("********************");
    System.out.println("Please input your choice: ");
  }

  public static boolean validateChoice(char c, boolean first) {
    if (first) {
      if (c != '1' && c != '2') {
        System.out.println("\nInvalid input, please input one of the listed options! (1 or 2)");
        return false;
      }
    } else {
      if (c != '1' && c != '2' && c != '0') {
        System.out.println("\nInvalid input, please input one of the listed options! (1, 2, or 0)");
        return false;
      }
    }
    return true;
  }
}
