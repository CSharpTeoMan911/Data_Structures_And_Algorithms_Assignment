package Merge_Sort_Package;
import Linked_List_Package.Linked_List;


public class Merge_Sort_Class {

    public static void Merge_Sort(Linked_List list)
    {
        if(list.count > 1)
        {
            Linked_List<Integer> left_half = new Linked_List<>();
            Linked_List<Integer> right_half = new Linked_List<>();

            int sub_list_index = 0;
            int main_list_index = 0;

            while (sub_list_index < list.count / 2)
            {
                left_half.Add((Integer)list.Get_Element(main_list_index));
                sub_list_index++;
                main_list_index++;
            }

            sub_list_index = 0;


            while (sub_list_index < list.count - (list.count / 2))
            {
                right_half.Add((Integer)list.Get_Element(main_list_index));
                sub_list_index++;
                main_list_index++;
            }


            Merge_Sort(left_half);
            Merge_Sort(right_half);


            int left_list_index = 0;
            int right_list_index = 0;
            main_list_index = 0;

            while (left_list_index < left_half.count && right_list_index < right_half.count)
            {
                if(left_half.Get_Element(left_list_index) <= right_half.Get_Element(right_list_index))
                {
                    list.Add(left_half.Get_Element(left_list_index), main_list_index);
                    left_list_index++;
                }
                else
                {
                    list.Add(right_half.Get_Element(right_list_index), main_list_index);
                    right_list_index++;
                }

                main_list_index++;
            }

            while (left_list_index < left_half.count)
            {
                list.Add(left_half.Get_Element(left_list_index), main_list_index);
                left_list_index++;
                main_list_index++;
            }

            while (right_list_index < right_half.count)
            {
                list.Add(right_half.Get_Element(right_list_index), main_list_index);
                right_list_index++;
                main_list_index++;
            }

        }

    }
}
