import java.util.*;
public class Rightview {
    public void rightview(TreeNode root, int level, ArrayList<Integer> result1){
            if(root==null){
                return;
            }
            if(level==result1.size()){
                result1.add(root.data);
            }
            rightview(root.right,level+1,result1);
            rightview(root.left,level+1,result1);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
        Rightview r=new Rightview();
        ArrayList<Integer> result2 = new ArrayList<>();
        r.rightview(root,0,result2);
        System.out.println("right view"+ result2);
    }
}
