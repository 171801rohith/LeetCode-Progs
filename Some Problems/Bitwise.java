public class Bitwise {
    public static void oddOReven(int n) {
        if ((n & 1) == 1)
            System.out.println("ODD");
        else
            System.out.println("EVEN");
    }

    public static void findUnique(int[] nums) {
        int unique = 0;
        for (int i : nums) {
            unique ^= i;
        }
        System.out.println(unique);
    }

    public static void findIthBit(int n, int i) {
        int bit = (n >> (i - 1)) & 1;
        System.out.println(bit);
    }

    public static void setIthBit(int n, int i) {
        n = n | (1 << i - 1);
        System.out.println(n);
    }

    public static void resetIthBit(int n, int i) {
        n = n & (~(1 << i - 1));
        System.out.println(n);
    }

    public static void nthMagicNum(int n) {
        int magicNum = 0, temp, base = 5;
        while (n != 0) {
            temp = n & 1;
            n >>= 1;
            magicNum += temp * base;
            base *= 5;
        }
        System.out.println(magicNum);
    }

    public static void noOfDigits(int num, int base) {
        int result = (int) (Math.log(num) / Math.log(base)) + 1;
        System.out.println(result);
    }

    public static void powOf2(int num) {
        // int count = 0, temp;
        // while (num > 0) {
        // temp = num & 1;
        // num >>= 1;
        // if (temp == 1) {
        // count++;
        // }
        // }
        // if (count == 1) {
        // System.out.println("TRUE");
        // } else {
        // System.out.println("FALSE");
        // }

        if ((num & (num - 1)) == 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public static void power(int base, int power) {
        int res = 1;
        while (power > 0) {
            if ((power & 1) == 1)
                res *= base;
            base *= base;
            power >>= 1;
        }
        System.out.println(res);
    }

    public static void noOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n -= (n & -n);
        }
        System.out.println(count);
        // int count = 0;
        // while (n > 0) {
        // if ((n & 1) == 1) count++;
        // n >>= 1;
        // }
        // System.out.println(count);
    }

    // Time Limit Exceeded for large numbers
    // public static void XORInRange(int s, int e) {
    // int res = 0;
    // for (int i = s; i <= e; i++)
    // res ^= i;
    // System.out.println(res);
    // }

    public static int xor(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;
            default:
                return 0;
        }
    }

    public static void XORInRange(int s, int e){
        int res = xor(e) ^ xor(s - 1);
        System.out.println(res);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(29));
        oddOReven(17);
        findUnique(new int[] { 3, 4, 3, 5, 4, 5, 6 });
        findIthBit(13, 4);
        setIthBit(13, 2);
        resetIthBit(15, 2);
        nthMagicNum(4);
        noOfDigits(5, 2);
        powOf2(1);
        power(3, 6);
        noOfSetBits(29);
        XORInRange(0, 9);
    }
}

// 1000
// 0111