package h00;

import fopbot.Robot;
import fopbot.RobotFamily;
import fopbot.World;

import java.util.Random;
import java.util.random.RandomGenerator;

import static fopbot.Direction.LEFT;
import static fopbot.Direction.RIGHT;
import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // variable representing width/size of world
        final int worldSize = 5;

        // setting world size symmetrical, meaning height = width
        World.setSize(worldSize, worldSize);

        // speed of how fast the world gets refreshed (e.g. how fast the robot(s) act)
        // the lower the number, the faster the refresh
        World.setDelay(300);

        // make it possible to see the world window
        World.setVisible(true);

        // our program/assignment shall be tested/run !
        runExercise();
    }

    /**
     * Runs the exercise.
     */
    public static void runExercise() {
        Robot kaspar = new Robot(0, 0, LEFT, 20, RobotFamily.SQUARE_ORANGE);
        Robot alfred = new Robot(4, 4, RIGHT, 0, RobotFamily.SQUARE_BLUE);

        // AUFGABE H4.1 -----------------------------------
        // nach rechts gucken
        while(!kaspar.isFacingRight()){
            kaspar.turnLeft();
        }

        // Bewegung entlang der unteren Wand
        for(int i = 0; i<=World.getWidth()-2; i++){
            if(kaspar.hasAnyCoins())
                kaspar.putCoin();
            kaspar.move();
        }

        // nach oben sehen
        kaspar.turnLeft();

        // Bewegung entlang der rechten Wand
        for(int i = 0; i<=World.getHeight()-2; i++){
            if(kaspar.hasAnyCoins())
                kaspar.putCoin();
            kaspar.move();
        }

        // eine Münze legen und nach links gehen
        kaspar.turnLeft();
        if(kaspar.hasAnyCoins())
            kaspar.putCoin();
        kaspar.move();

        // AUFGABE H4.2 -----------------------------------

        // nach unten gucken
        while(!alfred.isFacingDown())
            alfred.turnLeft();

        // entlang der rechten Wand nach unten gehen und Münzen sammeln
        while(alfred.isFrontClear()){
            alfred.pickCoin();
            alfred.move();
        }

        // nach links schauen
        while(!alfred.isFacingLeft())
            alfred.turnLeft();

        // entlang der rechten Wand nach links gehen und Münzen sammeln
        while(alfred.isFrontClear()){
            alfred.pickCoin();
            alfred.move();
        }

        // nach oben schauen, Münze aufheben und einen Vorwärtschritt machen
        while(!alfred.isFacingUp())
            alfred.turnLeft();
        alfred.pickCoin();
        alfred.move();

        // Kaspar ist frech
        while(kaspar.hasAnyCoins()) {
            kaspar.putCoin();
            alfred.turnLeft();
        }
    }
}
