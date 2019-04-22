import java.util.*;
public class AVLTree
{
    AVLNode root;
    AVLTree()
    {
        root=null;
    }
    private AVLNode findParent(AVLNode x, AVLNode p)
    {
        if(p.right==x || p.left==x)
            return p;
        else
        {
            if(x.val<p.val)
            return findParent(x,p.left);
            else
            return findParent(x,p.right);
        }
    }
    private int height(AVLNode r)
    {
        if(r==null)
        return -1;
        int x=height(r.left);
        int y=height(r.right);
        return Math.max(x,y)+1;
    }
    private AVLNode search(Integer val, AVLNode rt)
    {
        if(val==rt.val)
        return rt;
        else if(val<rt.val)
        {
            if(rt.left!=null)
                return search(val, rt.left);
            else
                return null;
        }
        else
        {
            if(rt.right!=null)
                return search(val, rt.right);
            else
                return null;
        }
    }
    public void insert(int x)
    {
        root=insert(x,root);
    }
    private AVLNode insert(int x, AVLNode rt)
    {
        if(rt==null)
            rt=new AVLNode(x);
        else
        {
            if(rt.val>x)
            {
                rt.left=insert(x,rt.left);
                if(height(rt.left)-height(rt.right)==2)
                {
                    if(rt.left.val>x)
                        rt=rightRotate(rt);
                    else
                        rt=leftRightRot(rt);
                }
            }
            else if(rt.val<x)
            {
                rt.right=insert(x,rt.right);
                if(height(rt.left)-height(rt.right)==-2)
                {
                    if(rt.right.val<x)
                        rt=leftRotate(rt);
                    else
                        rt=rightLeftRot(rt);
                }
            }
        }
        rt.height=Math.max(height(rt.left),height(rt.right))+1;
        return rt;
    }
    /*public void delete(int x)
    {
        AVLNode rt=search(x,root);
        if(rt==null)
            throw new NoSuchElementException();
        else
            rt=delete(x, root);
    }*/
    private AVLNode rightRotate(AVLNode rt)
    {
        AVLNode lc=rt.left;
        rt.left=lc.right;
        lc.right=rt;
        rt.height=Math.max(height(rt.left),height(rt.right))+1;
        lc.height=Math.max(height(lc.left),height(lc.right))+1;
        return lc;
    }
    private AVLNode leftRotate(AVLNode rt)
    {
        AVLNode rc=rt.right;
        rt.right=rc.left;
        rc.left=rt;
        rt.height=Math.max(height(rt.left),height(rt.right))+1;
        rc.height=Math.max(height(rc.left),height(rc.right))+1;
        return rc;
    }
    private AVLNode leftRightRot(AVLNode rt)
    {
        rt.left=leftRotate(rt.left);
        return rightRotate(rt);
    }
    private AVLNode rightLeftRot(AVLNode rt)
    {
        rt.right=rightRotate(rt.right);
        return leftRotate(rt);
    }
    public void inOrderTraversal(AVLNode r)
    {
        if(r==null)
            return;
        inOrderTraversal(r.left);
        System.out.println(r.val);
        inOrderTraversal(r.right);            
    }
    public void preOrderTraversal(AVLNode r)
    {
        if(r==null)
            return;
        System.out.println(r.val);
        inOrderTraversal(r.left);
        inOrderTraversal(r.right);            
    }
    public void postOrderTraversal(AVLNode r)
    {
        if(r==null)
            return;
        inOrderTraversal(r.left);
        inOrderTraversal(r.right);
        System.out.println(r.val);            
    }
}