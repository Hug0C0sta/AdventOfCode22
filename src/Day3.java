import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        int result = 0;
        int result_ex2 = 0;
        int index = 1;
        HashMap< Integer, Character > priorities = new HashMap < Integer, Character > ();
        ArrayList< Character > character_from_one_line = new ArrayList < Character > ();
        ArrayList < String > tree_strings = new ArrayList < String > ();
        ArrayList < Character > character_from_tree_lines = new ArrayList < Character > ();

        for (char c = 'a'; c <= 'z'; c++) {
            priorities.put(index, c);
            index = index + 1;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            priorities.put(index, c);
            index = index + 1;
        }

        try {
            File myObj = new File("inputs/day3.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                final int mid = data.length() / 2; //get the middle of the String
                String[] parts = {
                        data.substring(0, mid),
                        data.substring(mid)
                };

                for (int i = 0; i < parts[0].length(); i++) {
                    for (int j = 0; j < parts[1].length(); j++) {
                        if (parts[0].charAt(i) == parts[1].charAt(j) && !character_from_one_line.contains(parts[0].charAt(i))) {
                            character_from_one_line.add(parts[0].charAt(i));
                        }
                    }
                }

                for (HashMap.Entry < Integer, Character > entry: priorities.entrySet()) {
                    Integer key = entry.getKey();
                    Character value = entry.getValue();
                    if (character_from_one_line.contains(value)) {
                        result = result + key;
                    }
                }

                character_from_one_line.clear();

                if (tree_strings.size() < 3) {
                    tree_strings.add(data);
                }

                if (tree_strings.size() == 3) {
                    String string1 = tree_strings.get(0);
                    String string2 = tree_strings.get(1);
                    String string3 = tree_strings.get(2);

                    for (int i = 0; i < string1.length(); i++) {
                        for (int j = 0; j < string2.length(); j++) {
                            for (int z = 0; z < string3.length(); z++) {
                                if (string1.charAt(i) == string2.charAt(j)) {
                                    if (string3.charAt(z) == string2.charAt(j)) {
                                        character_from_tree_lines.add(string3.charAt(z));
                                    }
                                }
                            }
                        }

                    }

                    for (HashMap.Entry < Integer, Character > entry: priorities.entrySet()) {
                        Integer key = entry.getKey();
                        Character value = entry.getValue();
                        if (character_from_tree_lines.contains(value)) {
                            result_ex2 = result_ex2 + key;
                        }
                    }

                    character_from_tree_lines.clear();
                    tree_strings.clear();
                }

            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(result);
        System.out.println(result_ex2);
    }
}
