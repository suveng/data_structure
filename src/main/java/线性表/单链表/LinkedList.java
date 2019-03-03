package 线性表.单链表;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author suwenguang
 * suveng@163.com
 * since 2019/3/3
 * description: 单链表数据结构
 **/
public class LinkedList {

    /**
     * 定义头结点
     **/
    private Node head = null;

    /**
     * 结点数量
     **/
    private Integer size;


    LinkedList() {
        this.head = new Node(null);
        this.size = 0;
    }

    /**
     * 向链表中添加元素
     **/
    void addNode(Integer data) {
        //添加元素
        Node newNode = new Node(data);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        //维护链表大小
        size++;
    }

    /**
     * 删除第i个元素
     **/
    Integer deleteNode(Integer index) {
        //判断输入
        if (index > size || index < 0) {
            return Error.DELETE_ERROR.getCode();
        }
        //找到前置结点
        Node pre = head;
        Node current = null;
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                current = pre.getNext();
            } else {
                pre = pre.getNext();
            }
        }
        //执行删除
        assert current != null;
        pre.setNext(current.getNext());

        //维护链表大小
        size--;
        return current.getData();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cursor=head;
        while (ObjectUtils.allNotNull(cursor.getNext())){
            stringBuilder.append(cursor.getNext().getData()).append("->");
            cursor=cursor.getNext();
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}


/**
 * 结点类
 */
class Node {


    /**
     * 数据
     **/
    private Integer data;


    /**
     * 后继结点
     **/
    private Node next = null;

    Node(Integer data) {
        this.data = data;
    }

    Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}

/**
 * 错误枚举类
 */
enum Error {

    /**
     * 删除错误信息
     **/
    DELETE_ERROR(-1, "输入问题");

    private Integer code;
    private String msg;

    Error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}

