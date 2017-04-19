package grid;

import player.Player;


public class GridCase {


    // FIELDS
    private int id;
    private Token content;

    //CONSTRUCTOR
    public GridCase(int caseId){
        this.id = caseId ;
        this.content = null;
    }

    //SURCHARGE CONSTRUCTOR
    public GridCase(int caseId, Token token){
        this.id = caseId ;
        this.content = token;
    }




    // GETTERS / SETTERS

    public void setToken(Token token){
        this.content = token;
    }

    public Player getTokenOwner(){
        if(this.content != null)
            return this.content.getOwner();
        else
            return null;
    }

    //METHODS


    public boolean isEmpty(){
        return this.content == null;
    }

    @Override
    public String toString(){
        if(this.content != null){
            //Type Objet donc .toString
            return this.content.toString();
        }else{
            //Type primitive donc Integer.toString()
            return Integer.toString(this.id);
        }
    }

}
