package Bubble_Sort_Package;
import Linked_List_Package.Linked_List;

public class Bubble_Sort_Class {

    public static void Bubble_Sort(Linked_List list)
    {
        int list_length = list.count;

        for (int index = 0; index < list_length; index++)
        {
            boolean swap_occurred = false;

            for (int inner_index = 0; inner_index < list_length - index - 1; inner_index++)
            {

                if((int)list.Get_Element(inner_index) > (int)list.Get_Element(inner_index + 1))
                {
                    swap_occurred = true;
                    int buffer = (int)list.Get_Element(inner_index + 1);

                    list.Add(list.Get_Element(inner_index), inner_index + 1);
                    list.Add(buffer, inner_index);
                }

            }

            if(swap_occurred = false)
            {
                break;
            }
        }
    }

}
