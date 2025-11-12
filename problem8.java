public class problem8 {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)){
          return -1;
        }
        else{
          return haystack.indexOf(needle);}
    }

    public static void main(String[] args) {
        problem8 ob = new problem8();
        System.out.println(solution.strStr("sadbutsad", "sad"));   // Output: 0
        System.out.println(solution.strStr("leetcode", "leeto"));  // Output: -1
    }
}
