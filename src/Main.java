import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static String longestRepeatedSubstring(String str) {
        int len = str.length();

        for (int i = (len / 2); i >= 1; i--)  {
            for (int j = 0; j < len && (j + i <= len); j++) {
                for (int k = j + i; (k < len) && (k + i <= len); k++) {
                    String subStr1 = str.substring(j, j + i).trim();
                    String subStr2 = str.substring(k, k + i).trim();

                    if (subStr1.equals(subStr2)){
                        return subStr1;
                    }               
                }
            }
        }
        return "";
    }

    public static boolean isWhitespace(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') return false;
        }
        return true;
    }

    /*Sample code to read in test cases: */
    public static void main (String[] args) {
    File file = new File(args[0]);
    try{
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split("\\n");
            if (lineArray.length > 0) {
                for (int i = 0; i < lineArray.length; i++) {
                    line = lineArray[i];
                    if (line.length() > 0) {
                        String longestRepeat = longestRepeatedSubstring(line);
                        if (longestRepeat.equals("")) {
                            System.out.println("NONE");
                        } else if (isWhitespace(longestRepeat)) {
                            System.out.println("NONE");
                        } else {
                            System.out.println(longestRepeat);
                        }
                    } else {  
                        System.out.println("NONE");
                    }
                }
            }
        }
    }
    catch(IOException ex){}
  }
}

class Towers{
    public static void main(String[] args) {
        int n = 5;

        doTowers(n, 'A', 'B', 'C');
    }

    public static void doTowers(int nDisks, char from, char inter, char to) {
        if (nDisks == 1) {
            System.out.println(nDisks + " from: " + from + " to: " + to);
            return;
        }
        doTowers(nDisks - 1, from, to, inter);
        System.out.println(nDisks  + " from: " + from + " to: " + to);
        doTowers(nDisks - 1, inter, from, to);
    }
 }


class Node{
    int data;
    Node next;

    public Node(int d) {
        data = d;
    }
}

class Stack{
    Node top;
    String name;

    void push(int d) {
        Node newTop = new Node(d);
        newTop.next = top;
        top = newTop;
    }

    void push(Node n) {
        n.next = top;
        top = n;
    }

    Node pop() {
        if (top != null) {
            Node t = top;
            top = top.next;
            return t;
        }
        return null;
    }

    int peek() {
        if (top != null) return top.data;
        else return 0;
    }

    void printContents() {
        String contents = this.name + ": ";

        Node ptr = top;
        while (ptr != null) {
            contents += ptr.data;
            contents += " ";
            ptr = ptr.next;
        }
        System.out.println(contents);
    }

}

class TowersOfHanoiStack {
    public static HashMap<String, Boolean> test() {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();

        map.put("a", true);
        map.put("b", true);
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, Boolean> map = test();

        String[] a = {"a", "b", "c"};

        if (map.get("c") == true) {
            System.out.println("yay");
        }
    }
 }

 class allSubsets{
    static ArrayList<String> subsets = new ArrayList<String>();

    public static void allSubsets(String s, String curSet) {
        int len = s.length();

        if (s.length() == 1) {
            subsets.add(curSet + "*");
            subsets.add(curSet + s);
            return;
        }

        allSubsets(s.substring(1), curSet + s.substring(0,1));
        allSubsets(s.substring(1), curSet + "*");
    }

    public static void main(String[] args) {
        String s = "abc";
        allSubsets(s, "");

        for (String str : subsets) {
            System.out.println(str);
        }
    }
 }

 class allPermutations {
    static ArrayList<String> permutations = new ArrayList<String>();

    public static String insert(String original, String insert, int i) {
        String left = original.substring(0, i);
        String right = original.substring(i);
        return left + insert + right;
    }

    public static void getPermutations(String s, String curString) {
        if (s.length() == 1) {
            for (int i = 0; i < curString.length() + 1; i++) {
                permutations.add(insert(curString, s, i));
            }
            return;
        }

        for (int i = 0; i < curString.length() + 1; i++) {
            String inserted = insert(curString, s.substring(0, 1), i);
            getPermutations(s.substring(1), inserted);
        }
    }

    public static void main(String[] args) {
        String set = "abcd";
        getPermutations(set, "");

        for (String str : permutations) {
            System.out.println(str);
        }
        System.out.println(permutations.size());
    }
 }

 class printParentheses {
    public static void printParentheses(int n) {
        if (n % 2 != 0) return;

        int nLeft = n/2;
        int nRight = n/2;

        String curParen = "(";
        printParentheses(curParen, nLeft - 1, nRight);
    }

    public static void printParentheses(String cur, int left, int right) {
        if (right < left) return;
        if (left == 0 && right == 0) {
            System.out.println(cur);
        }

        if (left > 0) {
            printParentheses(cur + "(", left - 1, right);
        }
        if (right > 0) {
            printParentheses(cur + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("owahefopewaufhwaeuhfupoaweouawefuaewhf this is sentence");
    }
 }