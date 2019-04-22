public class AVLDriver
{
    public static void main(String args[])
    {
        AVLTree AVL=new AVLTree();
        AVL.insert(50);
        AVL.insert(40);
        AVL.insert(30);
        AVL.insert(20);
        AVL.insert(10);
        /*AVL.insert(100);
        AVL.insert(45);
        AVL.insert(120);
        AVL.insert(99);
        AVL.insert(32);
        AVL.insert(35);
        AVL.insert(48);
        AVL.insert(98);
        AVL.insert(-100);
        AVL.insert(76);
        */AVL.inOrderTraversal(AVL.root);
    }
}       