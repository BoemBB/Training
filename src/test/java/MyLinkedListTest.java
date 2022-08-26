import org.junit.Assert;
import org.junit.Before;

public class MyLinkedListTest {

    MyLinkedList<Integer> listInt;
    MyLinkedList<String> listStr;

    @Before
    public void createClass(){
        listInt = new MyLinkedList<>();
        listInt.add(5);
        listInt.add(10);
        listInt.add(1);
        listInt.add(40);

        listStr = new MyLinkedList<>();
        listStr.add("A");
        listStr.add("C");
        listStr.add("F");
        listStr.add("B");
    }

    @org.junit.Test
    public void addInt() {
        MyLinkedList<Integer> expected = listInt;

        MyLinkedList<Integer> actual = new MyLinkedList<>();
        actual.add(5);
        actual.add(10);
        actual.add(1);
        actual.add(40);

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void removeInt() {
        MyLinkedList<Integer> expected = listInt;
        expected.remove(10);

        MyLinkedList<Integer> actual = new MyLinkedList<>();
        actual.add(5);
        actual.add(1);
        actual.add(40);

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void sortInt() {
        MyLinkedList<Integer> expected = listInt;
        expected.sort();

        MyLinkedList<Integer> actual = new MyLinkedList<>();
        actual.add(1);
        actual.add(5);
        actual.add(10);
        actual.add(40);

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void addStr() {
        MyLinkedList<String> expected = listStr;

        MyLinkedList<String> actual = new MyLinkedList<>();
        actual.add("A");
        actual.add("C");
        actual.add("F");
        actual.add("B");

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void removeStr() {
        MyLinkedList<String> expected = listStr;
        expected.remove("C");

        MyLinkedList<String> actual = new MyLinkedList<>();
        actual.add("A");
        actual.add("F");
        actual.add("B");

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void sortStr() {
        MyLinkedList<String> expected = listStr;
        expected.sort();

        MyLinkedList<String> actual = new MyLinkedList<>();
        actual.add("A");
        actual.add("B");
        actual.add("C");
        actual.add("F");

        Assert.assertEquals(expected, actual);
    }
}