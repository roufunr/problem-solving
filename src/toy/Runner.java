package toy;

public class Runner {
    public static void main(String[] args) {
        String[][] data = {
                {"Name", "Description", "JobID", "Age"},
                {"Rouf", "Live in the moment", "121645", "27"},
                {"Rason", "Crazy inhuman problem solver", "654321", "34"},
                {"Yeamin", "Most funniest person in the world", "098765", "23"}
        };
        DBTablePrinter dbTablePrinter = new DBTablePrinter(data);
        dbTablePrinter.printTable();

    }
}


