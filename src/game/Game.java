package game;

import grid.Grid;
import io.Input;
import player.Player;

import java.util.Scanner;


public class Game {

    //FIELDS
    private Grid grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;


    //CONSTRUCTOR
    public Game(){
        this.grid = new Grid();
        this.player1 = new Player(0, 'O');
        this.player2 = new Player(1, 'X');

    }

    //PRIVATE METHODS
    private void swapTurn(){
        if(this.currentPlayer.equals(this.player1)){
            this.currentPlayer = this.player2;
        }else{
            this.currentPlayer = this.player1;
        }
    }

    //GETTERS / SETERS
    private int getUserInput(Scanner scan){

        int input = -1;

        while(true){
            System.out.print("Joueur '" + this.currentPlayer.getToken() + "', votre tour");
            input = Input.readInt(scan);
            if(0 <= input && input <= 8 ){
                break;
            }
        }
        return input;
    }


    //METHODS

    private void printGrid(){
        System.out.flush();
        System.out.println(this.grid);
    }

    public void start(){
        currentPlayer = this.player1;
        Scanner scan = new Scanner(System.in);
        while(true){
            printGrid();
            int input = getUserInput(scan);
            this.grid.setCaseToken(input, this.currentPlayer.getToken());

            if(this.grid.getWinner() != null){
                printGrid();
                System.out.print("Joueur '" + this.currentPlayer.getToken() + "' a gagner ");
                break;
            }else if (this.grid.isFull()){
                printGrid();
                System.out.print("Matche nul '" + this.currentPlayer.getToken() + "' , aucun gagnant ");
                break;
            }
            swapTurn();
        }
        scan.close();
    }


}
