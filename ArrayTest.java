public class ArrayTest {
    public static void main(String[] args) {
        int i, j;
        int a[] = { 2, 1, 4, 8, 9, 5, 3 };
        //a.length = 7
        //i < 6
        for (i = 0; i < a.length - 1; i++) {
            int k = i;
            for (j = i; j < a.length; j++){
                if (a[j] < a[k]){
                    k = j;
                }
            }
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            System.out.println(""+i+j+k);
            for (int z = 0; z < a.length; z++)
                System.out.print(a[z] + "  ");
            System.out.println();
        }
        for (i = 0; i < a.length; i++)
            System.out.print(a[i] + "  ");
        System.out.println();
    }
}
