public class LinkedList {
    Node head;
    LinkedList(Node head){
        this.head=head;
    }

    public static void print(Node head){
        Node ptr=head;
        while (ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }

    public static void middle(Node head){
        Node slow= head;
        Node fast= head;
        while (slow.next!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("Middle: " + slow.data);
    }

    public static Node reverse(Node head){
        Node ptr=head, prev=null, next=null;
        while (ptr!=null){
            next= ptr.next;
            ptr.next=prev;

            prev=ptr;
            ptr=next;
        }
        print(prev);
        return prev;
    }

    public static Node delete(Node head, int n){
        if (n==1) return head.next;
        Node ptr= head;
        int i;
        for (i=2;i<n && ptr!=null ;i++){
            ptr=ptr.next;
        }
        if (i==n && ptr.next!=null)
            ptr.next=ptr.next.next;
        else
            System.out.println("n Out of range");

        return head;
    }

    public static boolean detectLoop(Node head){
        Node slow=head, fast=head.next;
        while (slow!=fast && slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                System.out.println(loopLength(slow));
                return true;
            }
        }
        return false;
    }

    public static int loopLength(Node slow){
        Node ptr=slow.next;
        int count=1;
        while (ptr!=slow){
            ptr=ptr.next;
            count++;
        }
        return count;
    }

    public static int lengthOfList(Node head){
        int count=0;
        Node ptr=head;
        while (ptr!=null){
            count++;
            ptr=ptr.next;
        }
        return count;
    }

    public static void intersectionPoint(Node h1, Node h2){
        int l1= lengthOfList(h1);
        int l2= lengthOfList(h2);
        int diff= Math.abs(l1-l2);
        Node ptr1=h1, ptr2=h2;
        if (l1>l2){
            while (diff>0){
                ptr1=ptr1.next;
                diff--;
            }
        }else {
            while (diff>0){
                ptr2=ptr2.next;
                diff--;
            }
        }
        while (ptr1!=null && ptr2!=null){
            if (ptr1==ptr2){
                System.out.println(ptr1.data);
                break;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2,n1);
        Node n3=new Node(3,n2);
        Node n4=new Node(4,n3);
        Node n5=new Node(5,n4);
        Node n6=new Node(6,n5);
        LinkedList list=new LinkedList(n6);
        print(list.head);
        middle(list.head);
        list.head= reverse(list.head);
        list.head=delete(list.head,2);
        print(list.head);
        System.out.println(detectLoop(list.head));


        Node n11=new Node(11);
        Node n22=new Node(22,n11);
        Node n33=new Node(33,n22);
        Node n44=new Node(44,n33);
        Node n55=new Node(55,n44);
        Node n66=new Node(66,n55);
        n11.next=n11;
        LinkedList list1= new LinkedList(n66);
        System.out.println(detectLoop(list1.head));

        // creation of first list: 10 -> 15 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);
        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = head1.next;

        intersectionPoint(head1,head2);
    }
}

class Node{
    int data;
    Node next=null;
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
    }
}