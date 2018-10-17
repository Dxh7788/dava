package com.lrn.arith;

/*-----------红黑树--------------*/

/**
 * @author dongxiaohong on 2018/10/16 11:32
 */
public class TreeNode extends Node{
    //red-black tree links
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    // needed to unlink next upon deletion
    TreeNode prev;
    boolean red;

    public TreeNode(Integer value, Node next) {
        super(value, next);
    }

    //返回根 root
    final TreeNode root(){
        for (TreeNode r = this, p;;){
            if ((p=r.parent)==null){
                return p;
            }
            r = p;
        }
    }
    /**
     * 想要构建二叉树首先要构建一个链表
     * 数组转链表
     * */
    static TreeNode replacementTreeNode(Integer[] args){
        if (args == null || args.length==0){
            return null;
        }
        TreeNode hd=null,tl=null;
        for (Integer ir : args){
            TreeNode p = treeNodefy(ir, null);
            if (tl == null){
                hd = p;
            }else {
                p.prev = tl;
                tl.next = p;
            }
            tl = p;
        }
        return hd;
    }

    private static TreeNode treeNodefy(Integer value, TreeNode next) {
        return new TreeNode(value,next);
    }

    /**
     * 构建平衡二叉树
     * '原理就是插入数据
     *  第一阶段就---每次都要平衡一下
     *  第二阶段就---每次失衡了再平衡
     */
    static TreeNode treeify(TreeNode that){
        TreeNode root = null;
        for(TreeNode x = that, next;x!=null;x= next){
            next = (TreeNode)x.next;
            x.left = x.right = null;
            if (root == null){
                x.parent = null;
                root = x;
            }else {
                int value = x.value;
                int pv,dir;
                //遍历root
                for (TreeNode p = root;;){
                    //加左树
                    if ((pv = p.value) > value){
                        dir = -1;
                    }//加右树
                    else if (pv < value){
                        dir = 1;
                    }//如果相等则进行其他比较
                    else {
                       dir = 0;
                    }
                    TreeNode xp = p;
                    if ((p = (dir <= 0) ? p.left:p.right)==null){
                        x.parent = xp;
                        if (dir <= 0){
                            xp.left = x;
                        }else {
                            xp.right = x;
                        }
                        break;
                    }
                }
            }
        }
        return root;
    }

    /**
     * 平衡二叉树的左右二叉树也是平衡二叉树,所以可以采用递归方法
     * 找到最大执行单元.
     * 如果执行单左旋或者单右旋时,只需要执行leftRotate和rightRotate.
     * 如果是另外两种情况就需要找到最大旋转单元
     * */
    static TreeNode balancify(TreeNode node){
        return null;
    }
    /**
     * 左平衡,负责左树的平衡.先进行次级根树的左旋转,然后对根节点进行右旋转
     * @param root
     * */
    public TreeNode leftBalance(TreeNode root){
        TreeNode sRoot = root.left;
        sRoot = leftRotate(sRoot);
        root.left = sRoot;
        sRoot.parent = root;
        //对root进行左旋转
        root = rightRotate(root);
        return root;
    }
    /**
     * 右平衡,负责右树的平衡,先进行次级根树的右旋转,然后对根节点进行左旋转
     * @param root
     * */
    public TreeNode rightBalance(TreeNode root){
        TreeNode sRoot = root.right;
        sRoot = rightRotate(sRoot);
        root.right = sRoot;
        sRoot.parent = root;
        //对root进行左旋转
        root = leftRotate(root);
        return root;
    }
    /**
     * 需要进行旋转的最小树,进行右旋转
     * @param root
     * */
    public static TreeNode rightRotate(TreeNode root){
        TreeNode x = root,xp=root,xl=x.left;
        if (xl.right!=null){
            xp.left = xl.right;
        }
        xl.right = xp;
        xp.parent = xl;
        return xl;
    }
    /**
     * 需要进行旋转的最小树,进行左旋转
     * @param root
     * */
    public static TreeNode leftRotate(TreeNode root){
        TreeNode x = root, xp = root, xr = x.right;
        if (xr.left!=null){
            xp.right = xr.left;
        }
        xr.left = xp;
        xp.parent = xr;
        return xr;
    }
    public static void main(String[] sargs) {
        /*Integer[] args = new Integer[]{4,60,31,23,8,10,124,77};
        TreeNode that = TreeNode.replacementTreeNode(args);
        TreeNode result = TreeNode.treeify(that);

        treeNodeView(result);*/
        Integer[] args = new Integer[]{80,60,90,83,95,93};
        TreeNode that = TreeNode.replacementTreeNode(args);
        TreeNode result = TreeNode.treeify(that);
        result = leftRotate(result);
        System.out.println(result);
    }

    private static void treeNodeView(TreeNode result) {
        TreeNode leftNode = result.left;
        if (leftNode != null){
            System.out.println("root:"+result.value+",left:"+leftNode.value);
            treeNodeView(leftNode);
        }
        TreeNode rightNode = result.right;
        if (rightNode != null){
            System.out.println("root:"+result.value+",right:"+rightNode.value);
            treeNodeView(rightNode);
        }
    }
}
