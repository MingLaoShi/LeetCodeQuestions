import java.util.ArrayList;
import java.util.List;

public class 面试题16_20_T9 {
    public static void main(String[] args){
        String num="8733";
        String[] words={"tree","used"};
        System.out.println(getValidT9Words(num,words));
    }
    public static List<String> getValidT9Words(String num, String[] words) {
        ArrayList<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            boolean b=true;
            for(int j=0;j<word.length();j++){
                char c=word.charAt(j);
                if(c<='o'&&c>='a'){
                    if((c-97)/3+50!=num.charAt(j)){
                        b=false;
                        break;
                    }
                }else if(c<='s'){
                    if(num.charAt(j)!='7'){
                        b=false;
                        break;
                    }
                }else if(c<='v'){
                    if(num.charAt(j)!='8'){
                        b=false;
                        break;
                    }
                }else{
                    if(num.charAt(j)!='9'){
                        b=false;
                        break;
                    }
                }
            }
            if(b){
                res.add(word);
            }
        }
        return res;

    }
}
