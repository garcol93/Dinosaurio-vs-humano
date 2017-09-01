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
import javafx.scene.shape.Rectangle;

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
    
    private static double bichoXSpeed;
    private static double bichoYSpeed;
    
    private static int bichosNumber;
    private static int dinosaurioBichosNumber;
    private static int humanoBichosNumber;
    private static int humanaBichosNumber;
    
    public ArrayList<Poblacion> bichos;

     public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage escenario)
    {
         //Obtenemos el numero total de poblacion
        bichosNumber = NUMERO_DINOSAURIOS + NUMERO_HUMANO + NUMERO_HUMANA;
        //obtener numero dinosaurios
        dinosaurioBichosNumber = NUMERO_DINOSAURIOS;
        //obtener numero humanos
        humanoBichosNumber = NUMERO_HUMANO;
        //obtener numero humanas
        humanaBichosNumber = NUMERO_HUMANA;
        
        Group contenedor = new Group();
        Scene escena = new Scene(contenedor, ANCHO_ESCENA, ALTO_ESCENA); 
        //creamos Poblacion
        bichos = new ArrayList<>();
        Random randomPosition = new Random();
        int numberOfBichosAdded = 0;
        for(int i = 0; i < bichosNumber; i++)
        {

            for(int dinosaurioNuevo = 0; dinosaurioNuevo < NUMERO_DINOSAURIOS; dinosaurioNuevo++)
            {
                Dinosaurio dinosaurio = new Dinosaurio(Raza.DINOSAURIO,0,0);
                bichos.add(dinosaurio);
            }

            for(int humanoNuevo = 0; humanoNuevo < NUMERO_HUMANO; humanoNuevo++)
            {
                Humano humano = new Humano(Raza.HUMANO,0);
                bichos.add(humano);                
            }

            for(int humanaNueva = 0; humanaNueva < NUMERO_HUMANA; humanaNueva++)
            {
                Humana humana = new Humana(Raza.HUMANA,0);
                bichos.add(humana);                
            }
            boolean bichoAdded = false;

            while(!bichoAdded)
            {
                int bichoXPosition = randomPosition.nextInt(ANCHO_ESCENA - 50);
                int bichoYPosition = randomPosition.nextInt(ALTO_ESCENA - 20 - ALTO_BARRA_SUPERIOR);

                Text bicho = new Text();
                bicho.setX(bichoXPosition);
                bicho.setY(bichoYPosition);
                bicho.setText(bichos.get(numberOfBichosAdded).getBichoName());
                if (bichos.get(i).getRaza().equals("dinosaurio"))
                {
                    bicho.setFill(Color.RED);
                }
                if (bichos.get(i).getRaza().equals("humano"))
                {
                    bicho.setFill(Color.BLUE);
                }
                if (bichos.get(i).getRaza().equals("humana"))
                {
                    bicho.setFill(Color.GREEN);
                }
                contenedor.getChildren().add(bicho);
                numberOfBichosAdded++;
                bichoAdded = true;
            }
        }
        escenario.setScene(escena);
        escenario.show();
        Timeline timeline = new Timeline();
        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.01), event -> 
                {

                    //Desplazamiento POBLACION
                    for(int i = 0; i < bichosNumber; i++)
                    {
                        bichos.get(i).mover();
                    }
                }
            );
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();    
    }
}
