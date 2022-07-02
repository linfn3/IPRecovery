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

        if((len-cut) > (4-area)*3 || (len-cut) < (4-area)|| area > 4){ //若前方域的划分导致已不能最终划分为ip，则停止
            /*
            System.out.println(cut+" "+area+" ");
            System.out.println(temp);
            */
            return;
        }


        if(temp.length() - len == 4){
            temp = temp.substring(0,temp.length()-1);   //满足要求的一个ip地址插入ans
            ans.add(temp);
            return;
        }
        else if(area >= 4){
            return;     //ipv4顶多4层级
        }
        else{
            StringBuffer add_temp = new StringBuffer();
            for(int i = 1;i <= 3 && cut+i-1<len;i++){
                char tmp = s.charAt(cut+i-1);
                add_temp.append(tmp);
                if(add_temp.length()>=2 && add_temp.charAt(0)=='0'){    //前导0判断
                    return;
                }
                if(i == 3){
                    int num = Integer.parseInt(add_temp.toString());    //不能超过255
                    if(num > 255){
                        return;
                    }
                }
                dfs(s,temp+add_temp.toString()+'.', area+1,cut+i, len, ans);//递归回溯
            }
        }
    }

}