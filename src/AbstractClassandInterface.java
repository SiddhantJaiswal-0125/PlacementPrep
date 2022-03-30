public class AbstractClassandInterface
{

    public static void main(String[] args) {
//        athlete.speed();
        new abscls() {
            @Override
            void run() {
                System.out.println("RUN");
            }
        }.tell();
    }


}


interface  athlete{
    int a = 0;
    

    
     void run();
     static void speed()
     {
         System.out.println("HERE");
         return ;
     }

}
abstract  class abscls{
    int a;
    int b;
    
    abstract void run();
    void tell(){
        System.out.println("TELLL");
    }

}