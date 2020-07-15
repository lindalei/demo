package com.linda.demo.practice;

public class QuickSortAgain<T extends Number> {
  public static void main(String[] args) {
    Double[] a = {123.0, 121.0, 961.0,586.2};
    QuickSortAgain<Double> quickSortAgain = new QuickSortAgain();
    quickSortAgain.quickSort(a, 0, a.length - 1);
    for (double i : a) {
      System.out.println(i);
    }
  }

  public void quickSort(T[] a, int left, int right) {
    if (left >= right) {
      return;
    }
    int position = getPosition(a, left, right);
    quickSort(a, left, position - 1);
    quickSort(a, position + 1, right);
  }

  public int getPosition(T[] a, int left, int right) {
    T ref = a[right];
    while (left < right) {
      while (left < right && a[left].intValue() <= ref.intValue()) {
        left++;
      }
      //      while(left<right && a[right].intValue()>=ref.intValue()){
      //        right--;
      //      }
      swap(a, left, right);
      //      while(left<right && a[left].intValue()<ref.intValue()){
      //        left++;
      //      }
      while (left < right && a[right].intValue() > ref.intValue()) {
        right--;
      }
      swap(a, left, right);
    }
    return left;
  }

  public void swap(T[] a, int left, int right) {
    T temp = a[right];
    a[right] = a[left];
    a[left] = temp;
  }
}
