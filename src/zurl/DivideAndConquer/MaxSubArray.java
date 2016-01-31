package zurl.DivideAndConquer;

/**
 * Created by furry on 1/31/2016.
 */
public class MaxSubArray {
    static class Status {
        int l, r, s;

        public Status(int _l, int _r, int _s) {
            l = _l;
            r = _r;
            s = _s;
        }

        public boolean compare(Status t) {
            return s > t.s;
        }

        public void printAnswer() {
            System.out.println("Ans : " + s + " From " + l + " To " + r);
        }
    }

    public static Status enumWork(int[] a) {
        //O(n^3) Algorithm
        int maxn = a[0], ansl = 0, ansr = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            //enum start point
            for (int j = i; j <= a.length - 1; j++) {
                //get sum
                int sum = 0;
                for (int k = i; k <= j; k++) sum += a[k];
                if (sum > maxn) {
                    maxn = sum;
                    ansl = i;
                    ansr = j;
                }
            }
        }
        return new Status(ansl, ansr, maxn);
    }

    public static Status enumOptWork(int[] a) {
        //O(n^2) Algorithm

        //Sustain the prefix sum
        int[] s = new int[a.length];
        s[0] = a[0];
        for (int i = 1; i <= a.length - 1; i++)
            s[i] = s[i - 1] + a[i];
        //Enum
        int maxn = a[0], ansl = 0, ansr = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            //enum start point
            for (int j = i; j <= a.length - 1; j++) {
                //get sum
                int sum = 0;
                if (i == 0) sum = s[j];
                else sum = s[j] - s[i - 1];
                if (sum > maxn) {
                    maxn = sum;
                    ansl = i;
                    ansr = j;
                }
            }
        }
        return new Status(ansl, ansr, maxn);
    }

    public static Status maxSubArray(int[] a, int l, int r) {
        if (l == r)
            return new Status(a[l], l, l);
        Status maxn = maxCrossSubArray(a, l, r);
        Status t = maxSubArray(a, l, (l + r) / 2);
        if (t.compare(maxn))
            maxn = t;
        t = maxSubArray(a, (l + r) / 2 + 1, r);
        if (t.compare(maxn))
            maxn = t;
        return maxn;
    }

    public static Status maxCrossSubArray(int[] a, int l, int r) {
        int mid = (l + r) / 2;
        //work on left
        int lmax = a[mid], ll = mid, lsum = 0;
        for (int i = mid; i >= l; i--) {
            lsum += a[i];
            if (lsum > lmax) {
                lmax = lsum;
                ll = i;
            }
        }
        //work on right
        int rmax = a[mid + 1], rr = mid + 1, rsum = 0;
        for (int i = mid + 1; i <= r; i++) {
            rsum += a[i];
            if (rsum > rmax) {
                rmax = rsum;
                rr = i;
            }
        }
        return new Status(ll, rr, lmax + rmax);
    }

    public static Status divideAndConquerWork(int[] a) {
        //O(nlgn) Algorithm
        return maxSubArray(a, 0, a.length - 1);
    }

    public static Status dpWork(int[] a) {
        //c[i] = max(a[i],a[i]+c[i-1]) -> Max from 1 to i
        //ans[i] = max(c[i],ans[i-1])
        int c = a[0], ans = a[0], cl = 0,ansl = 0,ansr =0;
        for (int i = 1; i <= a.length - 1; i++) {
            //calculate c
            if (a[i] > c + a[i]) {
                cl = i;
                c = a[i];
            } else {
                c = a[i] + c;
            }
            //calculate ans
            if(c > ans){
                ans = c;
                ansl = cl;
                ansr = i;
            }
        }
        return new Status(ansl,ansr,ans);
    }

    public static void main(String[] args) {
        int[] a = {1, -1, 2, -2, 3, -4, 5, 7, -8};
        enumWork(a).printAnswer();//O(n^3)
        enumOptWork(a).printAnswer();//O(n^2)
        divideAndConquerWork(a).printAnswer();//O(nlgn)
        dpWork(a).printAnswer();//O(n)
    }
}
