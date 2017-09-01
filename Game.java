import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.animation.Animation;
import java.util.Random;
import java.util.ArrayList;
import javafx.scene.shape.Shape;

import javafx.scene.text.Text;
import javafx.scene.paint.*;

import java.util.Random;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends Application 
{
    // instance variables - replace the example below with your own
    private static final int ANCHO_ESCENA = 500;
    private static final int ALTO_ESCENA = 500;
    private static final int ALTO_BARRA_SUPERIOR = 10;
    
    public static final int NUMERO_DINOSAURIOS = 6;
    public static final int NUMERO_HUMANO = 5;
    public static final int NUMERO_HUMANA = 8;
    
    private static double shipXSpeed;
    private static double shipYSpeed;
    
    private static int shipsNumber;
    private static int dinosauriosShipsNumber;
    private static int humanoShipsNumber;
    private static int humanaShipsNumber;
    
    public ArrayList<Poblacion> ships;

     public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage escenario)
    {
         //Obtenemos el numero total de poblacion
        shipsNumber = NUMERO_DINOSAURIOS + NUMERO_HUMANO + NUMERO_HUMANA;
        //obtener numero dinosaurios
        dinosauriosShipsNumber = NUMERO_DINOSAURIOS;
        //obtener numero humanos
        humanoShipsNumber = NUMERO_HUMANO;
        //obtener numero humanas
        humanaShipsNumber = NUMERO_HUMANA;
        
        Group contenedor = new Group();
        Scene escena = new Scene(contenedor, ANCHO_ESCENA, ALTO_ESCENA); 
        //creamos Poblacion
        ships = new ArrayList<>();
        Random randomPosition = new Random();
        int numberOfShipsAdded = 0;
        for(int i = 0; i < shipsNumber; i++)
        {

            for(int dinosaurioNuevo = 0; dinosaurioNuevo < NUMERO_DINOSAURIOS; dinosaurioNuevo++)
            {
                Dinosaurio dinosaurio = new Dinosaurio(Raza.DINOSAURIO,0,0);
                ships.add(dinosaurio);
            }

            for(int humanoNuevo = 0; humanoNuevo < NUMERO_HUMANO; humanoNuevo++)
            {
                Humano humano = new Humano(Raza.HUMANO,0);
                ships.add(humano);                
            }

            for(int humanaNueva = 0; humanaNueva < NUMERO_HUMANA; humanaNueva++)
            {
                Humana humana = new Humana(Raza.HUMANA,0);
                ships.add(humana);                
            }
            boolean shipAdded = false;

            while(!shipAdded)
            {
                int shipXPosition = randomPosition.nextInt(ANCHO_ESCENA - 50);
                int shipYPosition = randomPosition.nextInt(ALTO_ESCENA - 20 - ALTO_BARRA_SUPERIOR);

                Text ship = new Text();
                ship.setX(shipXPosition);
                ship.setY(shipYPosition);
                
                if (ships.get(i).getRaza().equals("dinosaurio"))
                {
                    ship.setFill(Color.RED);
                }
                if (ships.get(i).getRaza().equals("humano"))
                {
                    ship.setFill(Color.BLUE);
                }
                if (ships.get(i).getRaza().equals("humana"))
                {
                    ship.setFill(Color.PINK);
                }
                contenedor.getChildren().add(ship);
                numberOfShipsAdded++;
                shipAdded = true;
            }
        }
        escenario.setScene(escena);
        escenario.show();
        Timeline timeline = new Timeline();
        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.01), event -> 
                {

                    //DesplazamIENTO POBLACION
                    for(int i = 0; i < shipsNumber; i++)
                    {
                        ships.get(i).mover();
                    }
                }
            );
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();    
    }
}
