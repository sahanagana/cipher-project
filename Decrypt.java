import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuilder;
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
    //remove duplicate letters
    String key2 = removeDuplicate(keyletters,keyletters.length);
    //loop through array
    for(int x =0; x< key2.length();x++){
      //find index of the char in word
      ArrayList<Integer> frick = findMore(key,key2.charAt(x));
      //go through all occurences of char in the list, but backwards since we're decrypting
      for(int z = 0; z<frick.size(); z++){
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
    //int to catch first letter
    int y = 0;
    for(int x =0; x<text.length(); x++){
      //if the char occurs
      if (text.charAt(x) == e){
        //increment catch
        y++;
        //add index to list
        count.add(x);
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
  //GoatsforGeeks B)
    static String removeDuplicate(char[] str, int n)
  {
      // Used as index in the modified string
      int index = 0;

      // Traverse through all characters
      for (int i = 0; i < n; i++)
      {

          // Check if str[i] is present before it
          int j;
          for (j = 0; j < i; j++)
          {
              if (str[i] == str[j])
              {
                  break;
              }
          }

          // If not present, then add it to
          // result.
          if (j == i)
          {
              str[index++] = str[i];
          }
      }
      return String.valueOf(Arrays.copyOf(str, index));
  }
}
