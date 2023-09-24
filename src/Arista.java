import java.util.Arrays;

//Given an integer array, move all elements that are 0 to the left while maintaining the order of other elements
// in the array. The array has to be modified in-place.
//
//        input:  [ 1,10,20,0,59,63,0, 88,0]
//        Output: [ 0 0 0 1 10 20 59 63 88 ]
public class Arista {
    public static void main(String[] args) {
//        int[] arr= { 1,10,20,0,59,63,0, 88,0};
        int[] arr= { 1,10,20,0,59,63,0, 88,0,15,13,0,4,5};
        int n= arr.length;
        int start=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                for(int j=i;j>start;j--){
                    arr[j]=arr[j-1];
                }
                arr[start++]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
