import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        generatePermutations("", numbers, visited, uniqueNumbers);

        int count = 0;
        for (int num : uniqueNumbers) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private void generatePermutations(String current, String numbers, boolean[] visited, Set<Integer> result) {
        if (!current.isEmpty()) {
            result.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(current + numbers.charAt(i), numbers, visited, result);
                visited[i] = false; // 백트래킹
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
