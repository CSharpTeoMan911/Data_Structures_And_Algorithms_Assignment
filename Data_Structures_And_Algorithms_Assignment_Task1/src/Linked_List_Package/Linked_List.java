package Linked_List_Package;

class Node<Data_Type> {

    Data_Type data;
    Node<Data_Type> next;
    public Node(Data_Type received_data)
    {
        data = received_data;
    }
}

public class Linked_List<DataType> {

    Node<DataType> head;
    public int count = 0;


    public void Add(DataType data)
    {
        if(head == null)
        {
            head = new Node<DataType>(data);
        }
        else
        {
            Node<DataType> navigation_node = head;

            while (navigation_node.next != null)
            {
                navigation_node = navigation_node.next;
            }

            navigation_node.next = new Node<DataType>(data);
        }

        count++;
    }

    public void Add(DataType data, int index)
    {

        int current_index = 0;

        if(index >= 0) {

            if(index == count)
            {
                Add(data);
            }
            else if(index < count)
            {
                Node<DataType> navigation_node = head;

                while (current_index < index) {
                    navigation_node = navigation_node.next;
                    current_index++;
                }

                navigation_node.data = data;
            }
            else
            {
                throw new IndexOutOfBoundsException("Index was outside the range of the list");
            }
        }

    }

    public DataType Get_Element(int index)
    {
        DataType return_value;

        int current_index = 0;

        if(index >= 0 && index < count)
        {
            Node<DataType> navigation_node = head;

            while (current_index < index) {
                navigation_node = navigation_node.next;
                current_index++;
            }


            return_value = navigation_node.data;
        }
        else
        {
            throw new IndexOutOfBoundsException("Index was outside the range of the list");
        }

        return return_value;
    }

    public void Clear()
    {
        int index = 0;

        Node<DataType> current_node = head;
        Node<DataType> previous_node;

        while (index < count)
        {
            current_node.data = null;
            previous_node = current_node;

            if(current_node.next != null) {
                current_node = current_node.next;
            }

            previous_node = null;
        }

        count = 0;
    }

}
