package com.pelletier;
import java.util.Scanner;
import com.pelletier.connectfour.Board;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board myBoard = new Board(7,6);
        boolean win = false;
        int index;
        int turn=1;
        myBoard.printBoard();
        while(!win){
            if(turn%2 != 0){
                turn = 1;
            }else{
                turn = 2;
            }
            System.out.println("Enter index of column you want to place piece in! ");
            index = in.nextInt();
            myBoard.placePiece(turn, index);
            myBoard.printBoard();
            turn++;
            win = myBoard.checkVerticalWin();
        }
    }
}
