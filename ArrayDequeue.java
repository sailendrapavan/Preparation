import java.util.ArrayDeque;

public class ArrayDequeue {

    public static void main(String args[]) {
        
        ArrayDeque<String> dd = new ArrayDeque<>();
        dd.addFirst("aa");
        dd.addLast("aassa");
        for(String d:dd) {
            System.out.println(d);
        }
    }
}
