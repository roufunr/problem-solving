package others.coding_bat;

public class XYBalanced {
    public boolean xyBalance(String str) {
        String x1 = null; // nulll string
        String x2 = ""; // empty string
        if(str == null || str.length() == 0) { // null or empty
            return true;
        }

        int lastXIdx = str.lastIndexOf('x');
        int lastYIdx = str.lastIndexOf('y');

        if(lastXIdx == -1 && lastYIdx == -1) { // x not && y not
            return true;
        } else if (lastXIdx == -1 && lastYIdx != -1) { // x not && y yes
            return true;
        } else if (lastXIdx != -1 && lastYIdx == -1) { // x yes && y not
            return false;
        } else { // x yes && y yes
            if(lastXIdx>lastYIdx) {
                return false;
            } else {
                return true;
            }
        }
    }
}
