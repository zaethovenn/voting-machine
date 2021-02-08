# Report by Kai'lani Woodard, zackery devers

## Introduction and Motivation

What is the concept behind your project? How does it satisfy the two broad requirements on this assignments? Discuss briefly
how your concept is motivated by the cryptocurrency-related technology and what existing or potential solutions might it provide to our challenges?

Our concept for this project was to code a blockchain based voting machine. Features of this voting machine includes being easy-to-use and anonymous voting for the user. Our use of a blockchain data structure relates us to the concept of cryptocurrency-related technology. This helps solve the problem that society recently went through with the most recent election. In said election, our former president claims there to be an abundance of voter fraud. Even though said voter fraud might not have taken place, our prototype for a better voting system that can help prevent said claims from even occurring.

## Design of your Project

This section should provide detailed description of your design. Please include a visual representation of the design of your project. This could include a technical diagram or a flowchart demonstrating how your concept works, a walk through a conceptual example, etc.

## Implementation

This section should describe implementation details of your project (how you implemented your solution). Please describe which languages, libraries, external tools you used. This section should also provide commands (in code blocks) that are needed to run your implementation and what is needed to be installed beforehand.

We decided to program our project in Java because we all have a good familiarity with the language and also because of its object-oriented nature. Our program is fairly simple, therefore we felt that in order to create the best program possible that using a language that we are all familiar with was the best and most efficient method of achieving the project.



Regarding importing external libraries, we had to import Java packages in order for our program to function correctly. The two packages we imported were java.util.* and  java.io.Serializable. We chose to install all of the components of the java.util package because of our use with several of the interfaces within it, including ArrayList, HashSet, and Scanner.

For our program to work correctly on your machine you need to have Java jdk1.8 or newer in order for the voting machine to be able to run.

In order to run the program, you would navigate to the `src` directory and run the following commands in your terminal.

```
javac Main.java
java Main
```

## Evaluation and Testing

This section should concentrate on how you conducted evaluation of your solution. You should test your implementation with different inputs (at least ten, if it makes sense) to verify its correctness, efficiency, effectiveness, etc. as appropriate for your project. Please include the input and a sample output in code blocks or indicate where these inputs/outputs are located  (as appropriate given your implementation). Automated testing is preferred but manual testing is acceptable. You must describe the type of testing that have been done and include the output of test cases in code blocks if appropriate.

## Description of the challenges that you faced and how you resolved them

In our original implementation, we intended for each vote to be encrypted and then decrypted when displaying the votes on the blockchain. Unfortunately, in our merits to achieve this we had come up with failure each time. To our dismay, our solution to this problem was removing the function of encrypting and decrypting from the program completely as each attempt at implementation was non-functional.

However, this fortunately paved the way for making programming much easier for the rest of the project.

## If worked in a team, description of the way in which you and your team members shared the project work

Zackery Devers- for my portion of the project I focused more on the presentation rather then the coding due to the time difference. My partners got a lot of the base coding done while they had the allotted time to do so in class so they left minor problems and bugs to fix if they couldn't figure out the solution to them. We really focused on making sure everyone was involved with the allotted problem occurring from time zone difference.

Robert McMaster-

Kai'lani Woodard-
