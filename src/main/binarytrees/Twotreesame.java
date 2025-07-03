public class Twotreesame {
    public boolean check( Nod root , Nod root2){
        if(root==null && root2 == null){
            return true;
        }
        if(root == null || root2==null){
            return false;
        }
        return((root.data==root2.data)&& check(root.left,root.left)&& check(root.right,root.right));
    }
    public static void main(String[] args) {
        Nod root=new Nod(1);
        root.left=new Nod(2);
        root.right=new Nod(3);
        root.left.left=new Nod(4);
        Nod root2 =new Nod(1);
        root2.left=new Nod(2);
        root2.right=new Nod(3);
        root2.left.left=new Nod(4);
        Twotreesame t=new Twotreesame();
        if(t.check(root,root2)){
            System.out.println("both tree same");
        }
        else{
            System.out.println("both tree not same");
        }

    }
}
