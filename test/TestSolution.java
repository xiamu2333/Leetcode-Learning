import com.leetcode.labuladong.Graph.Solution_886;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String dislikeStr = sc.nextLine();
        Pattern p = Pattern.compile("([0-9]+,+[0-9]+)");
        Matcher m = p.matcher(dislikeStr);
        LinkedList<Integer[]> integers = new LinkedList<>();
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
