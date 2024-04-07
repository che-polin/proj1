import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public enum Player {
        COMPUTER,
        USER,
        INITAL;
    }

    public enum Cell {
        CROSS('Х'),
        ZERO('0'),
        EMPTY('.');
        private char value;

        Cell(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }


    public static void main(String[] args) {
        Random random = new Random();

        int fieldSize = 3;

        Cell[][] field;
        Player activePlayer, winner = Player.INITAL;
        Scanner scanner = new Scanner(System.in);
        boolean isPlay = true;


        field = new Cell[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = Cell.EMPTY;
            }
        }

        if (random.nextBoolean()) { //кто сейчас играет
            activePlayer = Player.COMPUTER;
        } else {
            activePlayer = Player.USER;
        }

        while (isPlay) {
            if (activePlayer == Player.COMPUTER) {
                int iCell = random.nextInt(fieldSize);
                int jCell = random.nextInt(fieldSize);

                if (field[iCell][jCell] == Cell.EMPTY) {
                    field[iCell][jCell] = Cell.CROSS;
                    activePlayer = Player.USER;
                } else if (field[iCell][jCell] == Cell.CROSS) {
                    activePlayer = Player.COMPUTER;
                } else if (field[iCell][jCell] == Cell.ZERO) {
                    activePlayer = Player.COMPUTER;
                }
            } else {
                int iCell = random.nextInt(fieldSize);
                int jCell = random.nextInt(fieldSize);

                if (field[iCell][jCell] == Cell.EMPTY) {
                    field[iCell][jCell] = Cell.ZERO;
                    activePlayer = Player.COMPUTER;
                } else if (field[iCell][jCell] == Cell.ZERO) {
                    activePlayer = Player.USER;
                } else if (field[iCell][jCell] == Cell.CROSS) {
                    activePlayer = Player.USER;
                }
            }

            if (winner == Player.INITAL){
                for (int i = 0; i < fieldSize; i++) {

                    if ((field[i][0] == Cell.CROSS) && (field[i][1] == Cell.CROSS) && (field[i][2] == Cell.CROSS)) {
                        winner = Player.COMPUTER;
                    } else if ((field[0][i] == Cell.CROSS) && (field[1][i] == Cell.CROSS) && (field[2][i] == Cell.CROSS)) {
                        winner = Player.COMPUTER;
                    } else if ((field[i][0] == Cell.ZERO) && (field[i][1] == Cell.ZERO) && (field[i][2] == Cell.ZERO)) {
                        winner = Player.USER;
                    } else if ((field[0][i] == Cell.ZERO) && (field[1][i] == Cell.ZERO) && (field[2][i] == Cell.ZERO)) {
                        winner = Player.USER;

                    }


                }
                System.out.println("Победил: " + winner);
            }


        }
    }
}