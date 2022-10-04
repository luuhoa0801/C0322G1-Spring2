public class test {
    //    public static void main(String[] args) {
//        int aVar = 1;
//        if (aVar++ < 10) {
//            System.out.println(aVar + " Hello World!");
//        } else {
//            System.out.println(aVar + " Hello Universe!");
//        }
//    }
    public static void main(String[] args) {
        Short s1 = 200;
        Integer s2 = 400;
        Long s3 = (long) s1 + s2;
        String s4 = (String) (s3 * s2);
        System.out.println("Sum is " + s4);
    }

}
