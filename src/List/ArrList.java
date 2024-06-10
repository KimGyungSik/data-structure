package List;

import java.util.NoSuchElementException;

public class ArrList<E> {
    // 리스트의 항목을 저장할 배열
    private E a[];
    // 리스트의 항목 수
    private int size;
    // 생성자
    public ArrList() {
        // 최초로 크기가 1인 배열 생성
        a = (E[]) new Object[1];
        // 항목 수를 0으로 초기화
        size = 0;
    }
    // size를 반환
    public int getSize() {
        return size;
    }

    // 배열의 길이를 반환
    public int getLength() {
        return a.length;
    }

    // 접근하기 위한 메서드
    public E peek(int k) {
        // k번째 항목을 반환, 단순히 읽기만 한다
        // underflow 경우에 프로그램 정지
        if(size==0)
            throw new NoSuchElementException();
        return a[k];
    }

    // 가장 뒤에 새 항목 삽입하는 메서드
    public void insertLast(E newItem) {
        // 배열에 빈 공간이 없으면
        if(size==a.length) {
            // 배열 크기 2배로 확장
            resize(2 * a.length);
        }
        // 새 항목 삽입
        a[size++] = newItem;
    }

    // 새 항목을 k-1번째 항목 다음에 삽입하는 메서드
    public void insert(E newItem,int k) {
        // 배열에 빈 공간이 없으면
        if(size==a.length) {
            // 배열 크기 2배로 확장
            resize(2*a.length);
        }
        // 한 칸씩 뒤로 이동
        for(int i = size-1; i>= k; i--) {
            a[i+1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    // 배열 크기 조절을 위한 메서드
    public void resize(int newSize) {
        // newSize 크기의 새로운 배열 t 생성
        Object[] t = new Object[newSize];
        // 배열 a를 배열 t로 복사
        for(int i=0; i<size; i++) {
            t[i] = a[i];
        }
        // 배열 t를 배열 a로
        a = (E[]) t;
    }

    // k번째 항목 삭제하는 메서드
    public E delete(int k) {
        // underflow 시 프로그램 정지
        if(size==0)
            throw new NoSuchElementException();
        // k번째 item
        E item = a[k];
        // 1칸씩 앞으로 이동
        for(int i= k; i<size; i++) {
            a[i] = a[i+1];
        }
        size--;
        // 배열에 항목들이 1/4만 차지한다면
        if(size>0 && size==a.length/4)
                resize(a.length/2);// 배열을 1/2 크기로 축소

        return item;
    }
}
