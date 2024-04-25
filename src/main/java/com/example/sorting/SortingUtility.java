package com.example.sorting;

import java.util.ArrayList;

public class SortingUtility {

    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        int index = 0;
        while (index < data.length) {
            if (index == 0 || data[index].compareTo(data[index - 1]) >= 0) {
                index++;
            } else {
                swap(data, index, index - 1);
                index--;
            }
        }
    }

    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= data.length - 2; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            for (int i = data.length - 2; i >= 0; i--) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static <T extends Comparable<T>> void shellSort(T[] data) {
        ArrayList<Integer> gaps = new ArrayList<>();
        int h = 1;
        while (h <= data.length / 3) {
            gaps.add(h);
            h = 3 * h + 1;
        }

        for (int i = gaps.size() - 1; i >= 0; i--) {
            h = gaps.get(i);
            for (int j = h; j < data.length; j++) {
                T temp = data[j];
                int k;
                for (k = j; k >= h && data[k - h].compareTo(temp) > 0; k -= h) {
                    data[k] = data[k - h];
                }
                data[k] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}





