import java.io.*;
import java.util.*;
import java.lang.Math;

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
          
          double[] U = new double[i];

          if (i == 0) {
               System.exit(0);
          }else{


                  for(int jj = 0; jj < i; jj++){
                        String dinput = ReadLn (255);
                        StringTokenizer ddata = new StringTokenizer (dinput);
                        double d = Double.parseDouble (ddata.nextToken());
                         
                         U[jj] = d;
                        
                  }          
                  double a = getAvgSumForPerson(U, i);
                        double b = getDelta(U, i, a);
                        System.out.println("$" + b);
            }
        }    

	}

	public static double getAvgSumForPerson(double[] M, int n) {
        double[] D = new double[n];
        D = M;
        double S = 0;
        for(int i = 0;i < n; i ++){
              S += D[i];
        }
        double avg = (double)(Math.round(((double)S/n)*100))/100;
            return avg;	    
	}

    public static double getDelta(double[] M, int n, double avg){
        double[] D = new double[n];
        D = M;
        double p_dlt_s = 0;
        double n_dlt_s = 0;
        for(int i = 0;i < n; i ++){
              if (D[i] < avg){
                  n_dlt_s += (avg - D[i]);
              }else{
                  p_dlt_s += (D[i]-avg);
              }
        }


        
        if((n_dlt_s < 0.01)||(p_dlt_s < 0.01)){
            return (double)(0.01);
        }

        if(n_dlt_s<p_dlt_s){
            return (double)(Math.round(n_dlt_s*100))/100;
        }else{
            return (double)(Math.round(p_dlt_s*100))/100;
        }


           // 
    }

	
}