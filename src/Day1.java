import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        List<Integer> caloriesList = new ArrayList<>();
        int sumCal = 0;
        int maxCal = 0;

        try {
            File myObj = new File("inputs/day1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputList.add(data);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < inputList.size(); i++){
            if (!inputList.get(i).isBlank()){
                sumCal = sumCal + Integer.parseInt(inputList.get(i));
            }else{
                caloriesList.add(sumCal);
                if (sumCal > maxCal){
                    maxCal = sumCal;
                }
                sumCal = 0;
            }
        }

        Collections.sort(caloriesList);
        Collections.reverse(caloriesList);
        System.out.println(caloriesList.get(0) + caloriesList.get(1) + caloriesList.get(2));
        System.out.println(maxCal);

    }

}
