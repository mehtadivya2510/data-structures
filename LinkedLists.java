public class LinkedLists {
 
    public static void main(String[] args) {
        Node n1=new Node(19);
        Node n2=new Node(34,n1);
        Node n3=new Node(46,n2);
        Node n4=new Node(88,n3);
        Node n5=new Node(23,n4);
        Node n6=new Node(89,n5);
        Node n7=new Node(14,n6);
        Linked list=new Linked(n7);

        display(list.head);
        list.head=reverse(list.head);
        display(list.head);

        System.out.println("Middle : "+middle(list.head).data);

        display(clone(list.head));
        display((list.head));
    }

    static Node reverse(Node head){
        Node curr=head,prev=null,ptr;
        while(curr!=null){
            ptr=curr.next;
            if(prev==null){
                prev=curr;
                prev.next=null;
            }else{
                curr.next=prev;
                prev=curr;
            }
            curr=ptr;
        }
        return prev;
    }

    static Node clone(Node head){
        Node cloneNode=null;
        Node ptr=head;
        while(ptr!=null){
            Node temp=new Node(ptr.data);
            temp.next=ptr.next;
            ptr.next=temp;
            ptr=ptr.next.next;
        }
        ptr=head;
        cloneNode=head.next;
        Node temp=cloneNode;
        while(temp.next!=null){
            ptr.next=ptr.next.next;
            temp.next=temp.next.next;
            ptr=ptr.next;
            temp=temp.next;
        }
        ptr.next=null;
        temp.next=null;
        return cloneNode;
    }

    static Node middle(Node head){
        if (head==null)
        return null;
        Node slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    static void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println();
    }

    static class Linked{
        Node head;
        Linked(Node h){
            this.head=h;
        }
    }

    static class Node{
        int data;
        Node next;
        Node(int val,Node next){
            this.data=val;
            this.next=next;
        }
        Node(int val){
            this.data=val;
            this.next=null;
        }
    }
}