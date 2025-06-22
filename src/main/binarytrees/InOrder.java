
class Nod{
    int data;
    Nod left;
    Nod right;
  Nod(int val){
    data=val;
    left=null;
    right=null;
}
}

public class InOrder {
    public void inorder(Nod root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    int count(Nod root){
        if(root ==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }

    public static void main(String[] args) {
        Nod root=new Nod(1);
        root.left=new Nod(2);
        root.right=new Nod(3);
        root.left.left=new Nod(4);
        root.left.right=new Nod(5);
        root.right.left=new Nod(6);
        root.right.right=new Nod(7);
        System.out.println("Inorder");
        InOrder i=new InOrder();
        i.inorder(root);

        System.out.print(" "+i.count(root));
    }
}