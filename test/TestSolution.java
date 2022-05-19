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
            String temp = m.group();
            Integer[] tempgruop = new Integer[2];
            tempgruop[0] = Integer.parseInt(temp.charAt(0)+"");
            tempgruop[1] = Integer.parseInt(temp.charAt(2)+"");
            integers.add(tempgruop);
        }

        int numDislike = integers.size();
        int[][] dislikes = new int[numDislike][2];
        for (int i = 0; i < numDislike; i++) {
            dislikes[i] = Arrays.stream(integers.get(i)).mapToInt(Integer::valueOf).toArray();
        }

        Solution_886 solution = new Solution_886();
        System.out.println(solution.possibleBipartition(n, dislikes));


    }
}
