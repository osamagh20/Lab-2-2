import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q - 1
        String[] words = {"cat","dog","red","is","am"};
        for (int i = 0; i < words.length; i++) {
            String longest = words[0];
            if(longest.length() == words[i].length()) {
                longest = words[i];
                System.out.println(longest);
            }
        }

        // Q - 2
        int num1=0;
        int[] numbers = {1,1,1,3,3,5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to calculate repeat");
        int number= scanner.nextInt();
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == number) {
                num1++;
            }

        }
        System.out.println(number +" occurs "+num1+" times");



        // Q - 3
        int[] larArr = {1, 4, 17, 7, 25, 3, 100};
        Arrays.sort(larArr);
        for (int i = larArr.length-1 ; i > larArr.length-4 ; i--) {
            System.out.println(larArr[i]);
        }


        // Q - 4
        int[] originalArray = {5,4,3,2,1};
        System.out.print("Original Array: ");
        for(int i : originalArray) {
            System.out.print(i);
        }
        System.out.println(" ");
        reversArr(originalArray);
        System.out.print("Reversed Array: ");
        for(int j : originalArray) {
            System.out.print(j);
        }

//        Q - 5

        System.out.println("Enter size of array: ");
        int size = scanner.nextInt();
        String[] array = new String[size];

        System.out.println("1. Accept elements of an array\n" +
                "2. Display elements of an array\n" +
                "3. Search the element within array\n" +
                "4. Sort the array \n" +
                "5. To Stop the size of the array should be" +
                "entered by the user.");
        int option;
        do {
            System.out.println("Enter number to do it or 5 to exit  : ");
            option = scanner.nextInt();
            if(option == 1) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = scanner.next();
                }
            }else if(option == 2) {
                for(String n : array) {
                    System.out.println(n);
                }
            }else if(option == 3) {
                System.out.println("Enter the element to be searched: ");
                int serach = scanner.nextInt();
                System.out.println(array[serach]);

            }else if(option == 4) {
                Arrays.sort(array);
            }
        }while(option != 5);


        // Q - 6
        System.out.println("Enter start range : ");
        int min = scanner.nextInt();
        System.out.println("Enter end range : ");
        int max = scanner.nextInt();
        System.out.println("Enter number of generate  : ");
        int gen = scanner.nextInt();
        randomNumbers(min, max,gen);

        // Q - 7
        int totalScore=0;
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        checkLength(password);
        checkSpecialCharacters(password);
        checkUpperCaseLowerCase(password);
        totalScore = checkLength(password) + checkSpecialCharacters(password) + checkUpperCaseLowerCase(password);
        if(totalScore >= 8){
            System.out.println("Password is Strong");
        } else if (totalScore >= 5 && totalScore <8) {
            System.out.println("moderately strong");
        }else if (totalScore < 5) {
            System.out.println("Password is weak.");
        }

        // Q - 8
        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int terms = scanner.nextInt();

        fibonacci(terms);


    }

    public static void fibonacci(int number) {
        int first = 0;
        int second = 1;

        System.out.println("Fibonacci sequence with "+ number + " terms : ");
        for (int i = 1; i <= number; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }
    }


    public static void reversArr(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            int swapNumber = arr[first];
            arr[first] = arr[last];
            arr[last] = swapNumber;

            first++;
            last--;

        }
    }



    public static void randomNumbers(int min, int max,int gen) {
        for (int i = 0; i < gen; i++) {
            System.out.println(Math.random() * (max - min) + min);

        }

    }

    public static int checkLength(String pass) {
        int point1 =0;
        if(pass.length() > 0 && pass.length() <= 5){
            point1 = 0;
        } else if (pass.length() >= 6 && pass.length() <= 7) {
            point1 = 2;
        }else if (pass.length() >= 8) {
            point1 = 3;
        }
        return point1;

    }

    public static int checkSpecialCharacters(String pass) {
        int point2;
        if(pass.matches(".*[^a-zA-Z0-9].*")){
            point2 = 2;
        }else{
            point2 = 0;
        }
        return point2;
    }

    public static int checkUpperCaseLowerCase(String pass) {
        int point3;
        boolean hasUppercase = !pass.equals(pass.toUpperCase());
        boolean hasLowercase = !pass.equals(pass.toLowerCase());

        if (hasUppercase && hasLowercase) {
            point3 = 3;
        } else {
            point3 = 0;
        }
        return point3;
    }


    }
