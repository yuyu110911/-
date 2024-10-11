public class IntegerDemo2 {
    public static void main(String[] args) {
        int data1 = 10;      
        Integer wrapper1 = data1; //自動裝箱
        Integer wrapper2 = 20;
        int data2 = wrapper2; //自動裝箱
        
       
        if(wrapper1 == wrapper2){
            System.out.println("wrapper1 == wrapper2");
        }else{
            System.out.println("wrapper1 != wrapper2");
        }
    }
    
}
