class Test {
    public static void main(String[] args) {
        int[] a={1,2,3,4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        Test tset = new Test();
        System.out.println(a.toString());//1
        tset.test01(a);
        System.out.println(a.toString());//5
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
}
    public void test01(int[] a)
    {
        System.out.println(a.toString());//2
        int[] b=new int[a.length+1];
        System.out.println(b.toString());//3

        b[a.length]=5;
        for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();
        b[2] = 0;
        a=b;
        System.out.println(a.toString());//4
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
