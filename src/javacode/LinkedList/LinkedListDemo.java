package javacode.LinkedList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] srgs) {
        //�������int���͵�linkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        /************************** linkedList�Ļ������� ************************/
        linkedList.addFirst(0); // ���Ԫ�ص��б�ͷ
        linkedList.add(1); // ���б��β���Ԫ��
        linkedList.add(2, 2); // ��ָ��λ�����Ԫ��
        linkedList.addLast(3); // ���Ԫ�ص��б��β

        System.out.println("LinkedList��ֱ������ģ�: " + linkedList);

        System.out.println("getFirst()��õ�һ��Ԫ��: " + linkedList.getFirst()); // ���ش��б�ĵ�һ��Ԫ��
        System.out.println("getLast()��õ����һ��Ԫ��: " + linkedList.getLast()); // ���ش��б�����һ��Ԫ��
        System.out.println("removeFirst()ɾ����һ��Ԫ�ز�����: " + linkedList.removeFirst()); // �Ƴ������ش��б�ĵ�һ��Ԫ��
        System.out.println("removeLast()ɾ�����һ��Ԫ�ز�����: " + linkedList.removeLast()); // �Ƴ������ش��б�����һ��Ԫ��
        System.out.println("After remove:" + linkedList);
        System.out.println("contains()�����ж��б��Ƿ����1���Ԫ��:" + linkedList.contains(1)); // �жϴ��б����ָ��Ԫ�أ�����ǣ��򷵻�true
        System.out.println("��linkedList�Ĵ�С : " + linkedList.size()); // ���ش��б��Ԫ�ظ���

        /************************** λ�÷��ʲ��� ************************/
        System.out.println("-----------------------------------------");
        linkedList.set(1, 3); // �����б���ָ��λ�õ�Ԫ���滻Ϊָ����Ԫ��
        System.out.println("After set(1, 3):" + linkedList);
        System.out.println("get(1)���ָ��λ�ã�����Ϊ1����Ԫ��: " + linkedList.get(1)); // ���ش��б���ָ��λ�ô���Ԫ��

        /************************** Search���� ************************/
        System.out.println("-----------------------------------------");
        linkedList.add(3);
        System.out.println("indexOf(3): " + linkedList.indexOf(3)); // ���ش��б����״γ��ֵ�ָ��Ԫ�ص�����
        System.out.println("lastIndexOf(3): " + linkedList.lastIndexOf(3));// ���ش��б��������ֵ�ָ��Ԫ�ص�����

        /************************** Queue���� ************************/
        System.out.println("-----------------------------------------");
        System.out.println("peek(): " + linkedList.peek()); // ��ȡ�����Ƴ����б��ͷ
        System.out.println("element(): " + linkedList.element()); // ��ȡ�����Ƴ����б��ͷ
        linkedList.poll(); // ��ȡ���Ƴ����б��ͷ
        System.out.println("After poll():" + linkedList);
        linkedList.remove();
        System.out.println("After remove():" + linkedList); // ��ȡ���Ƴ����б��ͷ
        linkedList.offer(4);
        System.out.println("After offer(4):" + linkedList); // ��ָ��Ԫ����ӵ����б��ĩβ

        /************************** Deque���� ************************/
        System.out.println("-----------------------------------------");
        linkedList.offerFirst(2); // �ڴ��б�Ŀ�ͷ����ָ����Ԫ��
        System.out.println("After offerFirst(2):" + linkedList);
        linkedList.offerLast(5); // �ڴ��б�ĩβ����ָ����Ԫ��
        System.out.println("After offerLast(5):" + linkedList);
        System.out.println("peekFirst(): " + linkedList.peekFirst()); // ��ȡ�����Ƴ����б�ĵ�һ��Ԫ��
        System.out.println("peekLast(): " + linkedList.peekLast()); // ��ȡ�����Ƴ����б�ĵ�һ��Ԫ��
        linkedList.pollFirst(); // ��ȡ���Ƴ����б�ĵ�һ��Ԫ��
        System.out.println("After pollFirst():" + linkedList);
        linkedList.pollLast(); // ��ȡ���Ƴ����б�����һ��Ԫ��
        System.out.println("After pollLast():" + linkedList);
        linkedList.push(2); // ��Ԫ��������б�����ʾ�Ķ�ջ�����뵽�б��ͷ��
        System.out.println("After push(2):" + linkedList);
        linkedList.pop(); // �Ӵ��б�����ʾ�Ķ�ջ������һ��Ԫ�أ���ȡ���Ƴ��б��һ��Ԫ�أ�
        System.out.println("After pop():" + linkedList);
        linkedList.add(3);
        linkedList.removeFirstOccurrence(3); // �Ӵ��б����Ƴ���һ�γ��ֵ�ָ��Ԫ�أ���ͷ����β�������б�
        System.out.println("After removeFirstOccurrence(3):" + linkedList);
        linkedList.removeLastOccurrence(3); // �Ӵ��б����Ƴ����һ�γ��ֵ�ָ��Ԫ�أ���β����ͷ�������б�
        System.out.println("After removeFirstOccurrence(3):" + linkedList);

        /************************** �������� ************************/
        System.out.println("-----------------------------------------");
        linkedList.clear();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        // ����������
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("Iterator��" + (end - start) + " ms");

        // ˳�����(�������)
        start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("for��" + (end - start) + " ms");

        // ��һ��forѭ������
        start = System.currentTimeMillis();
        for (Integer i : linkedList)
            ;
        end = System.currentTimeMillis();
        System.out.println("for2��" + (end - start) + " ms");

        // ͨ��pollFirst()��pollLast()������LinkedList
        LinkedList<Integer> temp1 = new LinkedList<>();
        temp1.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp1.size() != 0) {
            temp1.pollFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("pollFirst()��pollLast()��" + (end - start) + " ms");

        // ͨ��removeFirst()��removeLast()������LinkedList
        LinkedList<Integer> temp2 = new LinkedList<>();
        temp2.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp2.size() != 0) {
            temp2.removeFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("removeFirst()��removeLast()��" + (end - start) + " ms");
    }
}