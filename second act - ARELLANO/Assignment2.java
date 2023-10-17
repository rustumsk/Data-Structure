import java.util.InputMismatchException;
import java.util.Scanner;
public class Assignment2{
    public static void main(String[] args){
        int size = 0;
        Scanner scan = new Scanner(System.in);

        int fDecide = 0;
        boolean fInput = false;
        while (!fInput){
            try{
                while(fDecide <= 0){
                    System.out.print("Enter your array size: ");
                    size = scan.nextInt();
                    if (size <= 0){
                        System.out.println("Invalid array size!");
                    }
                    else{
                        fDecide++;
                    }
                }
                System.out.println("\n");
                fInput = true;
            }   
            catch(InputMismatchException e) {
                System.out.println("Invalid input! Integers only!");
                scan.nextLine();//this clears the input stream, so the loop can now prompt the user again.
            }
        }
        
        MyArray array = new MyArray(size);

        int dOption = 1;
        do{
            int option = 0;
            boolean oInput = false;
            while(!oInput){
                try{
                    System.out.print("Select Options: 1.Add() || 2.View() || 3.Remove() || 4.Search() || 5.Sort() || 6.Edit() || 7. Exit: ");
                    option = scan.nextInt();
                    oInput = true;
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input! numbers only!");
                    scan.next();
                }
            }

            switch (option){
                case 1:
                    int aOption = 1;
                    do{
                        int aElement = 0;

                        boolean sInput = false;
                        while(!sInput){
                            try{
                                System.out.print("What element do you want to add? (numbers only): " + "\n");
                                aElement = scan.nextInt();
                                sInput = true;
                            }
                            catch(InputMismatchException e) {
                                System.out.print("Numbers only!");
                                scan.next();
                                System.out.println("\n");
                            }
                        }

                        array.addElement(aElement);

                        int aDecide = 0;
                        boolean xInput = false;
                        int xDecide = 0;
                        while(!xInput){
                            try{
                                while(xDecide == 0){
                                    System.out.println("What do you want to do? 1. Add more element || 2.Return to options || 3.Exit the program: ");
                                    aDecide = scan.nextInt();
                                    if(aDecide <= 0 || aDecide >= 4){
                                        System.out.println("Invalid Option!");
                                        xDecide = 0;
                                    }
                                    else
                                        xDecide++;;
                                }

                                xInput = true;
                            }
                            catch(InputMismatchException e){
                                System.out.println("Invalid input! Integer number only!");
                                scan.next();
                            }
                        }

                        switch(aDecide){
                            case 1:
                                aOption = 1;
                                break;
                            case 2:
                                aOption--;  
                                break;
                            case 3:
                                aOption--;
                                dOption--;
                                break;
                            default:
                                System.out.println("Error!");
                                aOption--;
                        }
                    }while (aOption > 0);
                    break;
                case 2:
                    array.viewArray();
                    break;
                case 3:
                    if (array.isEmpty()){
                        System.out.println("All array has no element!");
                    }
                    else{
                        int rIndex;

                        boolean tInput = false;
                        while(!tInput){
                            try{
                                System.out.print("Index of element of an array you want to remove: ");
                                rIndex = scan.nextInt();
                                array.removeElement(rIndex);
                                tInput = true;
                            }
                            catch(InputMismatchException e){
                                System.out.println("Integer numbers only!");
                                scan.nextLine();
                            }
                            catch(IndexOutOfBoundsException i){
                                System.out.println("Invalid index! Input a valid index!");
                                scan.nextLine();
                            }
                        }
                    }
                    break;
                case 4:
                    int sValue = 0;

                    boolean kInput = false;
                    while(!kInput){
                        try{
                            System.out.print("Enter a value to search: ");
                            sValue = scan.nextInt();
                            kInput = true;
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid Input! Enter Integer values only!");
                            scan.next();
                        }
                    }
                    array.searchElement(sValue);
                    break;
                case 5:
                    int oDecide = 0;
                    boolean lInput = false;
                    while(!lInput){
                        try{
                            int lDecide = 0;
                            while(lDecide <= 0){
                                System.out.print("What order do you want to sort the array? 1. Ascending || 2.Descending || 3.Return to options: ");
                                oDecide = scan.nextInt();

                                if(oDecide <= 0 || oDecide > 3){
                                    System.out.println("Invaid option!");
                                }
                                else{
                                    lDecide++;
                                }
                            }
                            lInput = true;
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid Input! Please enter integer only!");
                            scan.nextLine();
                        }
                    }
                    switch (oDecide){
                        case 1:
                            array.sortAscending();
                            break;
                        case 2:
                            array.sortDescending();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("invalid");
                    }
                    break;
                case 6:
                    int eIndex = 0;
                    boolean uInput = false;
                    int uDecide = 0;
                    while (!uInput){
                        try{
                            while(uDecide == 0){
                                System.out.print("Index of the array u want to edit: ");
                                eIndex = scan.nextInt();
                                if(eIndex > array.size - 1){
                                    System.out.println("Out of bounds! Enter a valid array index!");
                                }
                                else{
                                    uDecide++;
                                }
                            }
                            uInput = true;
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invaid Input! Enter integer value only!");
                            scan.nextLine();
                        }
                    }
                    int eElement = 0;
                    
                    boolean pInput = false;
                    while(!pInput){
                        try{
                            System.out.print("The element you want to insert: ");
                            eElement = scan.nextInt();
                            pInput = true;
                        }
                        catch(InputMismatchException e){
                            System.out.println("Invalid Input! Enter integer value only!");
                            scan.nextLine();
                        }
                    }
                    array.editElement(eIndex, eElement);
                    break;
                case 7:
                    dOption--;
                    break;
                default:
                System.out.println("Invalid Option!");
            }
            }while (dOption > 0);
            
            System.out.println("GoodBye!");
            scan.close();
    }

}