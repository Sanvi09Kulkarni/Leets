class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int i : numsDivide)
            gcd = gcd(gcd, i);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (gcd % nums[i] == 0)
                return i;
        return -1;
    }
}