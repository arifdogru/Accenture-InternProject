import java.util.HashMap;

/**
 * Created by Arif on 20.05.2017.
 */
public class DeleteOccurence {

    public static String solution(int deletesNum, String input){

        HashMap<Character,Integer> occurence = new HashMap<Character, Integer>();
        String result = "";
        for (int i=0; i<input.length(); ++i){
            if(input.charAt(i) != ' '){
                if(occurence.get(input.charAt(i)) != null){
                    occurence.put(input.charAt(i),occurence.get(input.charAt(i))+1);
                }
                else {
                    occurence.put(input.charAt(i),1);
                }
            }
        }

        for(HashMap.Entry<Character, Integer> entry : occurence.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if (value >= deletesNum){
                input = helper(input,key);
            }
        }
        return input;
    }

    /**
     *  Helper for delete character in string
     * @param str given input
     * @param ch deleted character
     * @return result string
     */
    public static String helper(String str, Character ch){
        StringBuilder temp = new StringBuilder(str);
        for (int i=0; i<temp.length(); ++i){
            if(temp.charAt(i) == ch ){
                temp.deleteCharAt(i);
                --i;
            }
        }
        return temp.toString();
    }

    public static void main(String [] args){

        System.out.println("****Test Cases****");
        System.out.println("input: aaba kouq bux - 2");
        System.out.println("result1: "+solution(2,"aaba kouq bux"));
        System.out.println("input: aaba kouq bux - 3");
        System.out.println("result2: "+solution(3,"aaba kouq bux"));
        System.out.println("input: aaba kouq bux - 4");
        System.out.println("result3: "+solution(4,"aaba kouq bux"));

    }


}
