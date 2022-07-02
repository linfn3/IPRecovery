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
            return ans; //判断s是否可能构成ip
        }
        dfs(s, "", 0, 0,len,ans); //使用回溯法
        return ans;
    }
    public static void dfs(String s, String temp, int area, int cut, int len, List<String> ans){



        if(temp.length() - len == 4){
            temp = temp.substring(0,temp.length()-1);
            ans.add(temp);
            return;
        }
        else if(area >= 4){
            return;
        }
        else{
            StringBuffer add_temp = new StringBuffer();
            for(int i = 1;i <= 3 && cut+i-1<len;i++){
                char tmp = s.charAt(cut+i-1);
                add_temp.append(tmp);
                dfs(s,temp+add_temp.toString()+'.', area+1,cut+i, len, ans);
            }
        }
    }

}