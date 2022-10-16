import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorts extends SortingStudentsByGPA {
    public static void InsertionSort(Student[] stud, int n) {
        Student tmp;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && stud[j - 1].getId() > stud[j].getId(); j--) {
                tmp = stud[j];
                stud[j] = stud[j - 1];
                stud[j - 1] = tmp;
            }
        }
    }

    public static void QuickSort(Student[] stud, int n) {
        for (int i = 0; i < n - 1; i++) {
            System.out.println(new SortingStudentsByGPA().compare(stud[i], stud[i + 1]));
        }
    }

    public static void createArray(Student[] stud, int n) {
        Random r = new Random();
        int[] ids = new int[n];
        int tmp, randPos;
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < n; i++) {
            randPos = r.nextInt(ids.length);
            tmp = ids[i];
            ids[i] = ids[randPos];
            ids[randPos] = tmp;
        }
        for (int i = 0; i < n; i++) {
            stud[i] = new Student(ids[i], r.nextInt(1, 5), "Smith", "John");
        }
    }

    public static void mergeSort(Student[] st, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = st[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = st[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(st, l, r, mid, n - mid);
    }

    public static void merge(Student[] a, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getId() <= r[j].getId()) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergeArrays(Student[] st1, Student[] st2, Student[] res, int n) {
        for (int i = 0; i < n * 2; i++) {
            if (i < n)
                res[i] = st1[i];
            else
                res[i] = st2[i - n];
        }
    }

    public static void displayArray(Student[] stud, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(stud[i].toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Array size: ");
        n = sc.nextInt();


        Student[] students = new Student[n];
        createArray(students, n);
        displayArray(students, n);
        System.out.println("\nInsertion sort");
        InsertionSort(students, n);
        displayArray(students, n);
        System.out.println("\n");


        students = new Student[n];
        createArray(students, n);
        displayArray(students, n);
        System.out.println("\nQuick sort");
        Arrays.sort(students, new SortingStudentsByGPA());
        displayArray(students, n);

        n /= 2;
        students = new Student[n];
        Student[] students1 = new Student[n];
        createArray(students, n);
        createArray(students1, n);
        Student[] result = new Student[n * 2];
        mergeArrays(students, students1, result, n);
        System.out.println("\n");
        n *= 2;
        displayArray(result, n);
        mergeSort(result, n);
        System.out.println("\nMerge sort");
        displayArray(result, n);
    }
}