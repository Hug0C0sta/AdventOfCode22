import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {
        String input = "";
        List<Character> charactersList = new ArrayList<>();
        int result = 0;

        try {
            File myObj = new File("inputs/day6.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                input = myReader.nextLine();
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < input.length(); i++){
            if (i >= 3){
                charactersList.clear();
                int count = 0;

                while (count <= 3){
                    charactersList.add(input.charAt(i - count));
                    count++;
                }

                if (charactersList.size() == new HashSet<>(charactersList).size()){
                    result = i + 1;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
