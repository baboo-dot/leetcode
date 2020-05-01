package solution;

class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int cursorOdd = 0;
        int cursorEven = 0;
        int[] res = new int[A.length];
        for (int i =0; i < A.length; i++) {
            if (i % 2 == 0) {
                while (A[cursorEven] % 2 != 0) {
                    cursorEven++;
                }
                res[i] = A[cursorEven++];
            } else {
                while (A[cursorOdd] % 2 == 0) {
                    cursorOdd++;
                }
                res[i] = A[cursorOdd++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution922 solution922 = new Solution922();
        int[] arr = {4,2,5,7};
        solution922.sortArrayByParityII(arr);
        int finish = -1;
    }
}
