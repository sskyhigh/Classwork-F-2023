public class review {
    public static void main(String[] args) {
        String s = "Computer and Information Science";
        int j = s.indexOf('o');
        int k = s.indexOf('o', j+1);
        s = s.substring(j, k);
        //s = s+s.charAt(2);
        System.out.println(s);
    }
}
