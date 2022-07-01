package javase.datastruct.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        int arr[] = {2,1,6,5,7,3};
        for(int i = 0; i < arr.length; i++){
            avlTree.add(new Node(arr[i]));
        }
        avlTree.levelOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node find(int value){
        if(root == null){
            return null;
        }else{
            return root.find(value);
        }
    }
    public Node find_parent(int value){
        if(root == null){
            return null;
        }else{
            return root.find_parent(value);
        }
    }
    public void delect(int value){
        if(root == null){
            throw new RuntimeException("当前树中无结点");
        }
        Node targetNode = root.find(value);
        if(targetNode == null){
            throw new RuntimeException("要删除结点不存在");
        }
        Node parentNode = root.find_parent(value);
        //当删除的结点为根节点时则无父结点
        //在此处进行特判了就不用再在下面进行判断
        if(parentNode == null){
            Node tmp = root;
            //只有右子树的情况
            if(root.left == null){
                root = root.right;
                //只有左子树的情况
            }else if(root.right == null){
                root = root.left;
            }
            return;
        }
        //特殊情况：二叉树中只有一个结点
        if(root.left == null && root.right == null){
            root = null;
            return;
        }
        //情况一：删除叶子结点
        if(targetNode.left == null && targetNode.right == null){
            if(targetNode == parentNode.left){
                parentNode.left = null;
                return;
            }else if(targetNode == parentNode.right){
                parentNode.right = null;
                return;
            }
        }
        //情况二：删除只有一棵子树的结点
        else if((targetNode.left == null && targetNode.right != null) || (targetNode.left != null && targetNode.right == null)){
            //如果要删除的结点是父结点的左结点
            if(targetNode == parentNode.left){
                //如果要删除的结点只有左子树
                if(targetNode.left != null){
                    parentNode.left = targetNode.left;
                    return;
                    //要删除的结点只有右子树
                }else{
                    parentNode.left = targetNode.right;
                    return;
                }
                //要删除的结点是父结点的右结点
            }else if(targetNode == parentNode.right){
                //如果要删除的结点只有左子树...
                if(targetNode.left != null){
                    parentNode.right = targetNode.left;
                    return;
                }else{
                    parentNode.right = targetNode.right;
                    return;
                }
            }
        }
        //情况三：删除只有两棵子树的结点
        else if(targetNode.left != null && targetNode.right != null){
            //寻找右子树中的最小结点（寻找左子树的最大结点也可以）
            Node min = find_min(targetNode.right);
            //删除最小结点
            delect(min.value);
            //更改目标结点的值（本质就是将右子树最小结点提到了target位置覆盖了原结点）
            targetNode.value = min.value;
            return;
        }
    }
    //查找结点所属的子树的最小结点
    public Node find_min(Node node){
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    public Node find_max(Node node){
        if(node == null){
            return null;
        }
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }
    public void inOrder(){
        if(root == null){
            throw new RuntimeException("当前树中无结点");
        }else{
            root.inOrder();
        }
    }
    public void preOrder(){
        if(root == null){
            throw new RuntimeException("当前树中无结点");
        }else{
            root.preOrder();
        }
    }
    public void levelOrder(){
        if(root == null){
            throw new RuntimeException("当前树中无结点");
        }else{
            root.levelOreder();
        }
    }
    public void postOrder(){
        if(root == null) {
            throw new RuntimeException("当前树中无结点");
        }else{
            root.postOrder();
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

    public Node(int value){
        this.value = value;
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    public void levelOreder(){
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(this);
        while(!nodeQueue.isEmpty()){
            Node front = nodeQueue.poll();
            System.out.println(front);
            if(front.left != null){
                nodeQueue.add(front.left);
            }
            if(front.right != null){
                nodeQueue.add(front.right);
            }
        }
    }
    public Node find(int value){
        if(this.value == value){
            return this;
        }
        if(this.value > value && this.left != null){
            return this.left.find(value);
        }else if(this.value <= value && this.right != null){
            return this.right.find(value);
        }else{
            return null;
        }
    }
    public Node find_parent(int value){
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else if(this.value > value && this.left != null){
            return this.left.find_parent(value);
        }else if(this.value <= value && this.right != null){
            return this.right.find_parent(value);
        }else{
            return null;
        }
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
        if((this.leftHeight()-this.rightHeight())>1){
            if(this.left != null && (this.left.rightHeight()>this.left.leftHeight())){
                this.left.leftRotate();
            }
            this.rightRotate();
            return;
        }
        if((this.rightHeight()-this.leftHeight())>1){
            if(this.right != null && this.right.leftHeight() > this.right.rightHeight()){
                this.right.rightRotate();
            }
            this.leftRotate();
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
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height())+1;
    }
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }
    public void leftRotate(){
        Node node = new Node(this.value);
        node.left = this.left;
        node.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = node;
    }
    public void rightRotate(){
        Node node = new Node(this.value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = node;
    }
}
