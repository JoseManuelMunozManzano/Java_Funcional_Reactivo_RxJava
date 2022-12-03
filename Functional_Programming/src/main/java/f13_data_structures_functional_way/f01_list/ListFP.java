package f13_data_structures_functional_way.f01_list;

import java.util.List;

// Notas a tener en cuenta
// La estructura es inmutable, es decir, cada vez que hacemos un cambio tenemos que crear una lista nueva
public class ListFP {

    public static void main(String[] args) {

        ListFun<Integer> list = ListFun.list(3, 6, 9);
        list.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> newList = list.addElement(56);
        ListFun<Integer> newList2 = newList.addElement(12);
        ListFun<Integer> newList3 = newList2.addElement(15);
        newList3.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> newList4 = newList3.addElement(5, 1);
        newList4.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> removeEle = newList4.removeElement(9);
        removeEle.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> removeElePos = newList4.removeEle(3);
        removeElePos.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> reverseList = removeEle.reverseList();
        reverseList.forEach(System.out::println);

        System.out.println("\n---------\n");

        ListFun<Integer> list1 = ListFun.list(3, 6, 9, 8);
        ListFun<Integer> list2 = ListFun.list(35, 78, 90);

        ListFun.concat(list1, list2)
                .forEach(System.out::println);

        System.out.println("\n---------\n");

        List<Integer> l = List.of(2, 5, 8, 6);

        list1.addAllElements(l)
                .forEach(System.out::println);
    }
}
