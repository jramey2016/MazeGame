/**
 * Class TraverseMaze is a sample for learning how to use the recursion to traverse the mazes.
 */

public class Traverse {
    /**
     * field mazeSymbols is a simple 6 * 6 character array.
     */
    private  char[][] mazeSymbols = new char[6][6]; //6 * 6 multidimensional array for maze samples

    /**
     * Default constructor.
     */
    public TraverseMaze(){

    }

    /**
     * getter method for the maze symbol array.
     * @return returning mazesymbol.
     */
    public char[][] getMazeSymbols() { //getter method
        return mazeSymbols;
    }

    /**
     * setting the character array full of hash tags.
     * @param mazeSymbols is a passed array to fill.
     */
    public void setMazesymbols(char[][] mazeSymbols) { // setter method that creates a 6 by six maze with #
        this.mazeSymbols = mazeSymbols;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mazeSymbols[i][j] = '#';
            }
        }
    }

    /**
     * Method straightHorizontal will create a path straight through the maze.
     * @param mazesymbols will return the fully formed maze.
     */
    public void straightHorizontal(char[][] mazesymbols) { //Creates the path for the maze
        for (int i = 0; i < 6; i++) { //embedded for loop to print to console. (starting will a smaller maze to build up to.)
            for (int j = 0; j < 6; j++) {
                System.out.print(mazesymbols[i][j] + "\t");
            }
            System.out.println();
            mazesymbols[2][0] = '.';
            mazesymbols[2][1] = '.';
            mazesymbols[2][2] = '.';
            mazesymbols[2][3] = '.';
            mazesymbols[2][4] = '.';
            mazesymbols[2][5] = '.';
            mazesymbols[2][6] = '.';  //This will just create a line
            // making it a simple right traversal with no back tracking.
        }
        System.out.println();
    }

    /**
     * Method straightVertical will create a path straight through the maze.
     * @param mazesymbols will return the fully formed maze.
     */
    public void straightVertical(char[][] mazesymbols){ //method will create path for maze.
        for (int i = 0; i < 6; i++) { //embedded for loop to print to console. (starting will a smaller maze to build up to.)
            for (int j = 0; j < 6; j++) {
                System.out.print(mazesymbols[i][j] + "\t");
            }
            System.out.println();
            mazesymbols[0][2] = '.';
            mazesymbols[1][2] = '.';
            mazesymbols[2][2] = '.';
            mazesymbols[3][2] = '.';
            mazesymbols[4][2] = '.';
            mazesymbols[5][2] = '.';
            mazesymbols[6][2] = '.';  //This will just create a vertical line
            // making it a simple right traversal with no back tracking.
        }
        System.out.println();
    }

    /**
     * Method traverseStaighthorizontal will be used to traverse through the horizontal path.
     * @param fixed start point of the maze.
     * @param traversing start point of the maze.
     * @param mazesymbols passing the array with the path.
     */
    public void traverseStraighthotizontal(int fixed, int traversing, char[][] mazesymbols) { //this method is called to traverse horizontal maze.
        //This is a small demo maze to sample movement to the right.
        if (fixed < 6 && mazesymbols[fixed][traversing + 1] == '.') { //recursive control structure that will show progression through the maze
            mazesymbols[fixed][traversing] = 'x'; // replacing character with an 'x'.
            for (int i = 0; i < 6; i++) { // prints out progression
                for (int j = 0; j < 6; j++) {
                    System.out.print(mazesymbols[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            traverseStraighthotizontal(fixed, traversing + 1, mazesymbols); //recalling the method.
        }
    }

    /**
     * Method traverseStraightvertical will be used to traverse through the vertical path.
     * @param moving start point of the maze.
     * @param position start point of the maze.
     * @param mazesymbols passing the array with the path.
     */
    public void traverseStraightvertical(int moving, int position, char[][] mazesymbols){ //method called to traverse vertical
        //This is a small demo maze to sample movement downward.
        if(position < 6 && mazesymbols[moving + 1][position] == '.'){ //recursive control structure that will show progression through the maze.
            mazesymbols[moving][position] = 'x'; //replace characters with an 'x'.
            for (int i = 0; i < 6; i++) { // prints out progression
                for (int j = 0; j < 6; j++) {
                    System.out.print(mazesymbols[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            traverseStraightvertical(moving+ 1,position, mazesymbols); //recalling the method.
        }
    }

}