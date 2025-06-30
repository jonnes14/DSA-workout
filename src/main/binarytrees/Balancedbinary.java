import java.lang.*;
public class Balancedbinary {
    public boolean balance(Nod root) {
        return check(root)!=-1;
    }
    int check(Nod root) {
        if (root == null) {
            return 0;
        }
       int left= check(root.left);
        if(left==-1) return -1;
        int right= check(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>=1) return -1;
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        Nod root=new Nod(1);
        root.left=new Nod(2);
        root.right=new Nod(3);
        root.left.left=new Nod(4);
        root.left.right=new Nod(5);
        root.right.left=new Nod(6);
        root.right.right=new Nod(7);
        Balancedbinary b=new Balancedbinary();

       System.out.println("balances :"+ b.balance(root));
    }
}
