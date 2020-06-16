package org.golao.com.n2020;

public class LeetCode0616 {
    class Codec {

        // Encodes a tree to a single string.
        //json {v:1,l:{v:2},r:{v:3,l:{v:4},r:{v:5}}}
        public String serialize(TreeNode root) {
            if (root == null){
                return "null";
            }
            StringBuilder sb = new StringBuilder("");
            preOrder(root, sb);
            return sb.toString();
        }
        private void preOrder(TreeNode node, StringBuilder sb){
            sb.append("{");
            sb.append("v:" + node.val);
            if (node.left != null){
                sb.append(",");
                preOrder(node.left, sb);
            }
            if (node.right != null){
                sb.append(",");
                preOrder(node.right, sb);
            }
            sb.append("}");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("null".equals(data)){
                return null;
            }

            return null;
        }
    }
}
