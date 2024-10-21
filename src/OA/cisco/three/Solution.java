package OA.cisco.three;

public class Solution {
    public void  funcPrint(int numRow, int numColumn)
	{
		StringBuilder sb = new StringBuilder();
		char currentChar = '#';
		for(int i = 0; i < numRow; i++) {
			char beginChar = currentChar;
			for(int j = 0; j < numColumn; j++) {
				sb.append(currentChar);
				currentChar = currentChar == '#' ? '$' : '#';
			}
			currentChar = beginChar == '#' ? '$' : '#';
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
}
