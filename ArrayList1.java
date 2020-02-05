package arraylist;

/**
 * @Author:xiang
 * @Date:2020/2/5 20:28
 */
public class ArrayList1<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFALT_CAPACITY=10;

    public ArrayList1(){
        elementData=new Object[DEFALT_CAPACITY];
    }
    public ArrayList1(int capacity){
        elementData=new Object[capacity];
    }
    public int size(){
        return size;
    }
    public boolean idEmpty(){
        return size==0?true:false;
    }
    public void add(E element){
        if (size==elementData.length){
            Object[] newarray=new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newarray,0,elementData.length);
            elementData=newarray;
        }
        elementData[size++]=element;
    }
    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }
    public void set(E element,int index){
        checkRange(index);
        elementData[index]=element;
    }
    public void checkRange(int index){
        if (index<0||index>=size-1){
            throw new RuntimeException();
        }
    }
    public void remove(E element){
        for (int i = 0; i <size ; i++) {
            if (element.equals(get(i))){
                remove(i);
            }
        }
    }
    public void remove(int index){
        int numMoved=elementData.length-1-index;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i = 0; i <size ; i++) {
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList1 s1=new ArrayList1(20);
        for (int i = 0; i <10 ; i++) {
            s1.add("a"+i);
        }
        System.out.println(s1);
        System.out.println(s1);
    }
}
