package main.java.com.solvd.automation_homework;


public class CustomLinkedList<T> {

    static class CustomLinkedListNode<T> {
        T data;
        CustomLinkedListNode<T> next;

        CustomLinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private CustomLinkedListNode<T> first;
    private int size;


    public CustomLinkedList(){
        this.first = null;
        this.size = 0;
    }

    public void add(T data) {
        CustomLinkedListNode<T> newNode = new CustomLinkedListNode<>(data);
        if(this.isEmpty()){
            this.first = newNode;
        }else{
            CustomLinkedListNode<T> auxNode = this.first;
            while(auxNode.next != null){
                auxNode = auxNode.next;
            }
            auxNode.next = newNode;
        }
        this.size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data){
        CustomLinkedListNode<T> newNode = new CustomLinkedListNode<>(data);
        if(this.isEmpty()){
            this.first = newNode;
        }else{
            CustomLinkedListNode<T> auxNode = this.first;
            this.first = newNode;
            newNode.next = auxNode;
        }
        this.size++;
    }


    public void addLast(T data){
        this.add(data);
    }

    @Override
    public String toString() {
        String resultingString = "";
        if(this.size()>0){
            resultingString = "CustomLinkedList: {Size: "+this.size()+"; ";
            CustomLinkedListNode<T> tempNode = this.first;
            int counter = 0;
            while(tempNode.next != null){
                resultingString = resultingString+counter+": "+tempNode.data.toString()+", ";
                tempNode = tempNode.next;
                counter ++;
            }
            resultingString = resultingString+counter+": "+tempNode.data.toString()+"}";
        }
        return resultingString;
    }
}
