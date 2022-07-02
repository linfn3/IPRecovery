import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RecoverIP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        List<String> ans = restoreIpAddresses(input);
        System.out.println(ans);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        int len = s.length();
        if(len <=3 || len >= 13){
            return ans;
        }

        dfs();
        return ans;
    }


}