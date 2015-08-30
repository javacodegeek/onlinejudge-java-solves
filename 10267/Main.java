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
        StringTokenizer data;
        String cmd;
   
        char[][] Image = null;

          int m = 0; 
          int n = 0; 
          int x, y, x1, x2, y1, y2;
          char c;
          String name;

          while ((input = ReadLn (255)) != null){
          data = new StringTokenizer (input);
          cmd = data.nextToken();
          
          switch (cmd){
            case "I":
                     m = Integer.parseInt(data.nextToken());
                     n = Integer.parseInt(data.nextToken());
                     Image = cmd_I(m, n);
                     break;
            case "C":
                     cmd_C(Image, m, n);
                     break;
            case "L":
                     x = Integer.parseInt(data.nextToken());
                     y = Integer.parseInt(data.nextToken());
                     c = data.nextToken().charAt(0);
                     cmd_L(Image, x, y, c);
                     break;
            case "V":
                     x = Integer.parseInt(data.nextToken());
                     y1 = Integer.parseInt(data.nextToken());
                     y2 = Integer.parseInt(data.nextToken());
                     c = data.nextToken().charAt(0);
                     cmd_V(Image, x, y1, y2, c);
                     break;
            case "H":
                     x1 = Integer.parseInt(data.nextToken());
                     x2 = Integer.parseInt(data.nextToken());
                     y = Integer.parseInt(data.nextToken());
                     c = data.nextToken().charAt(0);
                     cmd_V(Image, x1, x2, y, c);
                     break;
            case "K":
                     x1 = Integer.parseInt(data.nextToken());
                     x2 = Integer.parseInt(data.nextToken());
                     y1 = Integer.parseInt(data.nextToken());
                     y2 = Integer.parseInt(data.nextToken());
                     c = data.nextToken().charAt(0);
                     cmd_K(Image, x1, x2, y1, y2, c);
                     break; 
            case "F":
                     x = Integer.parseInt(data.nextToken());
                     y = Integer.parseInt(data.nextToken());
                     c = data.nextToken().charAt(0);
                     cmd_F(Image, x, y, c, m, n);
                     isSetColorXY = false;
                     break;
            case "S":
                     name = data.nextToken();
                     cmd_S(name);
                     printImg(Image, m, n);
                     break;
            case "X":
                     cmd_X();
                     break;
            default:
                       break;                 
          }
          
        }

	}

	public static char[][] cmd_I(int M, int N){
    char[][] Img = new char[N+1][M+1];

    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= M; j++){
        Img[i][j] = 'O';
      }
    }
      return Img;
  }

  public static char[][] cmd_C(char[][] Img, int M, int N){
    for(int i = 1; i <= N; i++){
      for(int j = 1;j <= M; j++){
        Img[i][j] = 'O';
      }
    }
      return Img;
  }

  public static char[][] cmd_L(char[][] Img, int X, int Y, char C){
    
        Img[Y][X] = C;
     
      return Img;
  }

  public static char[][] cmd_V(char[][] Img, int X, int Y1, int Y2, char C){
    
        for(int i = Y1; i<= Y2; i++) {
          Img[i][X] = C;
        }
     
      return Img;
  }

  public static char[][] cmd_H(char[][] Img, int X1, int X2, int Y, char C){
    
        for(int j = X1; j<= X2; j++) {
          Img[Y][j] = C;
        }
     
      return Img;
  }

  public static char[][] cmd_K(char[][] Img, int X1, int X2, int Y1, int Y2, char C){
    
        for(int i = X1; i<= X2; i++) {
          for(int j = Y1; j<= Y2; j++){
            Img[j][i] = C;  
          }
        }
     
      return Img;
  }

  public  static boolean isSetColorXY = false;
  public  static char colorXY = 'O';

  public static void cmd_F(char[][] Img, int X, int Y, char C, int M, int N){ 
      
        if (isSetColorXY == false){
               colorXY = Img[Y][X];
               if (colorXY == C) {
                  return;
               }
               isSetColorXY = true;
        }

             
        if((X < 1)||(X > M)||(Y < 1)||(Y > N)||(Img[Y][X] != colorXY)||(Img[Y][X] == C)){
          return;
        }

            Img[Y][X] = C;

        
            cmd_F(Img, X, Y + 1, C, M, N);
            cmd_F(Img, X, Y - 1, C, M, N);
            cmd_F(Img, X - 1 , Y, C, M, N);
            cmd_F(Img, X + 1, Y, C, M, N);
        
            
        
  }

  public static void cmd_S(String name){
    
        System.out.println(name);
     
      return;
  }

  public static void cmd_X(){
    
        System.exit(0);
     
      return;
  }

  public static void printImg(char[][] Img, int M, int N){
    for(int i = 1; i <= N; i++){
      for(int j = 1;j <= M; j++){
        System.out.print(Img[i][j]);
      }
      System.out.println();
    }
    return;
  }
  
  



}