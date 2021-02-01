import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import static java.lang.System.exit;
import static java.lang.System.lineSeparator;

/**
* The Main class consists of framework that is intended to simulate voting using Blockchain.
*/
public class Main {
  public static void main(String[] args) {
    // Display menu for user to view their options
    System.out.println(" **** MAIN MENU ****");
    System.out.println("1. Cast Votes");
    System.out.println("2. View Votes on Blockchain");
    System.out.println("0. Exit Program");

    // 4 total options
    Scanner sc = new Scanner(System.in);

    // print out empty spaace for users input

    System.out.println("********************");
    System.out.println("Please input your choice: ");
    char action = Character.toUpperCase(sc.next().charAt(0));

    HashSet<String> hashVotes = new HashSet<>();
    ArrayList<SealedObject> blockList = new ArrayList<>();
    Block genesisBlock = new Block(0, "", "", "");
    try{
    blockList.add(encrypt(genesisBlock));
    }
    catch(Exception e){
      System.out.println("error");
    }

    // Candidates ArrayList for potential candidates to vote for
    ArrayList<String> candidates = new ArrayList<>();
    candidates.add("one");
    candidates.add("two");
    candidates.add("three");

    String voterID = "";
    String voterName = "";
    String voteParty = "";
    int prevHash = 0;

    // Starting structures of accesible menu
    do {
      if (action == 0) {
        break;
      } else if (action == '1') {
        System.out.println("Welcome to the Voting Machine!");
        System.out.println("Enter voter ID: ");
        voterID = sc.nextLine();
        System.out.println("Enter voter name: ");
        voterName = sc.nextLine();
        System.out.println("**** Vote for Candidates ****");

        for (int i = 0; i < candidates.size(); i++) {
          System.out.println((i+1) + ". " + candidates.get(i));
        }

        System.out.println("Enter your vote: ");
        voteParty = sc.nextLine();
        Block vote = new Block(prevHash, voterID, voterName, voteParty);

        if (checkValidity(vote, hashVotes)) {
          hashVotes.add(voterID);
          prevHash = vote.getBlockHash();
          blockList.add(encrypt(vote));
        } else {
          System.out.println("Vote invalid!");
        }
      } else if (action == '2') {
        System.out.println("**** Displaying Votes ****");

        for (int i = 1; i < blockList.size(); i++) {
          System.out.println(decrypt(blockList.get(i)));
        }

        System.out.println("**************************");
      }
    } while (true);
  }

  public static SealedObject encrypt(Block b) throws Exception {
    SecretKeySpec sks = new SecretKeySpec("MyDifficultPassw".getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCSSPadding");
    cipher.init(Cipher.ENCRYPT_MODE, sks);

    return new SealedObject(b, cipher);
  }

  public static Object decrypt(SealedObject so) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
    SecretKeySpec sks = new SecretKeySpec("MyDifficultPassw".getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, sks);

    try {
      return so.getObject(cipher);
    } catch (ClassNotFoundException | IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static boolean checkValidity(Block b, HashSet hv) {
    if (hv.contains((String)b.getVote().getVoterID()))
    return false;
    else
    return true;
  }
}
