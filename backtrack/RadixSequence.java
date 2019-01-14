package backtrack;

import java.util.*;

public class RadixSequence {
  
  public static List<int[]> generate(int length, int radix){
    List<int[]> list=new ArrayList<>();
    int[] nums=new int[length];
    generate(list, radix, nums, 0);
    return list;
  }
  
  private static void generate(List<int[]> list, int radix, int[] nums, int length){
    if(length==nums.length) {
      list.add(Arrays.copyOf(nums, nums.length));
      return;
    }
    for(int i=0;i<radix;i++){
      nums[length]=i;
      generate(list, radix, nums, length+1);
    }
  }

  public static void main(String[] args) {
    for(int[] nums:generate(2, 3)) System.out.println(Arrays.toString(nums));
  }

}
