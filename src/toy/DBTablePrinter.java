package toy;

public class DBTablePrinter {
    private String[][] data;
    private int rows;
    private int columns;
    private String hLine; //+-------+----------------------------------+-------+----+
    private int[] columnSizeArr;

    public DBTablePrinter(String[][] data) {
        this.rows = 0;
        this.columns = 0;

        if(data!=null) {
            this.rows = data.length; // how many one D array in two D array

            if(this.rows >= 1) { // corner case
                this.columns = data[0].length;
            }
            this.data = new String[this.rows][this.columns];
            this.copyData(data);
            this.setEachColumnSize();
            this.setHorizontalLine();
        }
    }
    private void copyData(String[][] data) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    private void setEachColumnSize() {
        int[] columnSizeArr = new int[columns];

        for(int j = 0; j < columns; j++) {
            int maxSize = Integer.MIN_VALUE;
            for(int i = 0; i < rows; i++) {
                if(maxSize < data[i][j].length()) {
                    maxSize = data[i][j].length();
                }
            }
            columnSizeArr[j] = maxSize + 1;
        }

        this.columnSizeArr = columnSizeArr;

    }

    private void setHorizontalLine() {
        String hLine = "";
        int[] columnSizeArr = this.columnSizeArr;
        //7 26 9 4
        for(int j = 0; j < columns; j++) {
            String hColumnLine = "+";
            for(int i = 0; i < columnSizeArr[j]; i++) {
                hColumnLine+="-";
            }
            hLine += hColumnLine;
        }
        hLine += "+";
        this.hLine = hLine;
    }

    public void printTable() {
        System.out.println(hLine);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                String element = this.data[i][j];
                int numberOfSpace = this.columnSizeArr[j] - element.length();
                System.out.print("|"+element);
                for(int k = 0; k < numberOfSpace; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println('|');
            System.out.println(hLine);
        }
    }
}

// |Name
// |Description
// |JobID
// |Age
// |
