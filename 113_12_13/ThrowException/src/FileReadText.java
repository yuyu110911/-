public class FileReadText {
    public static void main(String[] args){
        try {
            String text = FileUtil.read("cashcard.txt");
            System.out.println(text);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
