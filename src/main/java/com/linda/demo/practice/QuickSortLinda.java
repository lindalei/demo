package com.linda.demo.practice;

public class QuickSortLinda {
  public static int count = 0;

  public static void main(String[] args) {
    //Random r = new Random(3);
    int[] a = {4, 3, 5, 9, 8};
    //int[] a = new int[5];
//    for (int i = 0; i < 5; i++) {
//      a[i] = i;
//    }


    quickSort(a, 0, a.length - 1);

    for (int i : a) {
      System.out.println(i);
    }

    System.out.println(count);
  }

  public static void quickSort(int[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int position = getPosition(a, left, right);
    quickSort(a, left, position - 1);
    quickSort(a, position + 1, right);
  }

  public static int getPosition(int[] a, int left, int right) {
    int ref = a[left];

    while (left < right) {
      count++;
      while (left < right && a[right] >= ref) {
        count++;
        right--;
      }
      swap(a, left, right);
      while (left < right && a[left] < ref) {
        count++;
        left++;
      }
      swap(a, left, right);
    }
    return left;
  }

  private static void swap(int[] a, int left, int right) {
    int temp = a[right];
    a[right] = a[left];
    a[left] = temp;
  }
}
