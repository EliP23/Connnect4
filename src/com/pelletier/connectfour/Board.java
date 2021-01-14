package com.pelletier.connectfour;

public class Board {
    private int[][] array2d;
    private int height;
    private boolean win;

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
        for(int i = 1; i < height; i++){
            if((array2d[i][indexOfColumn-1] != 0)){
                if(team == 1){
                    array2d[i-1][indexOfColumn-1]=1;
                }else{
                    array2d[i-1][indexOfColumn-1]=8;
                }
                break;
            }else if(i+1 == height){
                if(team == 1) {
                    array2d[i][indexOfColumn-1]=1;
                }else{
                    array2d[i][indexOfColumn-1]=8;
                }
            }
        }
    }

    //Will go through each index like "placePiece" method.
    //if selected piece and next 3 match, call win, else return false
    public boolean checkHorizontalWin(){
        for(int i = 0; i < array2d.length; i++) {
            for (int j = 0; j <= height - 3; j++) {
                if (array2d[i][j] != 0) {
                    if ((array2d[i][j] == array2d[i][j + 1]) && (array2d[i][j + 1] == array2d[i][j + 2]) && (array2d[i][j + 2] == array2d[i][j + 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


