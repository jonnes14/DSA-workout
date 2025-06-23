import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class IterativePreorder{
        public List<Integer> preOrder(TreeNode root){
            Stack<TreeNode> s=new Stack<>();
            List<Integer> a=new ArrayList<>();
            if(root==null){
                return a;
            }
            s.push(root);
          while (!s.empty()){
              root=s.pop();
              a.add(root.data);
              if(root.right!=null){
                  s.push(root.right);
              }
              if(root.left!=null){
                  s.push(root.left);
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
            root.right.left=new TreeNode(6);
            root.right.right=new TreeNode(7);
            IterativePreorder i=new IterativePreorder();
            i.preOrder(root);
            List<Integer> result=i.preOrder(root);
            System.out.println("preorder");
            for(Integer t:result){
                System.out.println(" "+t);
            }
    }
}