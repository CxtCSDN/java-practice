package javase.datastruct.binarytree;

public class BST {
    public static void main(String[] args) {
        int arr[] = {5,1,6,9,4,7,2,8,3,0};
        BinarySortTree BST = new BinarySortTree();
        for(int i = 0; i < arr.length; i++){
            Node node = new Node(arr[i]);
            BST.add(node);
        }
        BST.inOrder();
        System.out.println(BST.root);
    }
}
class BinarySortTree{
    public Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }
    public void inOrder(){
        if(root == null){
            System.out.println("当前无结点");
            return;
        }else{
            root.inOrder();
        }
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(){}

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public Node(int value){
        this.value = value;
    }
    public void add(Node node){
        if(node == null){
            return;
        }
        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }
    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.inOrder();
        }
    }
}
