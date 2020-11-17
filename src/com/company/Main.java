package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player p1 = new Player(1);
        p1.setName();
        Player p2 = new Player(2);
        p2.setName();

        TicTacToe t = new TicTacToe(p1, p2);
        t.play();
    }
}
