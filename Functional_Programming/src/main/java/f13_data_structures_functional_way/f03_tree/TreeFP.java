package f13_data_structures_functional_way.f03_tree;

public class TreeFP {

    public static void main(String[] args) {
        TreeFun<Integer> t = TreeFun.tree(23, 5, 76, 10, 3, 45);
        System.out.println(t);

        System.out.println("\n-------------------\n");

        TreeFun<Integer> tree = t.remove(23);
        System.out.println(tree);

        System.out.println("\n-------------------\n");

        System.out.println(tree.isMember(76));

        System.out.println("\n-------------------\n");

        System.out.println(tree.max());
    }
}
