import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu of Searching and Sorting Testbed.");
            System.out.println("1) Linear search");
            System.out.println("2) Binary search");
            System.out.println("3) Insertion sort (O(n^2))");
            System.out.println("4) Quick sort (O(n log n))");
            System.out.println("5) Sorting performance");
            System.out.println("q/Q) Quit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Enter a value to search using linear search (0-9): ");
                    int linearTarget = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (performLinearSearch(list, linearTarget)) {
                        System.out.println("Found.");
                    } else {
                        System.out.println("Not Found.");
                    }
                    break;

                case "2":
                    System.out.println("Enter a value to search using binary search (0-9): ");
                    int binaryTarget = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (performBinarySearch(list, binaryTarget)) {
                        System.out.println("Found.");
                    } else {
                        System.out.println("Not Found.");
                    }
                    break;

                case "3":
                    int[] unsortedList1 = createRandomArray(10);
                    System.out.println("Data set before insertion sorting:");
                    displayArray(unsortedList1);
                    insertionSort(unsortedList1);
                    System.out.println("Data set after insertion sorting:");
                    displayArray(unsortedList1);
                    break;

                case "4":
                    int[] unsortedList2 = createRandomArray(10);
                    System.out.println("Data set before quicksort:");
                    displayArray(unsortedList2);
                    quickSort(unsortedList2, 0, unsortedList2.length - 1);
                    System.out.println("Data set after quicksort:");
                    displayArray(unsortedList2);
                    break;

                case "5":
                    System.out.println("Choice 5 not implemented.");
                    break;

                case "q":
                case "Q":
                    isRunning = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean performLinearSearch(int[] array, int target) {
        for (int number : array) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean performBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return true;
            }

            if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100;
        }
        return array;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
