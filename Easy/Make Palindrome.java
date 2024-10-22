You are given an array of strings arr of size n. You have to find out if it is possible to make a palindromic string by concatenating the strings in any order. Provided that all the strings given in the array are of equal length.

Example 1:

Input:
n = 4
arr = {"djfh", "gadt", "hfjd", "tdag"}
Output:
YES
Explanation:
You can make the string "djfhgadttdaghfjd", by concatenating the given strings which is a palindrome.
Example 2:

Input:
n = 3
arr = {"jhjdf", "sftas", "fgsdf"}
Output:
NO
Explanation:
You can't make a palindromic string with this strings.
Your Task:
You don't need to read input or print anything. Your task is to complete the function makePalindrome() which takes an integer n and an array of strings arr respectively and returns true or false.

Expected Time Complexity: O(n * len(arr[i]))
Expected Space Complexity: O(n * len(arr[i]))

Constraints:
1 <= n <= 10^4
0 <= |arr[i]| <= 10^4
The sum of n*|arr[i]| over all test cases won't exceed 10^6
  
  #Solution...
  class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
       
        String s;
        HashSet<String> hs = new HashSet<>();
        int palCount=0;                        // for palindrome Strings
        
       for(int i=0;i<n;i++){
            
            s= getRev(arr[i]);
            
            if(hs.contains(arr[i])){
                if(s.equals(arr[i]))  
                palCount--;
                hs.remove(arr[i]);
            }
            else{
                if(s.equals(arr[i]))  
                palCount++;
                hs.add(s);
            }
        }
        
        if(palCount>1) 
            return false;
        if(hs.size()>palCount) 
            return false;
            
        return true;
        
    }
    

    public static String getRev(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}       

