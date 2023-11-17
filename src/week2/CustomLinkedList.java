package week2;


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
            CustomLinkedListNode<T> tempNode = this.first;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        this.size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
