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
        String strinput;
        StringTokenizer sdata;
        String s;


        char[][] L = new char[1000000][101];
        int count = 0;

        while ((input = ReadLn (255)) != null){
          idata = new StringTokenizer (input);
          i = Integer.parseInt (idata.nextToken());
          j = Integer.parseInt (idata.nextToken());
          if ((i == 0)&&(j == 0)){
             System.exit(0);
          }else{
             for(int v = 0; v < i; v++){
                strinput = ReadLn (255);
                sdata = new StringTokenizer (strinput);
                s = sdata.nextToken();
                  for(int u = 0; u < j; u++){
                     L[v][u] = s.charAt(u);
                  }
            }
            count++;
            if (count>1) System.out.println();
            System.out.println("Field #"+count+":");
            unMinesweepering(L, i-1, j-1);
          }


        }
        
        /*char[][] T = new char[][] { { '*', '.', '.', '.'},
                                                { '.', '.', '.', '.'},
                                                { '.', '*', '.', '.'},
                                                { '.', '.', '.', '.'}};
        

       
        unMinesweepering(T, 3, 3);*/

	}

	public static void unMinesweepering(char[][] F, int m, int n){
        int k,p;
       
        int[][] unM = new int[m+1][n+1];


        char[][] M = new char[m+1][n+1];

        M = F;

        /*for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++ ){
                 System.out.print(M[i][j]);
            }
            System.out.println();
        }      */


        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++ ){
                 if (M[i][j] == '*'){
                    unM[i][j] = -1;
                 }else{
                    unM[i][j] = 0;
                 }
            }           
        }

        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++ ){
                 if (unM[i][j] == -1){
                    k = i;     p = j + 1; //1
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }
                    k = i + 1; p = j + 1; //2
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1; 
                        }
                    k = i + 1; p = j;     //3
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }
                    k = i + 1; p = j - 1; //4
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1; 
                        }
                    k = i;     p = j - 1; //5

                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }                    
                    k = i - 1; p = j - 1; //6
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }
                    k = i - 1; p = j; //7
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }
                    k = i - 1; p = j + 1; //8
                        if ( (k >= 0)&&(p >= 0)&&(k <= m)&&(p <= n)&&(unM[k][p]) != -1){
                              unM[k][p] = unM[k][p] + 1;
                        }
                 }

            }
        }   

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++ ){

                if(unM[i][j] == -1){
                     System.out.print('*');
                }else{
                    System.out.print(unM[i][j]);
                }
            }
            System.out.println();
        }       
    }
}