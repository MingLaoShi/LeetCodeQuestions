import java.util.Arrays;

public class s27321移动机器人 {
    public static void main(String[] args){
        int[] nums={-2,0,2};
        String s="RLL";
        int d=3;
        Solution solution=new Solution();
        System.out.println(solution.sumDistance(nums, s, d));
    }
}
class Solution{
    public int sumDistance2(int[] nums,String s,int d){//超出时间限制
        int base=1000000007;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(s.charAt(i)=='L'){
                nums[i]=nums[i]-d;
            }else{
                nums[i]=nums[i]+d;
            }
            for(int j=i-1;j>=0;j--){
                int distance=Math.abs(nums[j]-nums[i])%base;
                res=(res+distance)%base;
            }
        }
        return res;
    }
    public int sumDistance(int[] nums,String s,int d){
        int base=1000000007;
        long res=0;
        int n=nums.length;
        long[] pos=new long[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='L'){
                pos[i]=(long)nums[i]-d;
            }else{
                pos[i]=(long)nums[i]+d;
            }
        }
        Arrays.sort(pos);
        for(int i=1;i<n;i++){
            res+=1L*(pos[i]-pos[i-1])*i%base*(n-i)%base;
            res%=base;
        }
        return (int)res;
    }
}
