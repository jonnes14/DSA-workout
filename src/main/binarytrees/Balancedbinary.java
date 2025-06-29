public class Balancedbinary {
    public static void main(String[] args) {
        Nod root=new Nod(1);
        root.left=new Nod(2);
        root.right=new Nod(3);
        root.left.left=new Nod(4);
        root.left.right=new Nod(5);
        root.right.left=new Nod(6);
        root.right.right=new Nod(7);
    }
}
