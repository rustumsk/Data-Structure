import java.util.Scanner;
import java.util.InputMismatchException;

public class MyArray {
    public int size;
    public int count;
    public int[] array;

    Scanner scan = new Scanner(System.in);

    public MyArray(int size){
        this.size = size;
        this.array = new int[size];
        count = 0;
    }

    public void addElement(int arrayElement) {
        if (!isFull()) {
            array[count] = arrayElement;
            count++;
        }
        else {
                System.out.println("The array is full!");
                createSize(arrayElement);
        }
    }

    public void createSize(int arrayElement){
        int[] temp = null;
        int aDecide = 0;
        boolean cInput = false;
        int cDecide = 0;
        while(!cInput){
            try{
                while(cDecide == 0){
                    System.out.print("Do you want to add size or no? 1. add || 2. no: ");
                    aDecide = scan.nextInt();
                    if(aDecide <= 0 || aDecide >= 3){
                        System.out.println("Enter valid option!");
                        cDecide = 0;
                    }
                    else
                        cDecide++;
                        
                }
                cInput = true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please input integer value only!");
                scan.next();
            }
        }
        //adds 1 more size into the array and adds the element.
        if (aDecide == 1){
            temp = new int[size + 1];
            
            for (int i = 0; i < size; i++) {
                    temp[i] = array[i];
            }
            
            array = temp;
            size++;
            array[count] = arrayElement;
            System.out.println("The element is added!");
            count++;
        }
        else{
            System.out.println("The array is full!");
        }
    }

    public void viewArray(){
        for (int i = 0; i < array.length; i++){
            System.out.println("["+array[i]+"]");
        }
    }   

    public void searchElement(int value) {
        if (isEmpty()) {
            System.out.println("The array is Empty!");
        } else {
            boolean found = false;
            System.out.println("The value: " + value);
            for (int i = 0; i < size; i++) { //parse each index of the array
                if (array[i] == value) { //if an element matches the value, it prints its index.
                    found = true;
                    System.out.println("is at Index: " + i);
                }
            }
    
            if (!found) {
                 System.out.println("is not found in the array.");
            }
        }
    }

    public void removeElement (int rIndex){
        if (array[rIndex] == 0){
            System.out.println("This index has no element!");
        }
        else{
            array[rIndex] = 0;
        }
    }
    
    public void sortAscending() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int aTemp = array[i];
                    array[i] = array[j];
                    array[j] = aTemp;
                }
          }
        }
      }

    public void sortDescending(){
       for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int dTemp = array[i];
                    array[i] = array[j];
                    array[j] = dTemp;
                }
          }
        }
    }

    public void editElement(int eIndex, int eElement){
        array[eIndex] = eElement;
    }

    private boolean isFull(){
        return count >= size;
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
