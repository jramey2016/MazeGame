import java.util.Scanner;

/**
 * Class Maze Creation will hold the main method
 * @author Jordan Ramey
 */
public class MazeCreation {
    /**
     * main method will make objects from class TraverseMaze and class BackTrackingTraversal depending on user input.
     *
     */
    public static void main(String[] args) {
        char[][] symbolArray = new char[8][8]; //for test
        char[][] exampleArray = new char[12][12]; // 12* 12 array

        Scanner chooseMaze = new Scanner(System.in); //instantiate scanner object

        System.out.println("1.) Simple Horizontal maze"); //prompt for user
        System.out.println("2.) Simple vertical maze");
        System.out.println("3.) Maze Example (12 x 12)");
        System.out.println("4.) My Maze Example (12 x 12)");

        String input = chooseMaze.nextLine(); //user chooses which maze.

        if(input.equals("1")) {

            TraverseMaze createMaze = new TraverseMaze(); //Creating object from MazeCreation
            createMaze.setMazesymbols(symbolArray); //set # symbols
            createMaze.straightHorizontal(createMaze.getMazeSymbols());  //add in the '.'
            createMaze.traverseStraighthotizontal(2, 0, createMaze.getMazeSymbols()); //Give starting condition and call class method.

        }else if(input.equals("2")){

            TraverseMaze createMaze2 = new TraverseMaze(); //Create object from MazeCreation
            createMaze2.setMazesymbols(symbolArray); //set symbols
            createMaze2.straightVertical(createMaze2.getMazeSymbols()); //add in the path
            createMaze2.traverseStraightvertical(0,2,createMaze2.getMazeSymbols()); //pass coordinate and array for vertical path

        } else if(input.equals("3")){

            BackTrackingTraversal createExample = new BackTrackingTraversal(); //create object from BackTrakingTraversal Class.
            createExample.setMazeexample(exampleArray); //set symbols
            createExample.outlineExample(createExample.getMazeExample()); //add path
            int yCord = createExample.startCordinate(createExample.getMazeExample()); //starting coordinate.
            createExample.traverseMaze(yCord, 0, createExample.getMazeExample()); //send coordinate and array

        }else if(input.equals("4")){

            BackTrackingTraversal createExample2 = new BackTrackingTraversal(); // create object from BackTrakingTraversal class.
            createExample2.setMazeexample(exampleArray); //set symbols
            createExample2.outlineExample2(createExample2.getMazeExample()); //set the path
            int yCord = createExample2.startCordinate(createExample2.getMazeExample()); //starting coordinate
            createExample2.traverseMaze(yCord,0,createExample2.getMazeExample()); //send coordinate and array

        }
    }

}
