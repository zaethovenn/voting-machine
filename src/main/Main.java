package src.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.blockchain.Block;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import static java.lang.System.exit;
import static java.lang.System.lineSeparator;

/**
 * The Main class consists of framework that is intended to simulate voting using Blockchain.
 */
public class Main {
  public static void main(String[] args) {
    // Display menu for user to
    System.out.println(" **** MAIN MENU ****");
    System.out.println("1. Cast Votes");
    System.out.println("2. View Votes on Blockchain");
    System.out.println("3. Count Votes");
    System.out.println("0. Exit Program");

    Scanner sc = new Scanner(System.in);

    System.out.println("********************");
    System.out.println("Please input your choice: ");
    int input = sc.nextInt();
    }
  }
}
