import java.util.Scanner;

public class Main{

    public static class StaticArrayList {
        int capacity;
        int[] list;
        int size;
        //constructors------------------------------------
        public StaticArrayList(int cap){
            this.capacity = cap;
            this.size = 0;
            this.list = new int[this.capacity];
        }
        public StaticArrayList(){
            this(5);
            this.size = 0;
        }
        //-------------------------------------------------
        public boolean isFull(){
            return size==capacity;
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void pushBack(int value){
            if(!isFull()){
                this.list[size++] = value;
            }
            else{
                System.out.println("List is full");
            }
        }
        public int popBack(){
            int aux =0;
            if(!isEmpty()){
                aux =list[size-1];
                size--;
            }
            else{
                //System.out.println("Can't pop. List is empty");
            }
            return aux;
        }
        public void pushFront(int value){
            if(isFull()){
                System.out.println("List is full");
            }
            else{
                size++;
                for(int i=size-1;i>0;i--){
                    list[i] = list[i-1];
                }
                list[0] = value;
            }
        }
        public int popFront(){
            //System.out.println(size);
            int aux = list[0];
            for(int i=0;i<size-1;i++){
                list[i] = list[i+1];
            }
            size--;
            return aux;
        }

        public void printString(){
            if(this.size<=this.capacity){
                for(int i=0;i<size;i++){
                    System.out.print(this.list[i]);
                    if(!(i==size-1)){
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        String[] input = read.nextLine().split(" ");
        int positiveCapacity =0;
        int negativeCapacity=0;
        for(String a:input){
            int number = Integer.parseInt(a);
            if(number>0){
                positiveCapacity+=1;
            }else if(number<0){
                negativeCapacity+=1;
            }
        }
        StaticArrayList positive = new StaticArrayList(positiveCapacity);
        StaticArrayList negative = new StaticArrayList(negativeCapacity);

        for(String a:input){
            int number = Integer.parseInt(a);
            if(number>0){
                positive.pushBack(number);
            }else if(number<0){
                negative.pushBack(number);
            }
        }

        while(true){
            int positiveNumber = positive.popBack();
            int negativeNumber = negative.popFront();

            if((positiveNumber-Math.abs(negativeNumber))>0){
                positive.pushBack(positiveNumber);
            }else if((positiveNumber-Math.abs(negativeNumber))<0){
                negative.pushFront(negativeNumber);
            }else if((positiveNumber-Math.abs(negativeNumber))==0){

            }
            if(negative.isEmpty() || positive.isEmpty()){
                break;
            }
        }
        if(positive.isEmpty() && negative.isEmpty()){
            System.out.print("No quedaron robots!");
        }
        if(positive.isEmpty()){
            negative.printString();
        }else if(negative.isEmpty()){
            positive.printString();

        }else{
            System.out.println("Sucedió algo inesperado");
        }


    }

}