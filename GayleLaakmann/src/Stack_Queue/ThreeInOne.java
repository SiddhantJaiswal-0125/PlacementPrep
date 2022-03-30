package Stack_Queue;

import java.util.EmptyStackException;
import java.util.Scanner;

public class ThreeInOne {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        FillMulti fi = new FillMulti(3);
        fi.push(0, 10);
        fi.push(2,15);
        fi.Display();
        fi.push(2,11);
        fi.push(2,13);
        fi.Display();
        fi.pop(2);
        fi.Display();
        fi.push(2,21);
        fi.Display();
        fi.pop(2);
        fi.pop(2);
        fi.pop(2);
        fi.Display();



    }
}

class FillMulti
{
    private int numberOfStacks = 3;
    private  int StackCapacity;
    private int values[]; //Single Array that will store 3 different stacks
    private int sizes[] ; //Capcity filled in each stack;
    FillMulti(int stcap)
    {
        StackCapacity = stcap;
        values =  new int[StackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }
    void push(int stNum, int val)
    {
        if(isFull(stNum))
            throw  new StackOverflowError();
        sizes[stNum]++;
        values[indexOf(stNum)] =  val;
        return;
    }

    int pop(int stNum)
    {
        if(sizes[stNum] == 0)
            throw  new EmptyStackException();

        int top = indexOf(stNum);
        int val = values[top];
        values[top] = 0;
        sizes[stNum]--;

        return val;
    }
    int peek(int stNum)
    {
        if(sizes[stNum] == 0)
            throw new EmptyStackException();
        int top = indexOf(stNum);
        return values[top];
    }




    boolean isFull(int stNum)
    {
        return  sizes[stNum] == StackCapacity;
    }
    int indexOf(int stNum)
    {
        int starting = stNum * StackCapacity;
        return  starting + sizes[stNum] -1;

    }

    void Display()
    {
        System.out.println("DISPLAYING");
        for(int i=0;i<values.length;i++)
            System.out.print(values[i]+"\t");
        System.out.println();
    }





}