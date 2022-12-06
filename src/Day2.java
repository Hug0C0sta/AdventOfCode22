import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        char _rock = 'A';
        char _paper = 'B';
        char _scissors = 'C';
        char rock = 'X';
        char paper = 'Y';
        char scissors = 'Z';
        char result_win = 'Z';
        char result_draw = 'Y';
        char result_lose = 'X';
        int score = 0;
        int score2 = 0;

        try {
            File myObj = new File("inputs/day2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //se o adversário jogou pedra
                if (data.charAt(0) == _rock){
                    if (data.charAt(2) == rock){
                        score = score + 4;
                    }
                    if (data.charAt(2) == paper){
                        score = score + 8;
                    }
                    if (data.charAt(2) == scissors){
                        score = score + 3;
                    }
                }

                //se o adversário jogou papel
                if (data.charAt(0) == _paper){
                    if (data.charAt(2) == rock){
                        score = score + 1;
                    }
                    if (data.charAt(2) == paper){
                        score = score + 5;
                    }
                    if (data.charAt(2) == scissors){
                        score = score + 9;
                    }
                }

                //se o adversário jogou tesoura
                if (data.charAt(0) == _scissors){
                    if (data.charAt(2) == rock){
                        score = score + 7;
                    }
                    if (data.charAt(2) == paper){
                        score = score + 2;
                    }
                    if (data.charAt(2) == scissors){
                        score = score + 6;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("inputs/day2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                //se o adversário jogou pedra
                if (data.charAt(0) == _rock){
                    if (data.charAt(2) == result_win){
                        score2 = score2 + 8;
                    }
                    if (data.charAt(2) == result_draw){
                        score2 = score2 + 4;
                    }
                    if (data.charAt(2) == result_lose){
                        score2 = score2 + 3;
                    }
                }

                //se o adversário jogou papel
                if (data.charAt(0) == _paper){
                    if (data.charAt(2) == result_win){
                        score2 = score2 + 9;
                    }
                    if (data.charAt(2) == result_draw){
                        score2 = score2 + 5;
                    }
                    if (data.charAt(2) == result_lose){
                        score2 = score2 + 1;
                    }
                }

                //se o adversário jogou tesoura
                if (data.charAt(0) == _scissors){
                    if (data.charAt(2) == result_win){
                        score2 = score2 + 7;
                    }
                    if (data.charAt(2) == result_draw){
                        score2 = score2 + 6;
                    }
                    if (data.charAt(2) == result_lose){
                        score2 = score2 + 2;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("score: " + score);
        System.out.println("score2: " + score2);

    }
}
