
public class HashSet {

    public static void main(String args[]) {
        Hashmap s = new Hashmap();
        String key = "sai";
        int h;
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
        System.out.println(/*(key == null) ? 0 :  (1000000) ^*/ (34 >>> 16));

    }
}
