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
        int q;
        String s;

        while ((input = ReadLn (255)) != null){
          idata = new StringTokenizer (input);
          q = Integer.parseInt (idata.nextToken());
          s = idata.nextToken();
          if (q == 0){
            System.exit(0);
          }else{
            int K = s.length();
            int S = q;

             int a = S * 2 + 3;
             int b = S + 2;
             


             char[][] NumbersString = new char[a][b*K + K - 1];

             for(int i = 0; i<a; i++){
                for(int j = 0; j < (b*K + K - 1); j++){
                  NumbersString[i][j] = ' ';
                }
             }
             
             int d = 0;
             for (int j_temp = 0; j_temp < K; j_temp ++) {
                  int curNum = Character.getNumericValue(s.charAt(j_temp));
                  char[][] TN = drawNumber(curNum, S);
                  for(int i = 0; i < a; i++){
                    int p = 0; 
                    for(int j = j_temp*b+d; j < j_temp*b+d+b; j++){            
                        NumbersString[i][j] = TN[i][p];
                        p ++;
                    }
                  }
                  d++;             
             }

             for(int i = 0; i < a; i++){
                for(int j = 0; j < (b*K + K - 1); j++){
                  System.out.print(NumbersString[i][j]);
                }
                System.out.println();
             }
             System.out.println();
          }
        }


	}

	public static char[][] drawNumber(int n, int s){
        int a = 2*s + 3;
        int b = s + 2;

        char[][] Number = new char[a][b];
        
        for (int i = 0; i < a; i++){
          for (int j = 0; j < b; j++){
            Number[i][j] = ' ';
          }
        }

        if (n == 1){
          int j = b - 1; 
            for (int i = 0; i < a; i++){
              if ( (i != 0)&&(i != (a - 1) )&&(i != ((int)(a-1)/2)) ) {
                Number[i][j] = '|';  
              }
            }          
        }

        if (n == 2){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == 0)&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                  Number[i][j] = '-';
                                }
            }
          }       
        }

        if (n == 3){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                  Number[i][j] = '-';
                                }
            }
          }       
        }

        if (n == 4){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                Number[i][j] = '|';
              } else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                        Number[i][j] = '|';
                     } else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))){
                                Number[i][j] = '-';
                            } else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                          Number[i][j] = '|';
                                      }
            }
          }       
        }

        if (n == 5){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                  Number[i][j] = '-';
                                }
            }
          }       
        }

        if (n == 6){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                        Number[i][j] = '-';
                                      }else if ((j == 0)&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                              Number[i][j] = '|';
                                            }
            }
          }       
        }

        if (n == 7){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }
            }
          }       
        }

        if (n == 8){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                        Number[i][j] = '-';
                                      }else if ((j == 0)&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                              Number[i][j] = '|';
                                            } else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                                                        Number[i][j] = '|';
                                                   }
            }   
          }    
        }

        if (n == 9){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((i == ((int)(a-1)/2))&&(j != 0)&&(j != (b - 1))) {
                              Number[i][j] = '-';
                          }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                        Number[i][j] = '-';
                                      }else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                                                        Number[i][j] = '|';
                                                   }
            }   
          }    
        }


        if (n == 0){
          for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
              if ((i == 0)&&(j != 0)&&(j != (b - 1))){
                Number[i][j] = '-';  
              }else if ((j == 0)&&(i > 0)&&(i < ((int)(a-1)/2))){
                          Number[i][j] = '|';
                    }else if ((j == (b - 1))&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                  Number[i][j] = '|';
                                }else if ((i == (a - 1))&&(j != 0)&&(j != (b - 1))) {
                                        Number[i][j] = '-';
                                      }else if ((j == 0)&&(i < (a - 1))&&(i > ((int)(a-1)/2))){
                                              Number[i][j] = '|';
                                            } else if ((j == (b - 1))&&(i > 0)&&(i < ((int)(a-1)/2))){
                                                        Number[i][j] = '|';
                                                   }
            }   
          }    
        }

        /*System.out.println();
        for (int i = 0; i < a; i++){
          for (int j = 0; j < b; j++){
            System.out.print(Number[i][j]);
          }
          System.out.println();
        }*/
          return Number;

  }
        
   
    
}