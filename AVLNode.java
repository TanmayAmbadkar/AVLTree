public class AVLNode
{
    int val;
    AVLNode right;
    AVLNode left;
    int height;
    AVLNode()
    {
        val=0;
        right=null;
        left=null;
        height=-1;
    }
    AVLNode(int x)
    {
        val=x;
        right=null;
        left=null;
        height=-1;
    }
}