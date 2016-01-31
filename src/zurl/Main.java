package zurl;

public class Main {

    public static void main(String[] args) {

        // CLRS java Code
        String[] e = new String[1];

        //Chapter 2

        //Section 2.1
        zurl.Sort.InsertSort.main(e);
        zurl.Sort.SelectSort.main(e);
        zurl.Search.LinearSearch.main(e);

        //Section 2.3
        zurl.Search.BinarySearch.main(e);
        zurl.Sort.BubbleSort.main(e);

        //Section 2.4
        zurl.Sort.MergeSort.main(e);
        //2.2.1
        zurl.Sort.MultiSort.main(e);
        //2.2.2
        zurl.Sort.BubbleSort.main(e);
        //2.2.3
        zurl.Math.Qinjiushao.main(e);
        //2.2.4
        zurl.Math.Inversion.main(e);

        //Chapter 4
        zurl.DivideAndConquer.MartixMultiplication.main(e);
        zurl.DivideAndConquer.MaxSubArray.main(e);

        //Chapter 5
        zurl.Random.Permute.main(e);
    }
}
