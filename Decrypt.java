import java.util.*;
public class Decrypt{
  //plaintext
  private String plaintext = "";
  //array for rearranging
  private char[][] letters;
  //keyword
  private String key;

  public Decrypt(String ct, String k){
  //assign variables
    key = k;
    int increment =0;
  // calculate dimensions of array
    //get length of keyword-- this will be the amount of columns
    int len = k.length();
    //length of rows will be however many needed to fit plaintext
    int num = ct.length()/len;
  //initialize letter array
    letters= new char[num][len];
    //increment variable for next line
  //find column order to put letters in
    // create alphabetized char array for letters
    char[] keyletters = key.toCharArray();
    Arrays.sort(keyletters);
    //loop through array
    for(int x =0; x< keyletters.length;x++){
      //find index of the char in word

      int index = key.indexOf(keyletters[x]);
      //loop through a column
      for(int r = 0; r<letters.length; r++){
        //add letters from ciphertext to array
        if(r+increment < ct.length()){
          letters[r][index] = ct.charAt(r+increment);
        }
        //if it is past last letter, leave
        else{
          letters[r][index] = '-';
        }
        //literally kill me right now
      }
      increment+= num;
      //repeat until you go through all the rows in that column
    }
  }

  public String toString(){
    //just loop straight through the array and add everything!
    for(int r = 0; r<letters.length; r++){
      for(int c = 0; c< letters[r].length; c++){
        plaintext+= letters[r][c];
      }
    }
    //easy peasy lemon squeezy 
    return plaintext;
  }

  //method in case there are more than one of the same letter
  public ArrayList<Integer> findMore(String text, char x){
    ArrayList<Integer> count = new ArrayList<Integer>();
    for(int x =0; x<text.length(); x++){
      if (text.charAt(x) == x){
        count.add(x);
      }
    }
    return count;
  }

  public int getIndex(char[] arr, char letter){
    //loop through array to find index of a letter
    for(int x= 0; x< arr.length; x++){
      if (arr[x]== letter){
        return x;
      }
    }
    //if not found get -1, probably won't happen but just in case
    return -1;
  }
}
