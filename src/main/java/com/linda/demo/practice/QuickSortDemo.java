package com.linda.demo.practice;

public class QuickSortDemo {
  public static void main(String[] args) {
    int[] arr = new int[]{3,1,2};
    quickSort(arr, 0, arr.length - 1);
    for (int num : arr) {
      System.out.print(num + ",");
    }
  }

  public static void quickSort(int[] arr, int left, int right) {
    // 1. 收敛条件
    if (left >= right) {
      return;
    }

    // 2. 不断递归
    int position = swapValue(arr, left, right);
    quickSort(arr, left, position - 1);
    quickSort(arr, position + 1, right);
  }

  public static int swapValue(int[] arr, int left, int right) {
    int flag = arr[left];

    while (left < right) {
      while (left < right && arr[right] >= flag) {
        right--;
      }

      arr[left] = arr[right];
      while (left < right && arr[left] < flag) {
        // 3. 收敛的原因所在
        left++;
      }

      arr[right] = arr[left];
    }
    arr[left] = flag;

    return left;
  }


}
