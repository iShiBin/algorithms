package problem;

import java.util.*;

/**<link> https://leetcode.com/problems/factor-combinations/description/
	Numbers can be regarded as product of its factors. For example,
	
	8 = 2 x 2 x 2;
	  = 2 x 4.
	Write a function that takes an integer n and return all possible combinations of its factors.
	
	Note: 
	You may assume that n is always positive.
	Factors should be greater than 1 and less than n.
	Examples: 
	input: 1
	output: 
	[]
	input: 37
	output: 
	[]
	input: 12
	output:
	[
	  [2, 6],
	  [2, 2, 3],
	  [3, 4]
	]
	
	input: 32
	output:
	[
	  [2, 16],
	  [2, 2, 8],
	  [2, 2, 2, 4],
	  [2, 2, 2, 2, 2],
	  [2, 4, 4],
	  [4, 8]
	]
 * @author bin
 *
 */

public class FactorCombinations {
	/*
	 * Algorithm 👍
	 * [Findings]
	 * - the problem contains similar sub-problem. For example: 12=[[2, 6],[2, 2, 3],[3, 4]], so 6=[2,3] is a sub-problem
	 * - once having the solution to a small problem of n/i, just append i to every list of the result of sub problem of n/i
	 * - the order is from a minimum
	 * factor (like 2) to n/i (inclusive)
	 * 
	 * Naturally, this problem could be solved by using Recursion with the help of another method having min number of factor,
	 * because the search is always goes up from the this number.
	 * 
	 * Complexity: time O(n*2^n); space O(2^n); 2ms in leetcode.com
	 */
    
	public List<List<Integer>> getFactors(int n) {
		return getFactors(n, 2);
	}
    
	private List<List<Integer>> getFactors(int n, int start) {
		List<List<Integer>> factors = new ArrayList<>();
		for (int i = start; i <= n / i; i++) {//pay very close attention to the end condition *i<=n/i*
			if (n % i == 0) {
				//first to add the i and n/i to the result list, then expand to the subproblem of n/i
				factors.add(new ArrayList<>(Arrays.asList(i, n / i)));
				//has to use new ArrayList() because Arrays.asList(i, n / i) is immutable
				
				for (List<Integer> l : getFactors(n / i, i)) {
					l.add(i);
					factors.add(l);
				}
			}
		}
		return factors;
	}

    /*
     * The recursion solution could be turned to backtracking like below.
     * - the search range is from 2 to n
     * - the order could be from low to high
     * - once it reaches 1, stop finding and add the factors to the result list
     * 
     * Complexity: O(), O(), 213ms in leetcode.com
     */
    
    public List<List<Integer>> getFactorsBacktracking(int n) {
        List<List<Integer>> factors=new ArrayList<>();
        getFactors(n, factors, new ArrayList<>(), 2);
        return factors;
    }
    
    private void getFactors(int n, List<List<Integer>> factors, List<Integer> temp, int start){
        // System.out.println(n+";"+temp);
        if(n==1){//come to the end case
            if(temp.size()>1){
                factors.add(new ArrayList<>(temp));
            }
        }else{
            for(int i=start;i<=n;i++){//calculate the factors
                if(n%i==0){
                    temp.add(i);
                    getFactors(n/i, factors, temp, i);//solve the sub problem
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
