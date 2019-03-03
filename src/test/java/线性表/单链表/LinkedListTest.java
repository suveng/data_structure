package 线性表.单链表;


import org.junit.Before;
import org.junit.Test;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/3
 * description:
 **/
public class LinkedListTest {
    private LinkedList linkedList;
    @Before
    public void before(){
        this.linkedList=new LinkedList();
        System.out.println("init linked list");
    }
    @Test
    public void testDeleteNode(){
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        System.out.println("删除前：");
        System.out.println(linkedList);
        System.out.println(linkedList.deleteNode(2));
        System.out.println("删除后：");
        System.out.println(linkedList);
    }

}
