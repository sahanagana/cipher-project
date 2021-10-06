
import java.util.*;
class Main {
  public static void main(String[] args) {
    //create scanner

    Scanner kb = new Scanner(System.in);
    //ask
    //System.out.println("Hello world! Would you like to encrypt something or decrypt it?");
    System.out.println("Hello world! Would you like to use my cipher or the Transposition Cipher?");
    System.out.println("Enter A for mine or B for transposition.");
    //System.out.println("Enter E to encrypt or D to decrypt.");
    //get answer
    
    String answer = kb.next().toLowerCase();
    
    while(!answer.equals("a")&& !answer.equals("b")){
      //whiteSPOACESLKJDF
      kb.nextLine();
      //// if person answers with something that isnt e or d- pop off
      System.out.println("Are you dumb enter the thing i fricking told you to enter A or B ill kill u");
      //get the next answer and loop
      answer = kb.next().toLowerCase();
    }
    if(answer.equals("a")){
      //a is my cipher
      EorDMine();
    }
    else if (answer.equals("b")){
      //b is the transposition
      EorD();
    }
    else{
      System.out.println("you weren't supposed to get here");
    }

    
    //Encrypt test= new Encrypt("example", "key");
    //System.out.println(test.toString());
    //Decrypt again = new Decrypt("xp emeal", "key");
    //System.out.println(again.toString());
  }
  public static String myCipher(String text, String key, String which){
    //get index of letter
    int total = 0;
    char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    String word = "";
    //encryption

    if(which.equals("e")){
      //get total of all letter indexes in key
      for(int x = 0; x< key.length(); x++){
        total += findIndex(letters, key.charAt(x))+1;
      }
      
      //loop through and increment each letter
      for(int x = 0; x< text.length(); x++){
        //set temp
        char temp = text.charAt(x);
        //get shifted index, check if goes past 25
        int index = (findIndex(letters, temp)+total)%26;
        temp = letters[index];
        word += temp;
      }

      //return the result
      return word;
    }
    else{
      //get total of all letter indexes in key
      for(int x = 0; x< key.length(); x++){
        total += findIndex(letters, key.charAt(x))+1;
      }
      
      //loop through and increment each letter
      for(int x = 0; x< text.length(); x++){
        //set temp
        char temp = text.charAt(x);
        //get shifted index, check if goes past 25
        int index = (findIndex(letters, temp)-total);
        //check if negative 
        if(index<0){
          //add 26
          index += 26;
          //check if goes over just in case
          index %=26;
        }
        //get new char
        temp = letters[index];
        //add to word
        word += temp;
      }

      //return the result
      return word;

    }
  }
  //method i made bc im stoopid
  public static int findIndex(char[] arr, char x){
    //AYO
    for (int z = 0; z< arr.length; z++){
      if (arr[z] ==(x)){
        return z;
      }
    }
    //hopefully this doesn't happen
    return -1;
  }

  public static void EorD (){
    Scanner kb = new Scanner(System.in);
    System.out.println("Hello world! Would you like to encrypt something or decrypt it?");
    System.out.println("Enter E to encrypt or D to decrypt.");
    //get answer
    
    String answer = kb.next().toLowerCase();
    while(!answer.equals("e")&& !answer.equals("d")){
      //yak the drill
      kb.nextLine();
      //eliminate them
      System.out.println("bro dont play w me rn e or d");
      //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
      answer = kb.next().toLowerCase();
    }
    if(answer.equals("e")){
      //ask
      System.out.println("Enter the text you would like to encrypt (use - instead of a space):");
      //get parameters
      String pt = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      Encrypt thing = new Encrypt(pt,k);
      System.out.print("Your encrypted message is: "  + thing.toString() );
    }
    else if(answer.equals("d")){
      //ask
      System.out.println("Enter the text you would like to decrypt (use - instead of a space):");
      //get parameters
      String ct = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      Decrypt thingy = new Decrypt(ct,k);
      System.out.print("Your decrypted message is: "  + thingy.toString() );
    }
  }

  public static void EorDMine(){
    Scanner kb = new Scanner(System.in);
    System.out.println("Hello world! Would you like to encrypt something or decrypt it?");
    System.out.println("Enter E to encrypt or D to decrypt.");
    //get answer
    
    String answer = kb.next().toLowerCase();
    while(!answer.equals("e")&& !answer.equals("d")){
      //yak the drill
      kb.nextLine();
      //eliminate them
      System.out.println("bro dont play w me rn e or d");
      //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
      answer = kb.next().toLowerCase();
    }
    if(answer.equals("e")){
      //ask
      System.out.println("Enter the text you would like to encrypt (dont use spaces):");
      //get parameters
      String pt = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      
      System.out.print("Your encrypted message is: "  + myCipher(pt,k,"e")  );
    }
    else if(answer.equals("d")){
      //ask
      System.out.println("Enter the text you would like to decrypt (no spaces):");
      //get parameters
      String ct = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      
      System.out.print("Your decrypted message is: "  + myCipher(ct,k,"d"));
    }
  }
  
  //YE S IT OWRKS
}

