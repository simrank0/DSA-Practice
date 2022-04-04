package SortingAndSearching;

public class KthElementOf2SortedArrays {
    public static void main(String[] args) {
        KthElementOf2SortedArrays kElement = new KthElementOf2SortedArrays();
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        //Expected: 6
        System.out.println(kElement.kthElement(arr1, arr2, arr1.length, arr2.length, k));
        int[] arr3 = {100, 112, 256, 349, 770};
        int[] arr4 = {72, 86, 113, 119, 265, 445, 892};
        k = 7;
        //Expected: 256
        System.out.println(kElement.kthElement(arr3, arr4, arr3.length, arr4.length, k));
    }
    public long kthElement(int[] a, int[] b, int n, int m, int k) {
        int i=0, j=0;
        while(k-->1){
            if(i<a.length && j<b.length && a[i]>=b[j]){
                j++;
            }else if(i<a.length && j<b.length && a[i]<b[j]){
                i++;
            }else if(i==a.length){
                j++;
            }else{
                i++;
            }
        }
        if(i==a.length) return b[j];
        if(j==b.length) return a[i];
        else return Math.min(a[i], b[j]);
    }
}
