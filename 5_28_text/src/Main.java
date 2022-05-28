public class Main {

    public static void main(String[] args){
//        Student stu = new Student();
        Teacher teacher = new Teacher();
        teacher.stu = new Student();
        teacher.stu.name = "张三";
        teacher.stu.age = 18;
        System.out.println(teacher.stu.name + " : " + teacher.stu.age);
    }

}
class Solution {
    //s 中的每个数字都是一个 小于 100 的 正 数，且不含前导零,都在区间(0,100)内
    public boolean areNumbersAscending(String s) {
        int digital = 0;
        int pre = -1;
        for(char val : s.toCharArray()){
            if(val >= '0' && val <= '9'){
                digital = 10*digital + (val - '0');
            }else{
                if(digital != 0){
                    if(pre >= digital) return false;
                    pre = digital;
                    digital = 0;
                }
            }
        }
        return digital == 0 || pre < digital;
    }
};
