public class SortedStringArray {
    private String[] strings;
    private int size;

    public SortedStringArray() {
        strings = new String[10];
        size = 0;
    }

    public void add(String s) {
        if (size == strings.length) {
            String[] newStrings = new String[strings.length * 2];
            System.arraycopy(strings, 0, newStrings, 0, strings.length);
            strings = newStrings;
        }
        int i = size - 1;
        while (i >= 0 && s.length() < strings[i].length()) {
            strings[i + 1] = strings[i];
            i--;
        }
        strings[i + 1] = s;
        size++;
    }

    public String getMax() {
        if (size == 0) {
            return null;
        }
        return strings[size - 1];
    }

    public double getAverageLength() {
        if (size == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += strings[i].length();
        }
        return sum / size;
    }
}
