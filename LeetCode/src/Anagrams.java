import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter two strings");

        String a = sc.nextLine();
        String b = sc.nextLine();

        String[] inputArray = {"cat","act","muki","tac","ikum","karthi"};

        if (findAnagramsWithoutSort(a,b) && findAnagramsWithSort(a,b)){
            System.out.println("Strings are anagrams");
        } else {
            System.out.println("Strings are not anagrams");
        }

        System.out.println(groupAnagramString(inputArray));

    }

    private static List<List<String>> groupAnagramString(String[] inputArray) {


        List<List<String>> output = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String value : inputArray) {
            char[] stringArray = value.toCharArray();
            Arrays.sort(stringArray);

            String sortedString = new String(stringArray);

            List<String> listValue;
            if (map.containsKey(sortedString)) {
                listValue = map.get(sortedString);
            } else {
                listValue = new LinkedList<>();
            }
            listValue.add(value);
            map.put(sortedString, listValue);

        }

        map.forEach((key, value) -> output.add(value));

        return output;

    }

    private static boolean findAnagramsWithSort(String firstString, String secondString) {

        char[] firstStringArray = firstString.toCharArray();
        char[] secondStringArray = secondString.toCharArray();

        Arrays.sort(firstStringArray);
        Arrays.sort(secondStringArray);

        return new String(firstStringArray).equals(new String(secondStringArray));
    }

    private static boolean findAnagramsWithoutSort(String firstString, String secondString) {
        char[] firstStringArray = firstString.toCharArray();
        char[] secondStringArray = secondString.toCharArray();

        Map<Character, Integer> firstStringMap = convertCharToMap(firstStringArray);
        Map<Character, Integer> secondStringMap = convertCharToMap(secondStringArray);

        for (char c : firstStringMap.keySet()) {
            if (!secondStringMap.containsKey(c) || !firstStringMap.get(c).equals(secondStringMap.get(c))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> convertCharToMap(char[] stringArray) {
        Map<Character, Integer> map = new HashMap<>();
        for (char character : stringArray) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return  map;
    }
}
