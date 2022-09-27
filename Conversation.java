/*

Author: Eva Kinnel
CSC 120 - A3
September 2022

 */


import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


class Conversation {

  public static void main(String[] arguments) {
    
    System.out.println("\nFor how many rounds would you like to converse?");
    Scanner inputHowMany = new Scanner(System.in);
    int numRounds = inputHowMany.nextInt();

    String[] scriptArray = new String[2 * numRounds + 2]; // set size of Array

    System.out.println("\nHey! What are you thinking about?");
    scriptArray[0] = "\nHey! What are you thinking about?";

    Scanner inputLoop = new Scanner(System.in);  


    List<String> randomResponses = Arrays.asList("Hmm...", "Say something else instead","Tell me about yourself");
    
    int b = 1; // so that the questions and responses don't write over each other

    for (int n = 0; n < numRounds; n++){

      /*
       * define list that will store new words for output
       * take user input
       * convert user input into list for iteration
       */

      List<String> outList=new ArrayList<String>();

      String whatThink = inputLoop.nextLine();
      scriptArray[b] = whatThink; // add the input to transcript
      b = b + 1;

      String[] think = whatThink.split(" ");
      List<String> thinkList = Arrays.asList(think);

      /*
       * Generate random response if no mirror words are in user input:
       */
      if (!thinkList.contains("I") && !thinkList.contains("am") && !thinkList.contains("are") && !thinkList.contains("you") && !thinkList.contains("my") && !thinkList.contains("your") && !thinkList.contains("me")){
        String response = randomResponses.get(new Random().nextInt(randomResponses.size()));
        System.out.println(response);
        scriptArray[b] = response;
        b = b + 1;

      }else{
  
      for (int i = 0; i < thinkList.size(); i++){

        if(thinkList.get(i).equals("I")){    // if this word in list is "I"
          // System.out.println("you");
          outList.add("you"); // add "you" to new list
        }
        else if(thinkList.get(i).equals("am")){    
          outList.add("are");
        }
        else if(thinkList.get(i).equals("are")){    
          outList.add("am");
        }
        else if(thinkList.get(i).equals("you")){    
          outList.add("I");
        }
        else if(thinkList.get(i).equals("my")){    
          outList.add("your");
        }
        else if(thinkList.get(i).equals("your")){    
          outList.add("my");
        }
        else if(thinkList.get(i).equals("me")){    
          outList.add("you");
        }
        else if(!thinkList.get(i).equals("your") || !thinkList.get(i).equals("me") || !thinkList.get(i).equals("my")|| !thinkList.get(i).equals("you")|| !thinkList.get(i).equals("are")|| !thinkList.get(i).equals("am")|| !thinkList.get(i).equals("I")){ 
        outList.add(thinkList.get(i));}

      } // close INPUT ITERATION for loop

      String joined = String.join(" ", outList); // join list back into string
      String response = (joined + "?");
      System.out.println(response); // print mirror question
      scriptArray[b] = response;
      b = b + 1;

    
    } // close else statement
    

  } //close ROUNDS for loop


  String end = "BYEEEEEEEE";
  System.out.println(end);
  scriptArray[b] = end;
  
  System.out.println("\nTRANSCRIPT:");
  
  for(int i=0 ; i<scriptArray.length ; i++)    //print array
  System.out.println(scriptArray[i]);    


    inputHowMany.close();
    inputLoop.close();
    
  }}


/*

Sources Used:
  https://www.w3schools.com/java/java_for_loop.asp
  https://www.w3schools.com/java/java_user_input.asp
  https://stackoverflow.com/questions/3728253/what-are-docstrings-called-in-java
  https://www.javatpoint.com/java-string-contains
  https://www.geeksforgeeks.org/java-program-to-replace-multiple-characters-in-a-string/
  https://stackoverflow.com/questions/20275572/how-to-use-or-in-java
  https://softhints.com/java-split-string-into-list-examples/
  https://stackoverflow.com/questions/29441908/list-cannot-be-resolved-to-a-type
  https://www.javatpoint.com/how-to-iterate-list-in-java
  https://www.delftstack.com/howto/java/not-equals-java/
  https://www.geeksforgeeks.org/list-contains-method-in-java-with-examples/
  https://www.geeksforgeeks.org/arrays-in-java/

 */
