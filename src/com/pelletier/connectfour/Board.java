package com.pelletier.connectfour;

public class Board {
    private int[][] array2d;
    private int height;
    public Board (int length, int height){
        this.array2d = new int[height][length];
        this.height = height;
    }

    public void printBoard(){
        for(int i = 0; i < array2d.length; i++){
            for(int j = 0; j < array2d[i].length; j++){
                System.out.print(array2d[i][j]);
            }
            System.out.println("");
        }
    }

    public void placePiece(int team, int indexOfColumn){
        //this code needs to loop through and find whether or not the space beneath the current index is filled.
        //It will take a "team" to know which "color piece" to place, and the index of which column chosen
        for(int i = 0; i <= height; i++){
            if((array2d[i][indexOfColumn] != 0) || i == height){
                if(team == 1){
                    array2d[i-1][indexOfColumn]=1;
                }else{
                    array2d[i-1][indexOfColumn]=8;
                }
            }
        }
    }

    //public boolean checkWin(){return true;}


}
