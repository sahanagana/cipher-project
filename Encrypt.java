import java.util.*;
public class Encrypt{
  //ciphertext
  private String ciphertext = "";
  //plaintext
  private String plaintext;
  //array for rearranging
  private char[][] letters;
  //keyword
  private String key;

  public Encrypt (String pt, String k){
    //variables
    plaintext = pt;
    key = k;
  // calculate dimensions of array
    //get length of keyword-- this will be the amount of columns
    int len = k.length();
    //length of rows will be however many needed to fit plaintext
    int num = pt.length()/len +1;
  //initialize letter array
    letters= new char[num][len];
    //increment variable for next line
    int increment = 0;
    //for loop to put the letters in order
    for(int r = 0; r<num;r++){
      for (int c = 0; c<len; c++){
        //CHECK if it's not past the last letter
        if(c+increment < pt.length()){
          letters[r][c] = pt.charAt(c+increment);
        }
        //if it is past last letter, just add a dash
        else{
          letters[r][c] = '-';
        }
      }
      //increase increment by the column number to shift letters
      increment+=len;
    }

  }
  
  public String toString(){
  // create alphabetized char array for letters
    char[] keyletters = key.toCharArray();
    Arrays.sort(keyletters);
    //loop through array
    for(int x =0; x< keyletters.length;x++){
      //find index of the char in word
      int index = key.indexOf(keyletters[x]);
      //loop through a column
      for(int r = 0; r<letters.length; r++){
        //get all the letters in that column and add it to the ciphertext
        ciphertext+= letters[r][index];
      }
      //repeat until you go through all the rows in that column
    }

    return ciphertext;
  }

// I DID IT YES YES YES
}