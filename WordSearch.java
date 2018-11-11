import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;

    /**Initialize the grid to the size specified

     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      clear();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int rownum = 0; rownum < data.length; rownum += 1) {
        for (int colnum = 0; colnum < data[rownum].length; colnum += 1) {
          data[rownum][colnum] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    /**public String toString(){
      String output = "";
      for (int rownum = 0; rownum < data.length; rownum += 1) {
        if (rownum > 0) {output += "\n";}
        for (int colnum = 0; colnum < data[rownum].length; colnum += 1) {
          output += data[rownum][colnum] + " ";
        }
      }
      return output;
    }
    */

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned

     * and the board is NOT modified.

     */
    public boolean addWordHorizontal(String word,int row, int col){
      if (data[row].length - col - word.length() < 0 ||
          data.length - row < 0) {return false;}
      for (int i = 0; i < word.length(); i += 1) {
        if (!(data[row][i + col] == '_' ||
          data[row][i + col] == word.charAt(i)))
          {return false;}
      }
      for (int i = 0; i < word.length(); i += 1) {
        data[row][i + col] = word.charAt(i);}
      return true;
    }


   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.

     */
    public boolean addWordVertical(String word,int row, int col){
      if (data[col].length - row - word.length() < 0 ||
          data.length - col < 0) {return false;}
      for (int i = 0; i < word.length(); i += 1) {
        if (!(data[row + i][col] == '_' ||
          data[row + i][col] == word.charAt(i)))
          {return false;}
      }
      for (int i = 0; i < word.length(); i += 1) {
          data[row + i][col] = word.charAt(i);}
      return true;
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top left to bottom right, must fit on the WordGrid,
   *and must have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   */
  public boolean addWordDiagonal(String word,int row, int col){
    if (data[col].length - row - word.length() < 0 ||
        data.length - col < 0 ||
        data[row].length - col - word.length() < 0 ||
        data.length - row < 0
        ) {return false;}
        for (int i = 0; i < word.length(); i += 1) {
            data[row + i][col + i] = word.charAt(i);}
        return true;

  }

  // Assignment Part 2;
  /** Attempts to constuct a word search using
  *@param fileName is the file used to create the WordSearch
  *@param row is the horizontal length of the word search.
  *@param col is the verical length of the word search
  */
  //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;



  // Part 1 - Two Constructors
  public WordSearch( int rows, int cols, String fileName) {
    //  Choose a randSeed using the clock random
    new WordSearch(rows, cols, fileName);
    randgen = new Random();
    //addAllWords();

  }


  public WordSearch( int rows, int cols, String fileName, int randSeed) {
    //Use the random seed specified.
    new WordSearch(rows,cols,fileName);
    randgen = new Random(randSeed);
    seed = randSeed;
  }



  // Part 2 - Better to String;

  public String toString() {
    String output = "";
    for ( int x = 0; x < data.length; x += 1) {
      output += "|";
      for (int y = 0; y < data[x].length; y += 1) {
        output += data[x][y];
        if (y < data[x].length - 1) {
          output += " ";
        }
      }
      output += "|";
    }
    output += wordsAdded;
    output += "(" + seed + ")";
    return output;
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
  *The word is added in the direction rowIncrement,colIncrement

  *Words must have a corresponding letter to match any letters that it overlaps.

  *
  *@param word is any text to be added to the word grid.
  *@param row is the vertical locaiton of where you want the word to start.
  *@param col is the horizontal location of where you want the word to start.

  *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
  *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction

  *@return true when: the word is added successfully.
  *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
  *        OR there are overlapping letters that do not match
  */
 private boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
   if (word.length()*rowIncrement + col > data.length - 1 ||
       word.length()*rowIncrement + col < 0 ||
       word.length()*colIncrement + row > data[row].length ||
       word.length()*colIncrement + row < 0
       )
       {return false;}
  for (int i = 0; i < word.length(); i += 1) {
    int j = row + rowIncrement * i;
    int k = col + colIncrement * i;
    if (data[j][k] != word.charAt(i) ||
        data[j][k] == '_') {
          return false;
        }
  }
  for (int i = 0; i < word.length(); i += 1) {
    int j = row + rowIncrement * i;
    int k = col + colIncrement * i;
    data[j][k] = word.charAt(i);}
  return true;
 }

 /*[rowIncrement,colIncrement] examples:

  *[-1,1] would add up and the right because (row -1 each time, col + 1 each time)

  *[ 1,0] would add downwards because (row+1), with no col change

  *[ 0,-1] would add towards the left because (col - 1), with no row change

  */

  private void addAllWords() {
    for (int i = 0; wordsToAdd.size() > 0 || i < 1000; i += 1) {
      int index = randgen.nextInt() % wordsToAdd.size();
      int rowIncrement = randgen.nextInt() % 3 - 1;
      int colIncrement = randgen.nextInt() % 3 - 1;
      int row = randgen.nextInt() % data.length;
      int col = randgen.nextInt() % data[0].length;
      String word = wordsToAdd.get(index);
      for (int j = 0; j < 200; j += 1)
      if (addWord(word, row, col,rowIncrement,colIncrement)) {
        j = 200;
        wordsToAdd.remove(word);
        wordsAdded.add(word);
      }
    }
  }















}
