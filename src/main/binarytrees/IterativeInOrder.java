import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrder {
    public List<Integer> Inorder(TreeNode root){
        Stack<TreeNode>s=new Stack<>();
        List<Integer>a=new ArrayList<>();
        while (true){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                if(s.isEmpty()){
                    break;
                }
                root=s.pop();
                a.add(root.data);
                root=root.right;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
        IterativeInOrder o=new IterativeInOrder();
        o.Inorder(root);
        List<Integer> result=o.Inorder(root);
        for(int i:result){
            System.out.println(i);
        }
    }
}
