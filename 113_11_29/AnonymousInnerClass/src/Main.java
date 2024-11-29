public class Main {
    public static void main(String[] args){
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, Java!");
            }
        };
        Greeting greeting2 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, Anonymous Inner!");
            }
        };
        greeting.sayHello();
        greeting2.sayHello();
    }
}
