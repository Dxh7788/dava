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
                    if ((pv = p.value) < value){
                        dir = -1;
                    }//加右树
                    else if (pv > value){
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

    public static void main(String[] sargs) {
        Integer[] args = new Integer[]{4,60,31,23,8,10,124,77};
        TreeNode that = TreeNode.replacementTreeNode(args);
        //遍历链表
        for (TreeNode hd = that;hd != null;hd = (TreeNode) hd.next){
            System.out.println("输出链表元素值为:"+hd.value);
        }
        TreeNode result = TreeNode.treeify(that);
        System.out.println(result);
    }
}
