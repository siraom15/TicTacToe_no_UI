package com.company;

import java.util.Scanner;

public class Player {
    private String name;
    private int playerNo;

    public Player(String name, int No) {
        this.name = name;
        this.playerNo = No;
    }

    public Player(int playerNo) {
        this.playerNo = playerNo;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input player "+playerNo+" name :");
        name = sc.nextLine();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNo=" + playerNo +
                '}';
    }
}