
import java.util.*;
class Main {
  public static void main(String[] args) {
    //create scanner

    Scanner kb = new Scanner(System.in);
    //ask
    //System.out.println("Hello world! Would you like to encrypt something or decrypt it?");
    System.out.println("Hello world! Would you like to use my cipher or the Subsitution Cipher?");
    System.out.println("Enter A for mine or B for substitution.");
    //System.out.println("Enter E to encrypt or D to decrypt.");
    //get answer
    
    String answer = kb.next().toLowerCase();
    // if person answers with something that isnt e or d
    while(!answer.equals("a")&& !answer.equals("b")){
      //whiteSPOACESLKJDF
      kb.nextLine();
      //pop off sis
      System.out.println("Are you dumb enter the thing i fricking told you to enter A or B ill kill u");
      //get the next answer and loop
      answer = kb.next().toLowerCase();
    }
    if(answer.equals("a")){
      EorDMine();
    }
    else if (answer.equals("b")){
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
    //encryption

    if(which.equals("e")){
      //get total of all letter indexes in key
      for(int x = 0; x< key.length(); x++){
        total += findIndex(letters, key.charAt(x))+1;
      }
      total%=122;
      //make array of charACTERS in text
      char[] textletters = text.toCharArray();
      String word;
      //loop through and increment each letter
      for(char thing: textletters){
        int temp = thing;
        temp += total;
        //doesn't go past z?
        temp%= 122;
        // doesn't go before a
        if (temp< 65){
          temp +=65;
        }
        int x = findIndex(textletters, thing);
        textletters[x] = (char)temp;
        //add to array
      }
      word = new String (textletters);
      //return the result
      return word;
    }
    else{
      //get total of key = 85;
      for(int x = 0; x< key.length(); x++){
        total += findIndex(letters, key.charAt(x));
      }
      total%=122;
      char[] textletters = text.toCharArray();
      String word = "";
      //literally just subtract it should be good
      for(char thing: textletters){
        int temp = thing;
        temp-= total;

        int x = findIndex(textletters, thing);
        textletters[x] = (char)temp;
        //add to array
      }
      word = new String (textletters);
      //return the result
      return word;

    }
  }

  public static int findIndex(char[] arr, char x){
    for (int z = 0; z< arr.length; z++){
      if (arr[z] ==(x)){
        return z;
      }
    }
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
      System.out.println("Enter the text you would like to encrypt (use - instead of a space):");
      //get parameters
      String pt = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      
      System.out.print("Your encrypted message is: "  + myCipher(pt,k,"e")  );
    }
    else if(answer.equals("d")){
      //ask
      System.out.println("Enter the text you would like to decrypt (use - instead of a space):");
      //get parameters
      String ct = kb.next().toLowerCase();
      System.out.println("Enter your key:");
      String k = kb.next().toLowerCase();
      //create obj and print
      
      System.out.print("Your decrypted message is: "  + myCipher(ct,k,"d"));
    }
  }
  

}

