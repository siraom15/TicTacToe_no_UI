package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    private int[][] table;
    private Player turn;
    private Player player1;
    private Player player2;

    public TicTacToe(Player player1, Player player2) {
        table = new int[3][3];
        this.player1 = player1;
        this.player2 = player2;
        turn = player1;
    }

    public void showTable() {
        System.out.println("**********************");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 0) {
                    System.out.print("-");
                } else if (table[i][j] == 1) {
                    System.out.print("x");
                } else if (table[i][j] == 2) {
                    System.out.print("o");
                } else {
                    System.out.println("-");
                }
            }
            System.out.print("\n");
        }
        System.out.println("**********************");
    }

    public boolean isChecked(int row, int col) {
        return table[row][col] == 0;
    }

    public void check(Player p) {
        Scanner sc = new Scanner(System.in);
        int playerNo = p.getPlayerNo();
        int row, col;
        try {
            while (true) {
                row = sc.nextInt();
                col = sc.nextInt();
                boolean condition = (row <= 2 && col <= 2 && row >= 0 && col >= 0);
                if (condition) {
                    if (isChecked(row, col)) {
                        table[row][col] = playerNo;
                        break;
                    } else {
                        throw new Exception("This position already checked");
                    }
                } else {
                    throw new Exception("Input Value between 0-2 ");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Please Input Number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean canPlay() {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] != 0) {
                    sum++;
                }
            }
        }
        if (sum < 9) {
            return true;
        }
        return false;
    }

    public void changeTurn() {
        turn = switch (turn.getPlayerNo()) {
            case 1 -> player2;
            case 2 -> player1;
            default -> player1;
        };
    }

    public boolean checkWinner() {
        boolean checkWinner = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == table[i][1] && table[i][1] == table[i][2] && table[i][0] != 0) {
                checkWinner = true;
            } else if (table[0][i] == table[1][i] && table[1][i] == table[2][i] && table[0][i] != 0) {
                checkWinner = true;
            }
        }
        if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] != 0) {
            checkWinner = true;
        }
        if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && table[2][0] != 0) {
            checkWinner = true;
        }
        return checkWinner;
    }

    public void play() {
        while (canPlay()) {
            showTable();
            check(turn);
            if (checkWinner()) {
                showTable();
                System.out.println("We got winner ");
                System.out.println("Winner is " + turn.getName());
                break;
            }
            changeTurn();
        }
    }
}


