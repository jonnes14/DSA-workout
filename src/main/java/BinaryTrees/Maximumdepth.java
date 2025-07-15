import java.util.*;
public class Maximumdepth {
    public int maxdepth(Nod root){
        if(root==null){
            return 0;
        }
        int left=maxdepth(root.left);
        int right=maxdepth(root.right);
        return 1+Math.max(left,right);
    }
    public static void main(String[] args) {
        Nod root=new Nod(1);
        root.left=new Nod(2);
        root.right=new Nod(3);
        root.left.left=new Nod(4);
        root.left.right=new Nod(5);
        root.right.left=new Nod(6);
        root.right.right=new Nod(7);
        Maximumdepth d=new Maximumdepth();
        int result=d.maxdepth(root);
        System.out.println("max depth :"+result);
    }
}
