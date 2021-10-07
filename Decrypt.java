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
      ArrayList<Integer> frick = findMore(ct,k.charAt(x));
      //go through all occurences of char in the list
      for(int z = 0; z<frick.size(); z++){
        //check if char hasn't been done before
        if(ct.charAt(r+increment)!= '.'){
          //get index of next occurrence of char
          int index = frick.get(z);
          //go through column
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
        }

        }
    }
  }

  public String toString(){
    //just loop straight through the array and add everything! (lol i thought it was so simple 2 weeks ago huh)
    for(int r = 0; r<letters.length; r++){
      for(int c = 0; c< letters[r].length; c++){
        plaintext+= letters[r][c];
      }
    }
    //easy peasy lemon squeezy 
    return plaintext;
  }

  //method in case there are more than one of the same letter — thanks sebbi
  public ArrayList<Integer> findMore(String text, char e){
    //create arraylist
    ArrayList<Integer> count = new ArrayList<Integer>();
    //loop through word
    for(int x =0; x<text.length(); x++){
      //if the char occurs
      if (text.charAt(x) == e){
        //increment catch
        y++;
        //add index to list
        count.add(x);
        //change the other letters so it won't reloop
        if(y>1){
          text.charAt(x)= '.';
        }
      }
    }
    //return
    return count;
  }
  //fml

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
