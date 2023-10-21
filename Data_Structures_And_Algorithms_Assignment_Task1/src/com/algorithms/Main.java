package com.algorithms;
import Bubble_Sort_Package.Bubble_Sort_Class;
import Insertion_Sort_Package.Insertion_Sort_Class;
import Linked_List_Package.Linked_List;
import Merge_Sort_Package.Merge_Sort_Class;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import static com.ea.async.Async.await;


public class Main {



    private static Linked_List<String> merge_sort_print_elements = new Linked_List<>();
    private static Linked_List<String> insert_sort_print_elements = new Linked_List<>();
    private static Linked_List<String> bubble_sort_print_elements = new Linked_List<>();




    static long slowest_time;
    static long average_time;
    static long fastest_time = Long.MAX_VALUE;




    private static CompletableFuture<Boolean> Sort_Async_Task(int elements_configuration, int recursion_counter, int set_limit, String operation)
    {

        if(elements_configuration <= set_limit)
        {
            Linked_List<Integer> list = new Linked_List<Integer>();

            await(Add_Random_Numbers(list, elements_configuration));


            long start_time = System.currentTimeMillis();

            switch (operation)
            {
                case "Merge Sort":
                    Merge_Sort_Class.Merge_Sort(list);
                    break;
                case "Insertion Sort":
                    Insertion_Sort_Class.Insertion_Sort(list);
                    break;
                case "Bubble Sort":
                    Bubble_Sort_Class.Bubble_Sort(list);
                    break;
            }
            long end_time = System.currentTimeMillis();


            long resulted_time = end_time - start_time;


            switch (operation)
            {
                case "Merge Sort":
                    System.out.println("( Merge Sort (" + elements_configuration + " elements) ) Time elapsed:"  + resulted_time);
                    break;
                case "Insertion Sort":
                    System.out.println("( Insertion Sort (" + elements_configuration + " elements) ) Time elapsed:"  + resulted_time);
                    break;
                case "Bubble Sort":
                    System.out.println("( Bubble Sort (" + elements_configuration + " elements) ) Time elapsed:"  + resulted_time);
                    break;
            }


            if(resulted_time > slowest_time)
            {
                slowest_time = resulted_time;
            }
            else if(resulted_time < fastest_time)
            {
                fastest_time = resulted_time;
            }

            average_time += resulted_time;


            if(recursion_counter < 100)
            {
                if(recursion_counter == 99)
                {

                    switch (operation)
                    {
                        case "Merge Sort":
                            merge_sort_print_elements.Add("( Merge Sort (" + elements_configuration + " elements) ) Slowest Time:" + slowest_time);
                            merge_sort_print_elements.Add("( Merge Sort (" + elements_configuration + " elements) ) Average Time:" + (average_time / 100));
                            merge_sort_print_elements.Add("( Merge Sort (" + elements_configuration + " elements) ) Fastest Time:" + fastest_time);
                            break;
                        case "Insertion Sort":
                            insert_sort_print_elements.Add("( Insertion Sort (" + elements_configuration + " elements) ) Slowest Time:" + slowest_time);
                            insert_sort_print_elements.Add("( Insertion Sort (" + elements_configuration + " elements) ) Average Time:" + (average_time / 100));
                            insert_sort_print_elements.Add("( Insertion Sort (" + elements_configuration + " elements) ) Fastest Time:" + fastest_time);
                            break;
                        case "Bubble Sort":
                            bubble_sort_print_elements.Add("( Bubble Sort (" + elements_configuration + " elements) ) Slowest Time:"  + slowest_time);
                            bubble_sort_print_elements.Add("( Bubble Sort (" + elements_configuration + " elements) ) Average Time:"  + (average_time / 100));
                            bubble_sort_print_elements.Add("( Bubble Sort (" + elements_configuration + " elements) ) Fastest Time:"  + fastest_time);
                            break;
                    }

                    slowest_time = 0;
                    average_time = 0;
                    fastest_time = Long.MAX_VALUE;
                }

                await(Sort_Async_Task(elements_configuration,recursion_counter + 1, set_limit, operation));
            }
            else
            {
                slowest_time = 0;
                average_time = 0;
                fastest_time = Long.MAX_VALUE;

                await(Sort_Async_Task(elements_configuration * 10,0, set_limit, operation));
            }
        }

        return CompletableFuture.completedFuture(true);
    }


    private static CompletableFuture<Boolean> Add_Random_Numbers(Linked_List list, int elements_configuration)
    {
        Random rand = new Random();


        for (int i = 0; i < elements_configuration; i ++)
        {
            list.Add(rand.nextInt(1000000));
        }

        return CompletableFuture.completedFuture(true);
    }


    public static CompletableFuture<Boolean> Print_Sorting_Times()
    {
        int sorting_type = 0;

        while (sorting_type < 3)
        {
            Linked_List<String> sorting_times = null;

            System.out.print("\n\n\n\n");

            switch (sorting_type)
            {
                case 0:
                    sorting_times = merge_sort_print_elements;
                    break;
                case 1:
                    sorting_times = insert_sort_print_elements;
                    break;
                case 2:
                    sorting_times = bubble_sort_print_elements;
                    break;
            }

            for (int index = 0; index < sorting_times.count; index++)
            {
                if (index % 3 == 0)
                {
                    System.out.print("\n");
                }

                System.out.println(sorting_times.Get_Element(index));
            }

            sorting_type++;
        }

        return CompletableFuture.completedFuture(true);
    }



    public static void main(String[] args) {

        int elements_configuration = 10;
        int recursion_counter = 0;
        int set_limit = 1000;

        String merge_sort_operation = "Merge Sort";
        String insertion_sort_operation = "Insertion Sort";
        String bubble_sort_operation = "Bubble Sort";

        await(CompletableFuture.runAsync(()->Sort_Async_Task(elements_configuration, recursion_counter,set_limit, merge_sort_operation)));
        await(CompletableFuture.runAsync(()->Sort_Async_Task(elements_configuration, recursion_counter,set_limit, insertion_sort_operation)));
        await(CompletableFuture.runAsync(()->Sort_Async_Task(elements_configuration, recursion_counter,set_limit,bubble_sort_operation)));

        CompletableFuture.completedFuture(Print_Sorting_Times());
    }
}
