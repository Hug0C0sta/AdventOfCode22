import java.io.File;
import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        List<Character> caracteres = new ArrayList<>();

        List<Integer> number_moves = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        List<Integer> destination = new ArrayList<>();

        Set<Integer> positions = new HashSet<>();
        HashMap<Integer, Integer> mapPositions = new HashMap<>();
        int keyMapPosition = 1;
        HashMap<Integer, Stack<Character>> mapStacks = new HashMap<>();
        String result = "";


        for (char c = 'A'; c <= 'Z'; c++) {
            caracteres.add(c);
        }

        try {
            File myObj = new File("inputs/day5.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int i = 0; i < data.length(); i++) {
                    if (caracteres.contains(data.charAt(i))) {
                        Stack<Character> value = new Stack<>();
                        if (mapStacks.containsKey(i)) {
                            value = mapStacks.get(i);
                            value.add(data.charAt(i));
                            mapStacks.put(i, value);
                        } else {
                            value.add(data.charAt(i));
                            mapStacks.put(i, value);
                        }
                        positions.add(i);
                    }
                }

                if (data.contains("move")) {
                    String[] first_split = data.split("from");
                    number_moves.add(Integer.valueOf(first_split[0].replace("move ", "").trim()));
                    String[] second_split = first_split[1].split("to");

                    start.add(Integer.valueOf(second_split[0].trim()));
                    destination.add(Integer.valueOf(second_split[1].trim()));
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        TreeSet myTreeSet = new TreeSet(positions);

        for (Iterator<Integer> it = myTreeSet.iterator(); it.hasNext(); ) {
            Integer f = it.next();
            mapPositions.put(keyMapPosition, f);
            keyMapPosition++;
        }

        for (int i = 0; i < number_moves.size(); i++){
            for (int j = 0; j < number_moves.get(i); j++){

                //Stack<Character> stack_start = mapStacks.get(mapPositions.get(start.get(i)));
                //Stack<Character> stack_destination = mapStacks.get(mapPositions.get(destination.get(i)));

                Stack<Character> stack_start_pt2 = mapStacks.get(mapPositions.get(start.get(i)));
                Stack<Character> stack_destination_pt2 = mapStacks.get(mapPositions.get(destination.get(i)));

                stack_destination_pt2.add(0, stack_start_pt2.elementAt(number_moves.get(i) -j -1));
//                stack_destination.add(0, stack_start.firstElement());
//
//
//                if (!stack_start.isEmpty()){
//                    stack_start.remove(stack_start.firstElement());
//                }
                if (!stack_start_pt2.isEmpty()){
                    stack_start_pt2.remove(number_moves.get(i) -j -1);
                }
            }
        }

        TreeMap<Integer, Stack<Character>> sortedMapStack = new TreeMap<>(mapStacks);


        for (HashMap.Entry < Integer, Stack<Character> > entry: sortedMapStack.entrySet()) {
            Integer key = entry.getKey();
            Stack<Character> value = entry.getValue();
            result = result + value.firstElement();
        }
        System.out.println(result);
    }
}
