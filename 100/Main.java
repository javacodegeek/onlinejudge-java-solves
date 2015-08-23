import java.io.*;
import java.util.*;

class Main {
    static String ReadLn (int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";
        try{
            while (lg < maxLg){
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e){
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null); 
        return (new String (lin, 0, lg));
    }


	public static void main (String args[]) {
		String input;
        StringTokenizer idata;
        int i, j;

        while ((input = ReadLn (255)) != null){
          idata = new StringTokenizer (input);
          i = Integer.parseInt (idata.nextToken());
          j = Integer.parseInt (idata.nextToken());
          
          System.out.println (i + " " + j + " " + ((i>=j)?getMaxCountInRange(j, i):getMaxCountInRange(i, j)) );
        }

	}

	public static int getCountOfSequence(int n) {
        int cur_n = n;
        int count = 1;
		while (cur_n > 1) {
        	if (cur_n % 2 == 0){
        		cur_n = (int)(cur_n/2);
        	} else {
        	  		cur_n = cur_n*3 + 1;     
		      }
		    count++;  
		}
			return count;		
	}

	public static int getMaxCountInRange(int i, int j) {
		int maxCountRange = 0;
		int curMaxCountRange = -1;
		for(int k = i; k <= j; k++) {
			curMaxCountRange = getCountOfSequence(k);
			if (curMaxCountRange > maxCountRange) {
				maxCountRange = curMaxCountRange;
			}
		}
			return maxCountRange;	
	}
}