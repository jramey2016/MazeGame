/**
 * Class BackTrackingTraversal is for traversing a maze similar to class TraverseMaze but the algorithm also allows for back tracking.
 */

public class BackTrack {
    /**
     * field mazeExample is a 12 * 12 character array for the maze.
     */
    private char[][] mazeExample = new char[12][12]; // private field for maze show on assignment page and my example

    /**
     * field for getting the starting point of the maze.
     */
    private int startCordinate; //private field for getting the start point.

    /**
     * Default constructor.
     */
    public BackTrackingTraversal(){ //constructor
    }

    /**
     * getter method for the maze symbol array.
     * @return returning mazesymbol.
     */
    public char[][] getMazeExample() { //getter method
        return mazeExample;
    }

    /**
     * setting the character array full of hash tags.
     * @param mazeExample is a passed array to fill.
     */
    public void setMazeexample(char[][] mazeExample){ //setter creates a 2 dimensional array 12 * 12 full of '#'
        this.mazeExample = mazeExample;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                mazeExample[i][j] = '#';
            }
        }
    }

    /**
     * Method outlineExample will create a the path shown in the problem statement.
     * @param mazeExample will return the fully formed maze.
     */
    public void outlineExample(char[][] mazeExample){ //fill in the path
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(mazeExample[i][j] + "\t");
            }
            System.out.println();
            mazeExample[1][1]='.';mazeExample[1][2]='.';mazeExample[1][3]='.'; mazeExample[1][5]='.';
            mazeExample[1][6]='.';mazeExample[1][7]='.';mazeExample[1][8]='.';mazeExample[1][9]='.';
            mazeExample[1][10]='.'; // changes specified places in row 1 to '.'.
            mazeExample[2][0]='.';mazeExample[2][1]='.';mazeExample[2][3]='.';mazeExample[2][5]='.';
            mazeExample[2][10]='.'; // row 2.
            mazeExample[3][3]='.';mazeExample[3][5]='.';mazeExample[3][6]='.';mazeExample[3][7]='.';
            mazeExample[3][8]='.';mazeExample[3][10]='.'; //row 3.
            mazeExample[4][1]='.';mazeExample[4][2]='.';mazeExample[4][3]='.';mazeExample[4][4]='.';
            mazeExample[4][8]='.';mazeExample[4][10]='.';mazeExample[4][11]='.'; //row 4.
            mazeExample[5][4]='.';mazeExample[5][6]='.';mazeExample[5][8]='.';mazeExample[5][10]='.';
            //row 5.
            mazeExample[6][1]='.';mazeExample[6][2]='.';mazeExample[6][4]='.';mazeExample[6][6]='.';
            mazeExample[6][8]='.';mazeExample[6][10]='.'; //row 6.
            mazeExample[7][2]='.';mazeExample[7][4]='.';mazeExample[7][6]='.';mazeExample[7][8]='.';
            mazeExample[7][10]='.'; //row 7.
            mazeExample[8][1]='.';mazeExample[8][2]='.';mazeExample[8][3]='.';mazeExample[8][4]='.';
            mazeExample[8][5]='.';mazeExample[8][6]='.';mazeExample[8][7]='.';mazeExample[8][8]='.';
            mazeExample[8][10]='.'; //row 8
            mazeExample[9][6]='.';mazeExample[9][10]='.'; // row 9
            mazeExample[10][1]='.';mazeExample[10][2]='.';mazeExample[10][3]='.';mazeExample[10][4]='.';
            mazeExample[10][5]='.';mazeExample[10][6]='.';mazeExample[10][8]='.';mazeExample[10][9]='.';
            mazeExample[10][10]='.';//row 10

        } //creating and outlining the maze.
        System.out.println();
    }

    /**
     * Method outlineExample2 will create a path that I had designed.
     * @param mazeexample will return my fully formed maze.
     */
    public void outlineExample2(char[][] mazeexample){ //fill in the path
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(mazeexample[i][j] + "\t");
            }
            System.out.println();
            //The following it creating the path through the maze
            mazeexample[1][2]='.';mazeexample[1][6]='.';mazeexample[1][7]='.';mazeexample[1][8]='.';mazeexample[1][9]='.';mazeexample[1][10]='.';
            mazeexample[1][11]='.'; //row 1.
            mazeexample[2][2]='.';mazeexample[2][9]='.'; //row 2.
            mazeexample[3][2]='.';mazeexample[3][9]='.';mazeexample[3][10]='.'; //row 3
            mazeexample[4][2]='.';mazeexample[4][3]='.';mazeexample[4][4]='.';mazeexample[4][5]='.';mazeexample[4][6]='.';
            mazeexample[4][7]='.';mazeexample[4][10]='.'; //row 4
            mazeexample[5][4]='.';mazeexample[5][10]='.';//row 5
            mazeexample[6][0]='.';mazeexample[6][1]='.';mazeexample[6][2]='.';mazeexample[6][3]='.';mazeexample[6][4]='.';
            mazeexample[6][8]='.';mazeexample[6][9]='.';mazeexample[6][10]='.'; //row 6
            mazeexample[7][4]='.';mazeexample[7][8]='.'; //row 7
            mazeexample[8][2]='.';mazeexample[8][4]='.';mazeexample[8][6]='.';mazeexample[8][7]='.';mazeexample[8][9]='.';
            mazeexample[8][5]='.';mazeexample[7][10]='.';mazeexample[8][8]='.'; //row 8
            mazeexample[9][2]='.';mazeexample[9][4]='.';//row 9.
            mazeexample[10][2]='.';mazeexample[10][3]='.';mazeexample[10][4]='.';
        }

    }

    /**
     * Method startCordinate will trace the left hand side of the maze to find the starting cordinate.
     * @param mazeexample is the maze with the path formed.
     * @return returns the starting point of the maze.
     */
    public int startCordinate(char[][]mazeexample){
        for(int i = 0; i < 11; i++){
            int holdValue = 0;
            if(mazeexample[i][holdValue] == '.'){ //Travels through the left edge of the maze to pinpoint the begging.
                mazeexample[i][holdValue] = 'x';
                startCordinate = i; //save it.
            }
        }
        return startCordinate; //return it
    }

    /**
     * Method traverseMaze will traverse the maze and be able to backtrack through the maze to find the shortest path.
     * @param y_axis the start point and used to look ahead at next character.
     * @param x_axis the start point and used to look ahead at nect character.
     * @param mazeexample the maze with the path formed to traverse.
     */
    public void traverseMaze(int y_axis,int x_axis, char[][] mazeexample) { //method for movement and backtracking
        for (int i = 0; i < 12; i++) { //print out progression
            for (int j = 0; j < 12; j++) {
                System.out.print(mazeexample[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        if (x_axis < 11 && mazeexample[y_axis][x_axis + 1] == '.') { //This control structure will be for right movement.
            mazeexample[y_axis][x_axis] = 'x'; //replace '.' with 'x'.
            traverseMaze(y_axis, x_axis + 1, mazeexample); //recall method
        }

        else if (x_axis > 0 && mazeexample[y_axis - 1][x_axis] == '.') { //This control structure will be for upwards movement
            mazeexample[y_axis][x_axis] = 'x'; //replace '.' with 'x'
            traverseMaze(y_axis - 1, x_axis, mazeexample); //recall method
        }

        else if (y_axis < 11 && mazeexample[y_axis + 1][x_axis] == '.') { //This control structure will be for downwards movement.
            mazeexample[y_axis][x_axis] = 'x';  //replace '.' with 'x'
            traverseMaze(y_axis + 1, x_axis, mazeexample); //recall method.
        }

        else if (y_axis > 1 && mazeexample[y_axis][x_axis - 1] == '.') {
            mazeexample[y_axis][x_axis] = 'x';  //replace '.' with 'x'
            traverseMaze(y_axis, x_axis - 1, mazeexample);
        }

        else if (x_axis == 11) { //end of the example maze.
            mazeexample[y_axis][x_axis] = 'x'; //place final marker
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (mazeexample[i][j] == '!') {
                        mazeexample[i][j] = '.'; //replace the exclamation marks with inital markings
                    }
                    System.out.print(mazeexample[i][j] + "\t"); //print out the final maze showing the traversal.
                }
                System.out.println();
            }
            System.out.println();
        }

        else { //will come to this if we are at a dead end and need to back track.

            if (mazeexample[y_axis][x_axis + 1] == 'x') { //back track right recursion
                mazeexample[y_axis][x_axis] = '!'; //replace with inital char;
                traverseMaze(y_axis, x_axis + 1, mazeexample);
            } //back track right
            else if (mazeexample[y_axis][x_axis - 1] == 'x') { // go back left
                mazeexample[y_axis][x_axis] = '!';
                traverseMaze(y_axis, x_axis - 1, mazeexample);
            } // back track left
            else if (mazeexample[y_axis + 1][x_axis] == 'x') { //back track down
                mazeexample[y_axis][x_axis] = '!';
                traverseMaze(y_axis + 1, x_axis, mazeexample);
            } //back track down
            else if (mazeexample[y_axis - 1][x_axis] == 'x') { //back track up
                mazeexample[y_axis][x_axis] = '!';
                traverseMaze(y_axis - 1, x_axis, mazeexample);
            } //back track up
        }
    }
}

