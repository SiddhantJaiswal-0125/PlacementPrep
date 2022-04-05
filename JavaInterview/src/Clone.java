import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class test
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        //Declare
        PriorityQueue<edge> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(size-- >0)
        {
//            int in = sc.nextInt();
//
//            pq.add(in);
//
//            display(pq);
        }

    }






    static  class edge  implements  Comparable<edge>{
        int wt, n1, n2;

        @Override
        public int compareTo(edge other) {
           return   this.wt- other.wt;
        }

















    }

static void display(PriorityQueue<Integer> pq )
    {

        System.out.println("In  Display");
        PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
//        System.out.println(pq.size());
        while(temp.isEmpty() == false)
            System.out.println(temp.remove());
    }
}