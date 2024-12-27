import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
    public static final char[] gameGrid = new char[9];

    public TicTacToe () {
    }

    public void fillTheGameGrid(char[] grid) {
        Arrays.fill(grid, '_');
    }

    public int count(char ch, char[] grid) {
        int count = 0;
        for (char c : grid) {
            if (c == ch) count++;
        }
        return count;
    }

    public boolean playerDiagonalWin(char ch, char[] gameGrid) {
        return (gameGrid[0] == ch && gameGrid[4] == ch && gameGrid[8] == ch) ||
                (gameGrid[2] == ch && gameGrid[4] == ch && gameGrid[6] == ch);
    }

    public boolean playerWin(char ch, char[] gameGrid) {
        return playerRowWin(ch, gameGrid) || playerColWin(ch, gameGrid) || playerDiagonalWin(ch, gameGrid);
    }

    public boolean playerRowWin(char ch, char[] gameGrid) {
        return (gameGrid[0] == ch && gameGrid[1] == ch && gameGrid[2] == ch) ||
                (gameGrid[3] == ch && gameGrid[4] == ch && gameGrid[5] == ch) ||
                (gameGrid[6] == ch && gameGrid[7] == ch && gameGrid[8] == ch);
    }

    public boolean playerColWin(char ch, char[] gameGrid) {
        return (gameGrid[0] == ch && gameGrid[3] == ch && gameGrid[6] == ch) ||
                (gameGrid[1] == ch && gameGrid[4] == ch && gameGrid[7] == ch) ||
                (gameGrid[2] == ch && gameGrid[5] == ch && gameGrid[8] == ch);
    }

    public void printGameGrid(char[] grid) {
        System.out.println("---------");

        for (int i = 0; i < grid.length; i += 3) {
            System.out.println("| " + grid[i] + " " + grid[i + 1] + " " + grid[i + 2] + " |");
        }

        System.out.println("---------");
    }

    public void easyLevel(char[] grid, char playerTurn) {
        Random randomNum = new Random();
        int aiChoice;

        do {
            aiChoice = randomNum.nextInt(9);
        } while (grid[aiChoice] != '_');

        grid[aiChoice] = playerTurn;
    }

    public boolean mediumLevel(char[] grid, char playerTurn) {
        char opponent = playerTurn == '0' ? 'X' : '0'; // determine the opponent

        // check vertical columns
        for (int i = 0; i < 3; i++) {
            if (grid[i] == playerTurn && grid[i + 3] == playerTurn && grid[i + 6] == '_') {
                grid[i + 6] = playerTurn;
                return true;
            } else if (grid[i] == playerTurn && grid[i + 6] == playerTurn && grid[i + 3] == '_') {
                grid[i + 3] = playerTurn;
                return true;
            } else if (grid[i + 3] == playerTurn && grid[i + 6] == playerTurn && grid[i] == '_') {
                grid[i] = playerTurn;
                return true;
            }

        }

        // check horizontal rows
        for (int i = 0; i < 9; i += 3) {
            if (grid[i] == playerTurn && grid[i + 1] == playerTurn && grid[i + 2] == '_') {
                grid[i + 2] = playerTurn;
                return true;
            } else if (grid[i] == playerTurn && grid[i + 2] == playerTurn && grid[i + 1] == '_') {
                grid[i + 1] = playerTurn;
                return true;
            } else if (grid[i + 1] == playerTurn && grid[i + 2] == playerTurn && grid[i] == '_') {
                grid[i] = playerTurn;
                return true;
            }
        }

        if (grid[0] == playerTurn && grid[4] == playerTurn && grid[8] == '_') {
            grid[8] = playerTurn;
            return true;
        } else if (grid[0] == playerTurn && grid[8] == playerTurn && grid[4] == '_') {
            grid[4] = playerTurn;
            return true;
        } else if (grid[4] == playerTurn && grid[8] == playerTurn && grid[0] == '_') {
            grid[0] = playerTurn;
            return true;
        }

        if (grid[2] == playerTurn && grid[4] == playerTurn && grid[6] == '_') {
            grid[6] = playerTurn;
            return true;
        } else if (grid[2] == playerTurn && grid[6] == playerTurn && grid[4] == '_') {
            grid[4] = playerTurn;
            return true;
        } else if (grid[4] == playerTurn && grid[6] == playerTurn && grid[2] == '_') {
            grid[2] = playerTurn;
            return true;
        }



        // check blocking possibilities (block the opponent from winning)

        for (int i = 0; i < 3; i++) {
            if (grid[i] == opponent && grid[i + 3] == opponent && grid[i + 6] == '_') {
                grid[i + 6] = playerTurn;
                return true;
            } else if (grid[i] == opponent && grid[i + 6] == opponent && grid[i + 3] == '_') {
                grid[i + 3] = playerTurn;
                return true;
            } else if (grid[i + 3] == opponent && grid[i + 6] == opponent && grid[i] == '_') {
                grid[i] = playerTurn;
                return true;
            }

        }

        // check horizontal rows
        for (int i = 0; i < 9; i += 3) {
            if (grid[i] == opponent && grid[i + 1] == opponent && grid[i + 2] == '_') {
                grid[i + 2] = playerTurn;
                return true;
            } else if (grid[i] == opponent && grid[i + 2] == opponent && grid[i + 1] == '_') {
                grid[i + 1] = playerTurn;
                return true;
            } else if (grid[i + 1] == opponent && grid[i + 2] == opponent && grid[i] == '_') {
                grid[i] = playerTurn;
                return true;
            }
        }

        if (grid[0] == opponent && grid[4] == opponent && grid[8] == '_') {
            grid[8] = playerTurn;
            return true;
        } else if (grid[0] == opponent && grid[8] == opponent && grid[4] == '_') {
            grid[4] = playerTurn;
            return true;
        } else if (grid[4] == opponent && grid[8] == opponent && grid[0] == '_') {
            grid[0] = playerTurn;
            return true;
        }

        if (grid[2] == opponent && grid[4] == opponent && grid[6] == '_') {
            grid[6] = playerTurn;
            return true;
        } else if (grid[2] == opponent && grid[6] == opponent && grid[4] == '_') {
            grid[4] = playerTurn;
            return true;
        } else if (grid[4] == opponent && grid[6] == opponent && grid[2] == '_') {
            grid[2] = playerTurn;
            return true;
        }
        return false;
    }

    public int minimax(char playerTurn, char[] gameGrid) {
        if (isTerminal(gameGrid)) {
            return valOfTerminal(gameGrid);
        }

        char nextPlayer = playerTurn == 'X' ? '0' : 'X';
        int bestVal;

        if (playerTurn(gameGrid).equals("MAX")) {
             bestVal = Integer.MIN_VALUE;
            for (int num : actionsToTake(gameGrid)) {
                bestVal = Math.max(bestVal, minimax(nextPlayer, resultAfterAction(playerTurn, gameGrid, num)));
            }
        } else {
            bestVal = Integer.MAX_VALUE;
            for (int num : actionsToTake(gameGrid)) {
                bestVal = Math.min(bestVal, minimax(nextPlayer, resultAfterAction(playerTurn, gameGrid, num)));
            }
        }
        return bestVal;

    }

    public int hardLevel(char playerTurn, char[] gameGrid) {
        int bestValue = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int action : actionsToTake(gameGrid)) {
            char nextPlayer = (playerTurn == 'X') ? '0' : 'X';
            int value = minimax(nextPlayer, resultAfterAction(playerTurn, gameGrid, action));
            if (value > bestValue) {
                bestValue = value;
                bestMove = action;
            }
        }
        return bestMove;
    }

    public boolean isTerminal(char[] gameGrid) {
        return playerWin('X', gameGrid) || playerWin('0', gameGrid) || actionsToTake(gameGrid).isEmpty();
    }

    public int valOfTerminal(char[] gameGrid) {
        if (playerWin('X', gameGrid)) {
            return 1;
        } else if (playerWin('0', gameGrid)) {
            return -1;
        } else return 0;
    }

    public String playerTurn(char[] gameGrid) {
        int xCount = count('X', gameGrid);
        int oCount = count('0', gameGrid);

        if (xCount == oCount) {
            return "MAX";
        } else {
            return "MIN";
        }
    }

    public ArrayList<Integer> actionsToTake(char[] gameGrid) {
        ArrayList<Integer> emptySpots = new ArrayList<>();
        for (int i = 0; i < gameGrid.length; i++) {
            if (gameGrid[i] == '_') {
                emptySpots.add(i);
            }
        }
        return emptySpots;
    }

    public char[] resultAfterAction(char playerTurn, char[] gameGrid, int action) {
        char[] newGrid = gameGrid.clone();
        newGrid[action] = playerTurn;
        return newGrid;
    }
}
