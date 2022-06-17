package ss10_dsa_list.excercise.my_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> stringMyList = new MyList<>();
        stringMyList.add("n");
        stringMyList.add(0 ,"v");
        stringMyList.add(1 ,"a");
        stringMyList.add(2 ,"c");
        stringMyList.add(3,"b");
        stringMyList.add(4,"f");
        for (int i = 0; i < stringMyList.size(); i++) {
            System.out.println(stringMyList.get(i));
        }
        stringMyList.clear();
        for (int i = 0; i < stringMyList.size(); i++) {
            System.out.println(stringMyList.get(i));
        }
    }
}
