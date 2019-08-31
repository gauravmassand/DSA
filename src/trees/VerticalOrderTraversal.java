package trees;

import java.io.IOException;
import java.util.*;

class DistanceNode {
    TreeNode node;
    int distance;
    DistanceNode(TreeNode root, int distance) {
        this.node = root;
        this.distance = distance;
    }
}

class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode(int x) { val = x; }
}

public class VerticalOrderTraversal {

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        verticalTraversal(root).size();
        System.out.println("d");

    }



    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<TreeNode>> map = new TreeMap<>();
        Queue<DistanceNode> queue = new LinkedList<>();
        if(root == null) {
            return null;
        }
        DistanceNode rootDistance = new DistanceNode(root,0);
        queue.add(rootDistance);
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(rootDistance.node);
        map.put(0,rootList);
        while(!queue.isEmpty()) {
            DistanceNode nodeDistance = queue.poll();
            TreeNode node = nodeDistance.node;
            int distance = nodeDistance.distance;
            if(node.left!=null) {
                DistanceNode leftDistanceNode = new DistanceNode(node.left,distance-1);
                queue.add(leftDistanceNode);
                if(!map.containsKey(distance-1)) {
                    List<TreeNode> leftList = new ArrayList<>();
                    leftList.add(node.left);
                    map.put(distance-1,leftList);
                }
                else {
                    map.get(distance-1).add(node.left);
                }
            }
            if(node.right!=null) {
                DistanceNode rightDistanceNode = new DistanceNode(node.right,distance+1);
                queue.add(rightDistanceNode);
                if(!map.containsKey(distance+1)) {
                    List<TreeNode> rightList = new ArrayList<>();
                    rightList.add(node.right);
                    map.put(distance+1,rightList);
                }
                else {
                    map.get(distance+1).add(node.right);
                }
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        for(Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            List<Integer> outputTreeNodes = new ArrayList<>();
            for(TreeNode value : entry.getValue()) {
                outputTreeNodes.add(value.val);
            }
            output.add(outputTreeNodes);
        }

        return output;
    }

}
