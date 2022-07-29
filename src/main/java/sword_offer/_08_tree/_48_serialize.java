package src.main.java.sword_offer._08_tree;

public class _48_serialize {
    public static void main(String[] args) {
        AddTree tree = new AddTree();
        TreeNode root = tree.getTreeRoot();
        String serialize_res = serialize(root);
        System.out.println(serialize_res);
        TreeNode deserialize_res = deserialize(serialize_res);
        System.out.println(deserialize_res.val);
    }


    /*
        树序列化成字符串------>采用前序遍历(可以确定第一个数字即 根节点)
        1）序列化成字符串，需要逗号连接
        2）防止反序列化时，打乱树的结构，对于null节点，用#代替
     */
    private static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.valueOf(root.val) + "," + left + "," + right;
    }

    /*
        反序列化，先构造出根节点，再还原左右子节点
        1）字符串切割
        2）遇到 # , 返回null
     */
    public static TreeNode deserialize(String serialize) {
        // 1)切割字符串
        String[] nodeStr = serialize.split(",");
        // 取一个数组，来保存遍历字符串的索引
        int[] index = {0};
        return dfsDeserialize(nodeStr, index);

    }

    private static TreeNode dfsDeserialize(String[] nodeStr, int[] index) {
        String nodeValue = nodeStr[index[0]];
        index[0]++;
        if(nodeValue.equals("#")){
            return null;
        }
        // 该节点有值, 则创建该节点
        TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
        // 依次生成左子树, 右子树
        node.left = dfsDeserialize(nodeStr, index);
        node.right = dfsDeserialize(nodeStr, index);

        return node;

    }
}
