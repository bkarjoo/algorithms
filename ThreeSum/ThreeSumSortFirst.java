class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int start = i+1;
            int end = nums.length - 1;

            while (start < end)
            {
                if (nums[i] + nums[start] + nums[end] == 0)
                {
                    List<Integer> combo = new ArrayList<Integer>();
                    combo.add(nums[i]);
                    combo.add(nums[start]);
                    combo.add(nums[end]);
                    answer.add(combo);
                    end--;
                    start++;
                }
                else if (nums[i] + nums[start] + nums[end] > 0)
                    end--;
                else
                    start++;
            }
        }
        return answer;
    }
}
