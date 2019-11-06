import static java.lang.Integer.parseInt;
//http://codingdojo.org/kata/Minesweeper/
public class MineSweeper {

    public String sweep(String input) {

//        2 2..\n*.\n4 4\n*...\n...*\n....\n....\n0 0

        Field dimensions = getFieldDimension(input);
        String[][] field = new String[dimensions.getLines()][dimensions.getColumns()]; //should be part of the method building the array
        if (dimensions.getLines() == 0) return "Field #1:\n" + input;

        fillMyArray(input, dimensions, field);
        addBombWarnings(dimensions, field);

        return "Field #1:\n" + myArrayToString(dimensions, field);

    }


    public void fillMyArray(String input, Field dimensions, String[][] field) {

        for (int row = 0; row < dimensions.getLines(); row++) {
            for (int col = 0; col < dimensions.getColumns(); col++) {
                if (input.split("\n")[row + 1].charAt(col) == '*') {
                    field[row][col] = "*";
                } else if (field[row][col] == null) field[row][col] = "0";
            }
        }
    }

    public void addBombWarnings(Field dimensions, String[][] field) {
        for (int row = 0; row < dimensions.getLines(); row++) {
            for (int col = 0; col < dimensions.getColumns(); col++) {
                if (field[row][col] == "*") {
                    flagAdjacentCells(dimensions, field, row, col);
                }
            }
        }
    }

    public void flagAdjacentCells(Field dimensions, String[][] field, int row, int col) {
        int x;
        int y;

        for (x = Math.max(0, row - 1); x <= Math.min(row + 1, dimensions.getLines()); x++) {
            for (y = Math.max(0, col - 1); y <= Math.min(col + 1, dimensions.getColumns()); y++) {
                if (x >= 0 && y >= 0 && x < dimensions.getLines() && y < dimensions.getColumns()) {
                    if (!field[x][y].equals("*") && (x != row || y != col))
                        field[x][y] = Integer.toString(parseInt(field[x][y])+1);
                }
            }
        }
    }


    public String myArrayToString(Field dimensions, String[][] field) {
        String game = "";
        for (int row = 0; row < dimensions.getLines(); row++) {
            for (int col = 0; col < dimensions.getColumns(); col++) {
                game += field[row][col];
            }
            game += "\n";
        }
        return game;

    }

    public Field getFieldDimension(String input) {
        String[] lines = input.split("\n");
        String size = lines[0];
        Field dimension = new Field(1, Integer.parseInt(size.split(" ")[0]), Integer.parseInt(size.split(" ")[1]));
        return dimension;
    }

    public class Field {
        private int lines;
        private int columns;
        private int fieldCounter;

        public Field(int fieldCounter, int lines, int columns) {
            this.fieldCounter = fieldCounter;
            this.lines = lines;
            this.columns = columns;
        }

        public int getLines() {
            return this.lines;
        }

        public int getColumns() {
            return this.columns;
        }

        public int getFieldCounter() {
            return this.fieldCounter;
        }
    }

}