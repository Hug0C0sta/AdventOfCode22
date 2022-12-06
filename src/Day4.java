import java.io.File;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        int result = 0;
        int result2 = 0;
        int total_lines = 0;

        try {
            File myObj = new File("inputs/day4.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] splitted = data.split(",");

                String[] elf1 = splitted[0].split("-");
                String[] elf2 = splitted[1].split("-");

                int elf1_start = Integer.parseInt(elf1[0]);
                int elf1_end = Integer.parseInt(elf1[1]);
                int elf2_start = Integer.parseInt(elf2[0]);
                int elf2_end = Integer.parseInt(elf2[1]);

                if (elf1_start <= elf2_start && elf1_end >= elf2_end){
                    result++;
                }else if (elf1_start >= elf2_start && elf1_end <= elf2_end){
                    result++;
                }

                if (elf1_start > elf2_end){
                    result2++;
                }else if (elf2_start > elf1_end){
                    result2++;
                }

                total_lines++;
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(result);
        System.out.println(total_lines - result2);
    }
}
