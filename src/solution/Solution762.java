package solution;

// class Solution762 {
//     public int countPrimeSetBits(int L, int R) {
//         int cnt = 0;
//         for (int i = L; i <= R; i++) {
//             if (isPrime(Integer.bitCount(i))) {
//                 cnt++;
//             }
//         }
//         return cnt;
//     }

//     public boolean isPrime(int num) {
//         if (num == 1) return false;
//         for (int i = 2; i <= num/2; i++) {
//             if (num % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
class Solution762 {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += (665772>>Integer.bitCount(i))&1;
        }
        return res;

    }
}