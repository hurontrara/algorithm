import javax.swing.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("k", 3);
        hashMap.put("k", 4);

        System.out.println("hashMap.get(KeyStroke) = " + hashMap.get("k"));
    }
}
