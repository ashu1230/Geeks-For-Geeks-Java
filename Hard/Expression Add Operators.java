Given a string S that contains only digits (0-9) and an integer target, return all possible strings to insert the binary operator ' + ', ' - ', or ' * ' between the digits of S so that the resultant expression evaluates to the target value.

Note: Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine. It is allowed to not insert any of the operators.

Example 1:

Input:
S = "123"
target = 6
Output: { "1*2*3", "1+2+3"}
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:

Input:
S = "3456237490"
target = 9191
Output: { } 
Explanation: There are no expressions that can be created from "3456237490"  to evaluate to 9191.

Example 3:

Input:
S = "12"
target = 12
Output: { "12"} 
Explanation: S itself matches the target. No other strings are possible.
Your Task:
You don't need to read input or print anything. Your task is to complete the function addOperators() which takes string S and integer target as parameters and returns a list of strings that contains all valid possibilities.

Expected Time Complexity: O(|S|*4|S|)
Expected Auxiliary Space: O(|s|*3|S|)


#SOLUTION....

class Solution {

    public static void helper(ArrayList<String> ans, String res, String num, int target, int index, long val, long mul) {

        if(index == num.length()) {

            if(val == target) 

                ans.add(res);

                

            return;

        }

        

        for(int i =index; i < num.length(); i++) {

            if(i != index && num.charAt(index) == '0') break;

            long cur = Long.parseLong(num.substring(index, i + 1));

            if(index == 0) {

                helper(ans, res + cur, num, target, i + 1, cur, cur);

            } else {

                helper(ans, res + "+" + cur, num, target, i + 1, val + cur, cur);

                helper(ans, res + "-" + cur, num, target, i + 1, val - cur, -cur);

                helper(ans, res + "*" + cur, num, target, i + 1, val - mul + mul * cur, mul * cur);

            }

        }

    }

    public static ArrayList<String> addOperators(String S, int target) {

        // code here

        

        ArrayList<String> ans = new ArrayList<>();

        if(S.length() == 0 || S == null) return ans;

        helper(ans, "", S, target, 0, 0, 0);

        return ans;

    }

}

 
