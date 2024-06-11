import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "Division by zero error";
        }

        if (numerator == 0) return "0"; // If numerator is zero, return "0"

        StringBuilder result = new StringBuilder();
        
        // Handle signs
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert numerator and denominator to positive long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Calculate integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString(); // If remainder is zero, return result
        }
        
        // Calculate fractional part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal solution = new FractionToDecimal();
        
        // Test cases
        System.out.println(solution.fractionToDecimal(1, 2)); // Output: "0.5"
        System.out.println(solution.fractionToDecimal(2, 1)); // Output: "2"
        System.out.println(solution.fractionToDecimal(2, 3)); // Output: "0.(6)"
        System.out.println(solution.fractionToDecimal(1, 0)); // Output: "Division by zero error"
        System.out.println(solution.fractionToDecimal(1, 3)); // Output: "Division by zero error"
    }
}
