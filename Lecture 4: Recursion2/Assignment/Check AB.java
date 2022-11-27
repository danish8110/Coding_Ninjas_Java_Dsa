/**
Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
    a. The string begins with an 'a'
    b. Each 'a' is followed by nothing or an 'a' or "bb"
    c. Each "bb" is followed by nothing or an 'a'
  If all the rules are followed by the given string, return true otherwise return false.
    Input format :
        String S
    Output format :
        'true' or 'false'
    Constraints :
        1 <= |S| <= 1000
  where |S| represents length of string S.
    Sample Input 1 :
        abb
    Sample Output 1 :
        true
    Sample Input 2 :
        abababa
    Sample Output 2 :
        false
Explanation for Sample Input 2
In the above example, a is not followed by either "a" or "bb", instead it's followed by "b" which results in false to be returned.
**/

public class Solution {

	public static boolean checkAB(String input) {
		// Write your code here
         boolean smallAnswer = false;
        if (input.length() == 0) {
            return true;
        }
        if (input.length() == 1) {
            if (input.charAt(0) == 'a') {
                smallAnswer = true;
                input = input.substring(1);
            }
        } else if (input.length() == 2) {
            if (input.charAt(0) == 'a' && input.charAt(1) == 'a') {
                smallAnswer = true;
                input = input.substring(2);
            }
        } else if (input.length() >= 3) {
            if (input.charAt(0) == 'a' && input.substring(1, 3).equals("bb")) {
                smallAnswer = true;
                input = input.substring(3);
            } else if (input.charAt(0) == 'a' && input.charAt(1) == 'a') {
                smallAnswer = true;
                input = input.substring(1);
            }
        }
        return smallAnswer && checkAB(input);

	}
}
