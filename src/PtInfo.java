public class PtInfo {
    private int SSN, age;
    private String name;


    public PtInfo(int SSN, int age, String name) {
        this.SSN = SSN;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return "SSN: " + SSN + ", Age: " + age + ", Name: " + name;
    }

    public static SinglyLinkedList<PtInfo> merge
            (SinglyLinkedList<PtInfo> list1, SinglyLinkedList<PtInfo> list2){

        if(list1.isEmpty()){
            return list2;
        }
        if(list2.isEmpty()){
            return list1;
        }
        if(list1.head.data.SSN > list2.tail.data.SSN) {
            list2.append(list1);
            return list2;
        }
        if(list2.head.data.SSN > list1.tail.data.SSN){
            list1.append(list2);
            return list1;
        }

        Node<PtInfo> temp1 = list1.head;
        Node<PtInfo> temp2 = list2.head;
        SinglyLinkedList<PtInfo> merged = new SinglyLinkedList<>();

        while (temp1 != null && temp2 != null) {
            if (temp1.data.SSN <= temp2.data.SSN) {
                merged.add(temp1.data);
                temp1 = temp1.next;
            } else {
                merged.add(temp2.data);
                temp2 = temp2.next;
            }
        }

        // Add remaining elements from either list
        while (temp1 != null) {
            merged.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            merged.add(temp2.data);
            temp2 = temp2.next;
        }

        return merged;
    }


    public static void main(String[] args){
        SinglyLinkedList<PtInfo> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<PtInfo> list2 = new SinglyLinkedList<>();

        PtInfo pt1 = new PtInfo(111223331,18,"Tom");
        PtInfo pt2 = new PtInfo(111223332,19,"Jack");
        PtInfo pt3 = new PtInfo(111223333,20,"Mary");
        PtInfo pt4 = new PtInfo(111223334,18,"Jane");
        PtInfo pt5 = new PtInfo(111223335,19,"Jesse");
        PtInfo pt6 = new PtInfo(111223336,18,"Jason");

        System.out.println("Two empty lists merged:");
        PtInfo.merge(list1, list2).display();

        System.out.println("\nOne empty list merged:");
        list1.add(pt2);
        PtInfo.merge(list1, list2).display();

        System.out.println("\nTwo lists with no duplicate patient:");
        list2.add(pt1);
        PtInfo.merge(list1, list2).display();

        System.out.println("\nTwo lists with a duplicate patient:");
        list2.add(pt2);
        PtInfo.merge(list1, list2).display();

        list1 = new SinglyLinkedList<>();
        list2 = new SinglyLinkedList<>();
        System.out.println("\nTwo lists with two duplicate patients:");
        list1.add(pt1);
        list1.add(pt2);
        list1.add(pt3);
        list2.add(pt2);
        list2.add(pt3);
        list2.add(pt4);
        list2.add(pt5);
        list1.add(pt6);
        PtInfo.merge(list1, list2).display();
    }
}
