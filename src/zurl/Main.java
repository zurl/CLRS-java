package Zurl;

import java.util.zip.ZipEntry;

public class Main {

    public static void main(String[] args) {

        // CLRS java Code
        String[] e = new String[1];

        //Chapter 2

        //Section 2.1
        Zurl.Sort.InsertSort.main(e);
        Zurl.Sort.SelectSort.main(e);
        Zurl.Search.LinearSearch.main(e);

        //Section 2.3
        Zurl.Search.BinarySearch.main(e);
        Zurl.Sort.BubbleSort.main(e);

        //Section 2.4
        Zurl.Sort.MergeSort.main(e);
        //2.2.1
        Zurl.Sort.MultiSort.main(e);
        //2.2.2
        Zurl.Sort.BubbleSort.main(e);
        //2.2.3
        Zurl.Math.Qinjiushao.main(e);
        //2.2.4
        Zurl.Math.Inversion.main(e);

        //Chapter 4
        Zurl.Math.MartixMultiplication.main(e);
        Zurl.DivideAndConquer.MaxSubArray.main(e);

        //Chapter 5
        Zurl.Random.Permute.main(e);
        Zurl.Search.RandomSearch.main(e);

        //Chapter 6
        Zurl.DataStructure.Heap.main(e);
        Zurl.Sort.HeapSort.main(e);
        Zurl.DataStructure.PriorityQueue.main(e);
        Zurl.Sort.MatrixSort.main(e);

        //Chapter 7
        Zurl.Sort.QuickSort.main(e);
        Zurl.Sort.SuperSort.main(e);
        Zurl.Test.SortPerformance.main(e);

        //Chapter 8
        //Note: linear sort are stable
        Zurl.Sort.RadixSort.main(e);
        Zurl.Sort.CountSort.main(e);
        Zurl.Sort.BucketSort.main(e);
        //strange insert sort
        Zurl.Sort.ShellSort.main(e);

        //Chapter 9
        Zurl.Math.Util.main(e);
    }
}
