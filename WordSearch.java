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
    public String toString(){
      String output = "";
      for (int rownum = 0; rownum < data.length; rownum += 1) {
        if (rownum > 0) {output += "\n";}
        for (int colnum = 0; colnum < data[rownum].length; colnum += 1) {
          output += data[rownum][colnum] + " ";
        }
      }
      return output;
    }


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

}
