class Solution {
    public int countLargestGroup(int n) {

        int[] count = new int[37];

        // Count numbers having each digit sum
        for (int i = 1; i <= n; i++) {
            int x = i;
            int sum = 0;

            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            count[sum]++;
        }

        // Find largest group size
        int max = 0;

        for (int i = 1; i < 37; i++) {
            max = Math.max(max, count[i]);
        }

        // Count how many groups have that size
        int answer = 0;

        for (int i = 1; i < 37; i++) {
            if (count[i] == max) {
                answer++;
            }
        }

        return answer;
    }
}