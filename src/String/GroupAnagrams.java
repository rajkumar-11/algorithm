package String;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        // Driver program
        String arr[] = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(arr);
    }

    private static void groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        List<List<String>> result = new ArrayList<List<String>>();


        for (int i = 0; i < arr.length; i++)
        {
            char[] charr = arr[i].toCharArray();
            Arrays.sort(charr);
           // System.out.println(charr);
            String tempString = new String(charr);
            System.out.println(tempString.toString());
            if (map.get(tempString) != null) {
                map.get(tempString).add(arr[i]);
                System.out.println("here");
            } else {
                List<String> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(tempString, list);

            }

        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getValue().toString());
        }


    }


}
