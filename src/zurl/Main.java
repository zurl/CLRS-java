package Zurl;

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
    }
}
