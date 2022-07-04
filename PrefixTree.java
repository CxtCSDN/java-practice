package javese.datastruct.prefixtree;

public class PrefixTree {
    //经典前缀树
    public static class PrefixTreeNode{
        public int pass;
        public int end;
        public PrefixTreeNode[] road;//如果路特别多可使用HashMap<char,Node>roads的方式表示（即有哪条路以及通向该路的结点）
        public PrefixTreeNode(){
            pass = 0;
            end = 0;
            road = new PrefixTreeNode[26];
        }
    }
    //根节点的pass值是加入的字符串个数（有多少个字符串是以空串""作为前缀的）
    private PrefixTreeNode root;
    public PrefixTree(){
        root = new PrefixTreeNode();
    }
    public void insert(String word){
        if(word == null){
            return;
        }
        //若加入空串，则根节点的end值会增加
        char[] arrWord = word.toCharArray();
        PrefixTreeNode node = root;
        node.pass++;
        int index = 0;
        for(int i = 0; i < arrWord.length; i++){
            index = arrWord[i]-'a';
            if(node.road[index] == null){
                node.road[index] = new PrefixTreeNode();
            }
            node = node.road[index];
            node.pass++;
        }
        node.end++;
    }
    public void delete(String word){
        if(word == null){
            return;
        }
        if(search(word) != 0){
            char[] arrWord = word.toCharArray();
            PrefixTreeNode node = root;
            node.pass--;
            int index = 0;
            for(int i = 0; i < arrWord.length; i++){
                index = arrWord[i]-'a';
                //当某个结点pass为0了则放弃这个结点开始，后续的整棵树
                //C++则不能直接放弃，需要遍历到最后将所有结点并析构（pass为0时，后续还是可能有结点，不过pass都为“1”，属于要删除的结点）
                if(--node.road[index].pass == 0){
//                    node.road[index] = null;//Java
                    //C++
                    int tmpI = i;
                    while(tmpI < arrWord.length){
                        PrefixTreeNode pre = node;
                        node = node.road[index];
                        //析构pre
                        tmpI++;
                        index = arrWord[tmpI]-'a';
                    }
                    return;
                }
                node = node.road[index];
            }
            node.end--;
        }
    }
    //某个字符串加入了多少次
    public int search(String word){
        if(word == null){
            return 0;
        }
        char[] arrWord = word.toCharArray();
        PrefixTreeNode node = root;
        int index = 0;
        for(int i = 0; i < arrWord.length; i++){
            index = arrWord[i]-'a';
            if(node.road[index]==null){
                return 0;
            }
            node = node.road[index];
        }
        return node.end;
    }
    //有多少个字符串是以word作为前缀
    public int prefixNum(String word){
        if(word == null){
            return 0;
        }
        char[] arrWord = word.toCharArray();
        PrefixTreeNode node = root;
        int index = 0;
        for(int i = 0; i < arrWord.length; i++){
            index = arrWord[i]-'a';
            if(node.road[index]==null){
                return 0;
            }
            node = node.road[index];
        }
        return node.pass;
    }
}
