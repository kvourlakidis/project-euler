import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
    Let d(n) be defined as the sum of proper divisors of n (numbers less than
    n which divide evenly into n).
    If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair
    and each of and b are called amicable numbers.

    For example the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
    therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10_000.
*/

public class Problem021 {
    public static void main(String[] args) {
        int min = 1;
        int max = 10_000;
        Set<Integer> amicableNumbers = new HashSet<>();
        for (int i=min;i<max;i++) {
            Set<Integer> divisors = findDivisors(i);
            if (divisors.size() == 1) continue;
            int sumOfDivisors = sum(divisors);
            if (sumOfDivisors == i) continue;
            Set<Integer> divisorsOfSum = findDivisors(sumOfDivisors);
            if (divisorsOfSum.size() == 1) continue;
            int sumOfDivisorsOfSum = sum(divisorsOfSum);
            if (sumOfDivisorsOfSum == i)
                amicableNumbers.add(i);
        }
        System.out.println("Amicable numbers from " + min + " to " + max + ":");
        System.out.println(amicableNumbers);
        System.out.println("Sum: " + sum(amicableNumbers));
    }

    static Set<Integer> findDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        divisors.add(1);
        int root = (int) Math.sqrt(n);
        for (int i=2;i<=root;i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);   
            }
        }
        return divisors;
    }

    static int sum(Collection<Integer> coll) {
        int sum = 0;
        Iterator<Integer> iterator = coll.iterator();
        while (iterator.hasNext())
            sum += iterator.next();
        return sum;
    }
}