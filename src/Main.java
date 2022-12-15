public class Main {
    public static void main(String[] args) {
        MinimalPassiveSearch search = new MinimalPassiveSearch();

        search.odd(-9, 3, 11);
        search.even(-9, 3, 10, 0.16);
        search.odd_with_break(-9, 3, 11);
        search.v4(-9, 3, 0.1);


    }
}