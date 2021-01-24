package com.pelletier.connectfour;

public class Board {
    private int[][] array2d;
    private boolean win;

    public Board (int length, int height){
        this.array2d = new int[height][length];
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
        for(int i = 1; i < array2d.length; i++){
            if((array2d[i][indexOfColumn-1] != 0)){
                if(team == 1){
                    array2d[i-1][indexOfColumn-1]=1;
                }else{
                    array2d[i-1][indexOfColumn-1]=8;
                }
                break;
            }else if(i+1 == array2d.length){
                if(team == 1) {
                    array2d[i][indexOfColumn-1]=1;
                }else{
                    array2d[i][indexOfColumn-1]=8;
                }
            }
        }
    }
    public boolean checkWin(){
        return (checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin() || checkBackwardsDiagonalWin());
    }
    //Each check win method will search through the 2d array and look at a certain "Window" of values and compare them to see if 4 "connect"
    public boolean checkHorizontalWin(){
        for(int i = 0; i < array2d.length; i++) {
            for (int j = 0; j <= array2d.length-3; j++) {
                if (array2d[i][j] != 0) {
                    if ((array2d[i][j] == array2d[i][j + 1]) && (array2d[i][j + 1] == array2d[i][j + 2]) && (array2d[i][j + 2] == array2d[i][j + 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkVerticalWin(){
        for(int j = 0; j < array2d.length; j++) {
            for (int i = 0; i <= array2d.length-4;  i++) {
                if (array2d[i][j] != 0) {
                    if((array2d[i][j] == array2d[i+1][j]) && (array2d[i][j] == array2d[i+2][j]) && (array2d[i][j] == array2d[i+3][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean checkDiagonalWin(){
        for(int i = 0; i < array2d.length-4; i ++){
            for(int j = 0; j < array2d[i].length-4; j++){
                if(array2d[j][i] != 0){
                    if((array2d[j][i] == array2d[j+1][i+1]) && (array2d[j+1][i+1] == array2d[j+2][i+2]) && (array2d[j+2][i+2] == array2d[j+3][i+3])){
                        return true;
                    }
                }
            }
        }return false;
    }

    public boolean checkBackwardsDiagonalWin(){
        for(int i = 3; i < array2d[0].length; i++) {
            for(int j = 0; j < array2d.length-3; j++){
                if(array2d[j][i] != 0){
                    if((array2d[j][i] == array2d[j + 1][i - 1]) && (array2d[j + 1][i - 1] == array2d[j + 2][i - 2]) && (array2d[j + 2][i - 2] == array2d[j + 3][i - 3])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}