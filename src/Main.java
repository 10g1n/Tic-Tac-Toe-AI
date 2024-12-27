import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe newGame = new TicTacToe();

        newGame.fillTheGameGrid(TicTacToe.gameGrid);

        newGame.printGameGrid(TicTacToe.gameGrid);

        char playerTurn;
        
        while (true) {
            playerTurn = 'X';

            System.out.print("Input command (start/exit): > ");

            String command = scanner.nextLine();
            String[] commandArr = command.split(" ");

            if (commandArr[0].equals("exit")) break;

            if (!checkCommandInput(commandArr)) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (commandArr[1].equals("user") && commandArr[2].equals("user")) {
                while (true) {
                    System.out.print("Enter the coordinates: > ");

                    String coordinates = scanner.nextLine().trim(); // user's coordinates
                    String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                    // transforms the coordinates into integers
                    int coordX = Integer.parseInt(coordinatesArr[0]);
                    int coordY = Integer.parseInt(coordinatesArr[1]);

                    // calculates the exact coordinate
                    int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                    if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                    // the users coordinate is always X
                    TicTacToe.gameGrid[exactCoord] = playerTurn;

                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';

                    newGame.printGameGrid(TicTacToe.gameGrid);
                }
            } else if (commandArr[1].equals("user") && commandArr[2].equals("easy")) {
                while (true) {

                    if (playerTurn == 'X') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        newGame.easyLevel(TicTacToe.gameGrid, playerTurn);
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    // checks the win/lose situation
                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("easy") && commandArr[2].equals("user")) {
                while (true) {

                    if (playerTurn == '0') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        newGame.easyLevel(TicTacToe.gameGrid, playerTurn);
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("easy") && commandArr[2].equals("easy")) {
                while (true) {

                    newGame.easyLevel(TicTacToe.gameGrid, playerTurn);

                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';

                    newGame.printGameGrid(TicTacToe.gameGrid);
                }
            } else if (commandArr[1].equals("user") && commandArr[2].equals("medium")) {
                while (true) {
                    if (playerTurn == 'X') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        if (!newGame.mediumLevel(TicTacToe.gameGrid, playerTurn)) { // if the AI finds a blocking or winning move it makes it, else it makes a random move
                            newGame.easyLevel(TicTacToe.gameGrid, playerTurn);
                        }
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    // checks the win/lose situation
                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("medium") && commandArr[2].equals("user")) {
                while (true) {
                    if (playerTurn == '0') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        if (!newGame.mediumLevel(TicTacToe.gameGrid, playerTurn)) { // if the AI finds a blocking or winning move it makes it, else it makes a random move
                            newGame.easyLevel(TicTacToe.gameGrid, playerTurn);
                        }
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    // checks the win/lose situation
                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("medium") && commandArr[2].equals("medium")) {
                while (true) {

                    if (!newGame.mediumLevel(TicTacToe.gameGrid, playerTurn)) { // if the AI finds a blocking or winning move it makes it, else it makes a random move
                        newGame.easyLevel(TicTacToe.gameGrid, playerTurn);
                    }
                    newGame.printGameGrid(TicTacToe.gameGrid);

                    // checks the win/lose situation
                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("user") && commandArr[2].equals("hard")) {
                while (true) {
                    if (playerTurn == 'X') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        TicTacToe.gameGrid[newGame.hardLevel(playerTurn, TicTacToe.gameGrid)] = playerTurn;
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    // checks the win/lose situation
                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("hard") && commandArr[2].equals("user")) {
                while (true) {
                    if (playerTurn == '0') {

                        System.out.print("Enter the coordinates: > ");

                        String coordinates = scanner.nextLine().trim(); // user's coordinates
                        String[] coordinatesArr = coordinates.split(" "); // coordinates transformed into a String array

                        // transforms the coordinates into integers
                        int coordX = Integer.parseInt(coordinatesArr[0]);
                        int coordY = Integer.parseInt(coordinatesArr[1]);

                        // calculates the exact coordinate
                        int exactCoord = (coordX - 1) * 3 + (coordY - 1);

                        if (checkCoordinates(coordinatesArr, TicTacToe.gameGrid, exactCoord)) continue;

                        // the users coordinate is always X
                        TicTacToe.gameGrid[exactCoord] = playerTurn;
                    } else {
                        TicTacToe.gameGrid[newGame.hardLevel(playerTurn, TicTacToe.gameGrid)] = playerTurn;
                        newGame.printGameGrid(TicTacToe.gameGrid);
                    }

                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            } else if (commandArr[1].equals("hard") && commandArr[2].equals("hard")) {
                while (true) {

                    TicTacToe.gameGrid[newGame.hardLevel(playerTurn, TicTacToe.gameGrid)] = playerTurn;
                    newGame.printGameGrid(TicTacToe.gameGrid);

                    if (checkGameStatus(newGame, TicTacToe.gameGrid)) break;

                    playerTurn = playerTurn == 'X' ? '0' : 'X';
                }
            }
        }
    }

    private static boolean isNumber(String val) {
        try {
            int integer = Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkCommandInput(String[] commands) {
        return commands.length == 3 &&
                !isNumber(commands[0]) &&
                !isNumber(commands[1]) &&
                !isNumber(commands[2]) &&
                (commands[0].equals("start") || commands[0].equals("exit")) &&
                (commands[1].equals("user") || commands[1].equals("easy") || commands[1].equals("medium") || commands[1].equals("hard")) &&
                (commands[2].equals("user") || commands[2].equals("easy") || commands[2].equals("medium") || commands[2].equals("hard"));
    }

    private static boolean checkGameStatus(TicTacToe game, char[] gameGrid) {
        boolean playerXWon = game.playerWin('X', gameGrid);
        boolean player0Won = game.playerWin('0', gameGrid);
        int numOfX = game.count('X', gameGrid);
        int numOf0 = game.count('0', gameGrid);

        if (playerXWon) {
            game.printGameGrid(gameGrid);
            System.out.println("X Won");
            game.fillTheGameGrid(gameGrid);
            return true;
        } else if (player0Won) {
            game.printGameGrid(gameGrid);
            System.out.println("0 Won");
            game.fillTheGameGrid(gameGrid);
            return true;
        } else if (numOfX + numOf0 == 9) {
            game.printGameGrid(gameGrid);
            System.out.println("Draw");
            game.fillTheGameGrid(gameGrid);
            return true;
        }
        return false;
    }

    private static boolean checkCoordinates(String[] coordinatesArr, char[] gameGrid, int exactCoord) {
        if (coordinatesArr.length != 2 || !Character.isDigit(coordinatesArr[0].charAt(0))
                || !Character.isDigit(coordinatesArr[1].charAt(0))) {
            System.out.println("Enter valid coordinates!");
            return true;
        }

        // transforms the coordinates into integers
        int coordX = Integer.parseInt(coordinatesArr[0]);
        int coordY = Integer.parseInt(coordinatesArr[1]);

        // check if the coordinates are within the range 1, 3
        if (coordX > 3 || coordY > 3 || coordX < 1 || coordY < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }

        // check if the cell is occupied
        if (gameGrid[exactCoord] == 'X' || gameGrid[exactCoord] == '0') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }
}
