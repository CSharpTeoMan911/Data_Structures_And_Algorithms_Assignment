package Insertion_Sort_Package;
import Linked_List_Package.Linked_List;

public class Insertion_Sort_Class {

    public static void Insertion_Sort(Linked_List list)
    {
        for (int i = 1; i < list.count; i++)
        {
            int current_index_element = (int)list.Get_Element(i);
            int previous_index = i - 1;

            while(previous_index >= 0 && (int)list.Get_Element(previous_index) >= current_index_element)
            {
                list.Add(list.Get_Element(previous_index), i);
                previous_index--;
            }

            list.Add(current_index_element, previous_index + 1);
        }
    }



}
