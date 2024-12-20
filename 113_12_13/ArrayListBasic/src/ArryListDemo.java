import java.util.ArrayList;

public class ArryListDemo {
    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();


        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");


        System.out.println("ArrayList內容:" + list);


        String fruit = list.get(1);
        System.out.println("第2個元素是:" + fruit);


        list.set(1, "Blueberry");
        System.out.println("更新後的ArrayList" + list);


        list.remove(0);
        System.out.println("刪除後的ArrayList" + list);


        int size = list.size();

    }
}
