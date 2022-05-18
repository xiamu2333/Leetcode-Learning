import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String dislikeStr = sc.nextLine();
        Pattern p = Pattern.compile("\\d\\D\\d");
        Matcher m = p.matcher(dislikeStr);
        System.out.println(m);

    }
}
