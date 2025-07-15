import java.util.*;
public class IterativePostOrder {
    public List<Integer> postOrder(TreeNode root){
        List<Integer>a=new ArrayList<>();
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();
        s1.push(root);
        while(!s1.empty()){
            root=s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while(!s2.empty()){
            a.add(s2.pop().data);
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
        IterativePostOrder i= new IterativePostOrder();

        List<Integer>result= i.postOrder(root);
        System.out.println("Preorder:");
        for(int j:result){
            System.out.print(" "+j);
        }
        System.out.println(" ");
    }
}
