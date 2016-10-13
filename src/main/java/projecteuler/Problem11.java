package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Anand_Rajneesh on 8/9/2016.
 */
public class Problem11 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\projecteuler\\problem11input.txt"))){

            String tmp;
            int matrix [][] = new int[20][20];
            int i =0;
            while((tmp=br.readLine())!=null){
                String[] splits = tmp.split(" ");

                for(int k=0; k<splits.length; k++){
                    matrix[i][k] = Integer.parseInt(splits[k]);
                }
                i++;
            }


            int answer = 0;

            for(int x =0; x<20; x++){
                for(int y =0; y<20; y++){
                    //right
                    if(y+3<20){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x][y+1]*matrix[x][y+2]*matrix[x][y+3]));
                    }
                    //left
                    if(y-3>=0){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x][y-1]*matrix[x][y-2]*matrix[x][y-3]));
                    }
                    //up
                    if(x-3>=0){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x-1][y]*matrix[x-2][y]*matrix[x-3][y]));
                    }
                    //down
                    if(x+3<20){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x+1][y]*matrix[x+2][y]*matrix[x+3][y]));
                    }
                    //diagonally left up
                    if(x-3>=0 && y-3>=0){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x-1][y-1]*matrix[x-2][y-2]*matrix[x-3][y-3]));
                    }
                    //diagonally left down
                    if(x+3<20 && y-3>=0){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x+1][y-1]*matrix[x+2][y-2]*matrix[x+3][y-3]));
                    }
                    //diagonally right up
                    if(x-3>=0 && y+3<20){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x-1][y+1]*matrix[x-2][y+2]*matrix[x-3][y+3]));
                    }
                    //diagonally right down
                    if(x+3<20 && y+3<20){
                        answer = Math.max(answer, (matrix[x][y]*matrix[x+1][y+1]*matrix[x+2][y+2]*matrix[x+3][y+3]));
                    }
                }
            }
            System.out.println(answer);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
