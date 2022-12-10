package effective.java.item11.ch3;

/**
 * 자바 8에서 해시 충돌시 성능 개선을 위해 내부적을 동일한 버켓에 일정 개수 이상의 엔트리가 추가되면,
 * 연결리스트대신 이진트리를 사용하도록 변경되었다.
 *
 * LinkedList 는 ref 하나만잇으면되지만
 * ArrayList 는 그만큼의 size 를 먹어야한다.
 * 공간의 효율성차이때메 LinkedList 를 선택한것아닐까?
 *
 */
public class InnerLinkedList {
}
