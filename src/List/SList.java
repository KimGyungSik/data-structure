package List;

import java.util.NoSuchElementException;

public class SList<E extends Comparable> {
    // 단순 연결 리스트
    // -> 동적 메모리 할당을 이용해 리스트를 구현하는 가장 간단한 형태의 자료구조
    //    동적 메모리 할당을 받아 노드(Node)를 만들고, 노드는 레퍼런스를 이용하여 다음 노드를 가르키도록 만들어 노드들을 한줄로 연결
    //    *** 여기서 레퍼런스 === 객체의 주소값 ( 참조변수 )

    protected Node head;// 연결 리스트의 첫 노드 가리킴
    private int size;// 크기

    // 연결 리스트 생성자
    // head는 null, size는 0으로 초기화
    public SList() {
        head = null;
        size = 0;
    }

    // 탐색,삽입,삭제 연산을 위한 메서드 선언

    // 탐색 - 첫 노드부터 차례로 target을 탐색
    // 탐색을 실패한 경우 -1 반환
    public int search(E target) {
        Node p = head;
        for(int i=0; i<size; i++) {
            if(p.getItem().compareTo(target)==0)
                return i;
            p = p.getNext();
        }
        return -1;
    }


    // 연결 리스트 맨 앞에 새 노드 삽입
    public void insertFront(E newItem) {
        head = new Node(newItem,head);
        size++;
    }
    // 노드 p 바로 다음에 새 노드 삽입
    public void insertAfter(E newItem,Node p) {
        p.setNext(new Node(newItem,p.getNext()));
        size++;
    }

    // 리스트의 첫 노드 삭제
    public void deleteFront() {
        if(size==0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    // p가 가르키는 노드의 다음 노드를 삭제
    public void deleteAfter(Node p) {
        if(p==null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }
}


// 단순 연결 리스트의 노드를 정의한 Node 클래스
class Node<E extends Comparable> {
    private E item;// 항목
    // 다음 노드의 객체주소
    private Node<E> next;
    public Node(E newItem,Node<E> node) {
        item = newItem;
        next = node;
    }
    // setter/getter
    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
