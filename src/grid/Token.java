package grid;

import player.Player;

/**
 * Correspond au Symbole X ou O
 */
public class Token {

    // FIELDS
    private char tokenChar;
    private Player owner;

    //CONSTRUCTOR
    public Token(char c, Player player){
        this.tokenChar = c;
        this.owner = player;


    }

    // GETTERS / SETTERS

    public Player getOwner() {
        return this.owner;
    }



    //METHODS

    @Override
    public String toString(){
        return Character.toString(this.tokenChar);
    }
}
