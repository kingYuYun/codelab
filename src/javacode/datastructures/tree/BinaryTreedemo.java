package javacode.datastructures.tree;

public class BinaryTreedemo {
    public static void main(String[] args) {
        //����Ҫ����һ�Ŷ�����
        BinaryTree binaryTree = new BinaryTree();
        //������Ҫ�Ľ��
        HeroNode root = new HeroNode(1, "�ν�");
        HeroNode node2 = new HeroNode(2, "����");
        HeroNode node3 = new HeroNode(3, "¬����");
        HeroNode node4 = new HeroNode(4, "�ֳ�");
        HeroNode node5 = new HeroNode(5, "��ʤ");

        //˵�����������ֶ������ö���������������ѧϰ�ݹ�ķ�ʽ����������
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

//        //����
//		System.out.println("ǰ�����"); // 1,2,3,5,4
//		binaryTree.preOrder();
//
//        //����
//		System.out.println("�������");
//		binaryTree.infixOrder(); // 2,1,5,3,4
//
//		System.out.println("�������");
//		binaryTree.postOrder(); // 2,5,4,3,1

        //ǰ�����
        //ǰ������Ĵ��� ��4
//		System.out.println("ǰ�������ʽ~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}

        //�����������
        //�������3��
//		System.out.println("���������ʽ~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}

        //�����������
        //����������ҵĴ���  2��
//		System.out.println("���������ʽ~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪ no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("û���ҵ� no = %d ��Ӣ��", 5);
//		}

        //����һ��ɾ�����

        System.out.println("ɾ��ǰ,ǰ�����");
        binaryTree.preOrder(); //  1,2,3,5,4
        binaryTree.delNode(5);
        //binaryTree.delNode(3);
        System.out.println("ɾ����ǰ�����");
        binaryTree.preOrder(); // 1,2,3,4


    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //Delete node
    public void delNode(int no){
        if (root!=null){
            if(root.getNo()==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("node is null");
        }
    }

    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("tree is null");
        }
    }
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("tree is null");
        }
    }
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("tree is null");
        }
    }
    public HeroNode preOrderSearch(int no){
        if (root!=null){
            return root.preOrderSrearch(no);
        }else {
            return null;
        }
    }
}


class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //�ݹ�ɾ�����
    //1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
    //2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {

        //˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		 */
        //2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4.���Ǿ���Ҫ�����������еݹ�ɾ��
        if(this.left != null) {
            this.left.delNode(no);
        }
        //5.��Ӧ�������������еݹ�ɾ��
        if(this.right != null) {
            this.right.delNode(no);
        }
    }

    //ǰ�����
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        //��������
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }

    }

    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //ǰ���������
    public HeroNode preOrderSrearch(int no){
        System.out.println("����ǰ�����chazhao");
        if (this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.preOrderSrearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.preOrderSrearch(no);
        }
        return resNode;
    }
    //�����������
    public HeroNode infixOrderSearch(int no) {
        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        //����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
        if(this.no == no) {
            return this;
        }
        //������������ҵݹ���������
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //�����������
    public HeroNode postOrderSearch(int no) {

        //�жϵ�ǰ�������ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {//˵�����������ҵ�
            return resNode;
        }

        //���������û���ҵ��������������ݹ���к����������
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("����������");
        //�������������û���ҵ����ͱȽϵ�ǰ����ǲ���
        if(this.no == no) {
            return this;
        }
        return resNode;
    }



}
