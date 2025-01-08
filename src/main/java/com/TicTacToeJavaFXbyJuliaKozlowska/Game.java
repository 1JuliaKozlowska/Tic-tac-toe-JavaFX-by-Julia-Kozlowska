package com.TicTacToeJavaFXbyJuliaKozlowska;

import javafx.util.Pair;

public class Game {
    public enum GameMode {
        VSPLAYER,
        VCCOMPUTER
    }
    public enum Turn {
        O,
        X,
        end
    }
    public enum GridField {
        empty,
        O,
        X
    }
    private GameMode gameMode;
    private Turn turn;
    private GridField gameGrid[][] = new GridField[3][3];
    public boolean isPlaying;
    public boolean draw;

    public void setGameMode(GameMode mode) {
        this.gameMode = mode;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameGrid[i][j] = GridField.empty;
            }
        }
        isPlaying = true;
        draw = false;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setTurn(Turn t){
        turn = t;
    }

    public GridField[][] getGameGrid(){
        return gameGrid;
    }

    public void nextTurn(int r, int c){

            if (turn == Turn.O){
                gameGrid[r][c] = GridField.O;
            }else if (turn == Turn.X){
                gameGrid[r][c] = GridField.X;
            }
            turn = checkGameAndReturnTurn();
            isPlaying = turn != Turn.end;



    }

    public void computerTurn(){
        int[] gridField = pcMove();
        nextTurn(gridField[0], gridField[1]);
    }

    public Turn getTurn(){
        return turn;
    }

    public boolean canPlace(int r, int c){
        return gameGrid[r][c] == GridField.empty;
    }

    private Turn checkGameAndReturnTurn(){
        if (gameGrid[0][0] == gameGrid[0][1] && gameGrid[0][1] == gameGrid[0][2] && gameGrid[0][0] != GridField.empty) {
            return Turn.end;
        }
        else if (gameGrid[1][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[1][2] && gameGrid[1][0] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[2][0] == gameGrid[2][1] && gameGrid[2][1] == gameGrid[2][2] && gameGrid[2][0] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[0][0] == gameGrid[1][0] && gameGrid[1][0] == gameGrid[2][0] && gameGrid[0][0] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[0][1] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][1] && gameGrid[0][1] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[0][2] == gameGrid[1][2] && gameGrid[1][2] == gameGrid[2][2] && gameGrid[0][2] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[0][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][2] && gameGrid[0][0] != GridField.empty)
        {
            return Turn.end;
        }
        else if (gameGrid[0][2] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][0] && gameGrid[0][2] != GridField.empty)
        {
            return Turn.end;
        } else if (gameGrid[0][0] != GridField.empty && gameGrid[0][1] != GridField.empty && gameGrid[0][2] != GridField.empty && gameGrid[1][0] != GridField.empty && gameGrid[1][1] != GridField.empty && gameGrid[1][2] != GridField.empty && gameGrid[2][0] != GridField.empty && gameGrid[2][1] != GridField.empty && gameGrid[2][2] != GridField.empty)
        {
            draw = true;
            return Turn.end;
        }

        if (getTurn() == Turn.O){
            return Turn.X;
        }
        else
        {
            return Turn.O;
        }
    }

    private int[] pcMove(){
        GridField[] row1 = new GridField[]{gameGrid[0][0], gameGrid[0][1], gameGrid[0][2]};
        GridField[] row2 = new GridField[]{gameGrid[1][0], gameGrid[1][1], gameGrid[1][2]};
        GridField[] row3 = new GridField[]{gameGrid[2][0], gameGrid[2][1], gameGrid[2][2]};
        GridField[] col1 = new GridField[]{gameGrid[0][0], gameGrid[1][0], gameGrid[2][0]};
        GridField[] col2 = new GridField[]{gameGrid[0][1], gameGrid[1][1], gameGrid[2][1]};
        GridField[] col3 = new GridField[]{gameGrid[0][2], gameGrid[1][2], gameGrid[2][2]};
        GridField[] slant1 = new GridField[]{gameGrid[0][0], gameGrid[1][1], gameGrid[2][2]};
        GridField[] slant2 = new GridField[]{gameGrid[2][0], gameGrid[1][1], gameGrid[0][2]};

        GridField[][] checker = new GridField[][]{row1, row2, row3, col1, col2, col3, slant1, slant2};
        System.out.println("1 check");
        int repetitions1 = 0;
        for (GridField[] check : checker){
            Pair<Integer, Integer> matchesAndMissingIndex = countFields(check, GridField.X);
            if (matchesAndMissingIndex.getKey() == 2 && isFieldPresent(check, GridField.empty)){
                switch (repetitions1){
                    case 0:
                        return new int[]{0,matchesAndMissingIndex.getValue()};
                    case 1:
                        return new int[]{1,matchesAndMissingIndex.getValue()};
                    case 2:
                        return new int[]{2,matchesAndMissingIndex.getValue()};
                    case 3:
                        return new int[]{matchesAndMissingIndex.getValue(), 0};
                    case 4:
                        return new int[]{matchesAndMissingIndex.getValue(), 1};
                    case 5:
                        return new int[]{matchesAndMissingIndex.getValue(), 2};
                    case 6:
                        return new int[]{matchesAndMissingIndex.getValue(), matchesAndMissingIndex.getValue()};
                    case 7:
                        switch (matchesAndMissingIndex.getValue()){
                            case 0:
                                return new int[]{2, 0};
                            case 1:
                                return new int[]{1, 1};
                            case 2:
                                return new int[]{0, 2};
                        }
                        break;
                }
            }
            repetitions1++;
        }
        System.out.println("2 check");
        int repetitions2 = 0;
        for (GridField[] check : checker){
            Pair<Integer, Integer> matchesAndMissingIndex = countFields(check, GridField.O);
            if (matchesAndMissingIndex.getKey() == 2 && isFieldPresent(check, GridField.empty)){
                switch (repetitions2){
                    case 0:
                        return new int[]{0,matchesAndMissingIndex.getValue()};
                    case 1:
                        return new int[]{1,matchesAndMissingIndex.getValue()};
                    case 2:
                        return new int[]{2,matchesAndMissingIndex.getValue()};
                    case 3:
                        return new int[]{matchesAndMissingIndex.getValue(), 0};
                    case 4:
                        return new int[]{matchesAndMissingIndex.getValue(), 1};
                    case 5:
                        return new int[]{matchesAndMissingIndex.getValue(), 2};
                    case 6:
                        return new int[]{matchesAndMissingIndex.getValue(), matchesAndMissingIndex.getValue()};
                    case 7:
                        switch (matchesAndMissingIndex.getValue()){
                            case 0:
                                return new int[]{2, 0};
                            case 1:
                                return new int[]{1, 1};
                            case 2:
                                return new int[]{0, 2};
                        }
                        break;
                }
            }
            repetitions2++;
        }
        System.out.println("3 check");
        int repetitions3 = 0;
        for (GridField[] check : checker){
            Pair<Integer, Integer> matchesAndMissingIndex = countFields(check, GridField.X);
            if (isFieldPresent(check, GridField.empty) && !isFieldPresent(check, GridField.O) && isFieldPresent(check, GridField.X)){
                switch (repetitions3){
                    case 0:
                        return new int[]{0,matchesAndMissingIndex.getValue()};
                    case 1:
                        return new int[]{1,matchesAndMissingIndex.getValue()};
                    case 2:
                        return new int[]{2,matchesAndMissingIndex.getValue()};
                    case 3:
                        return new int[]{matchesAndMissingIndex.getValue(), 0};
                    case 4:
                        return new int[]{matchesAndMissingIndex.getValue(), 1};
                    case 5:
                        return new int[]{matchesAndMissingIndex.getValue(), 2};
                    case 6:
                        return new int[]{matchesAndMissingIndex.getValue(), matchesAndMissingIndex.getValue()};
                    case 7:
                        switch (matchesAndMissingIndex.getValue()){
                            case 0:
                                return new int[]{2, 0};
                            case 1:
                                return new int[]{1, 1};
                            case 2:
                                return new int[]{0, 2};
                        }
                        break;
                }
            }
            repetitions3++;
        }
        System.out.println("4 check");
        int[][] middleAndCornersChoice = new int[][] {};
        if (countFields(slant1, GridField.empty).getKey() != 2 && gameGrid[1][1] != GridField.X)
        {
            middleAndCornersChoice = new int[][] { new int[] { 1, 1 }, new int[] { 0, 0 }};
        }
        else if (countFields(slant2, GridField.empty).getKey() != 2 && gameGrid[1][1] != GridField.X)
        {
            middleAndCornersChoice = new int[][] { new int[] { 0, 0 }, new int[] { 2, 2 } };
        }
        else if (gameGrid[1][1] == GridField.X && (!isFieldPresent(slant1, GridField.empty) || !isFieldPresent(slant2, GridField.empty) ))
        {
            middleAndCornersChoice = new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 2, 1 } };
        }

        for (int[] check : middleAndCornersChoice){
            if (this.gameGrid[check[0]][check[1]] == GridField.empty){
                return new int[]{check[0], check[1]};
            }
        }
        System.out.println("5 check");
        int[][] finalChoice = new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 1, 0 }, new int[] { 1, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 }, new int[] { 2, 1 }, new int[] { 2, 2 } };
        for (int[] check : finalChoice){
            if (this.gameGrid[check[0]][check[1]]  == GridField.empty){
                return new int[]{check[0], check[1]};
            }
        }

        return new int[]{1,1};
    }

    private Pair<Integer, Integer> countFields(GridField[] array, GridField type){
        int matches = 0;
        int missingIndex = -1;

        for (int i = 0; i < 3; i++) {
            if (array[i] == type)
            {
                matches++;
            }
            else
            {
                missingIndex = i;
            }

        }

        return new Pair<>(matches, missingIndex);
    }

    private boolean isFieldPresent(GridField[] array, GridField type){
        for (GridField f : array){
            if (f == type){
                return true;
            }
        }
        return false;
    }
}
