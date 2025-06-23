public class PostOrder {
    public void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
         Node root=new Node(5);
        root.left=new Node(4);
        root.left.right=new Node(2);
        root.left.right.left=new Node(1);
        root.left.right.left.right=new Node(0);
        root.left.right.left.right.right=new Node(9);
        root.right=new Node(3);
        PostOrder r=new PostOrder();
        r.postorder(root);
    }
}
