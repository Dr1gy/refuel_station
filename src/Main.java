public class Main {
    public static void main(String[] args) {
        SortedStringArray array = new SortedStringArray();

        array.add("aaa");
        array.add("bb");
        array.add("cccc");
        array.add("d");
        array.add("eeeeee");

        System.out.println(array.getMax());
        System.out.println(array.getAverageLength());
    }
}