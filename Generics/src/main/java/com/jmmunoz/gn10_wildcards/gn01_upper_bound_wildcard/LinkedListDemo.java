package com.jmmunoz.gn10_wildcards.gn01_upper_bound_wildcard;

public class LinkedListDemo {

    public static void main(String[] args) {
        DataNode<Integer> node2 = new DataNode<>(20, null);
        DataNode<Integer> node1 = new DataNode<>(35, node2);

        // La firma del constructor es:
        // DataNode(Integer, DataNode(Integer))

        System.out.println(node1.toString());



        DataNode<Double> node3 = new DataNode<>(20.9, null);
        DataNode<Double> node4 = new DataNode<>(35.8, node3);
        // Esto si puedo hacerlo, pero da error si pongo un node (en vez de null) como valor next.
        // porque lo espera del mismo tipo, Double en este caso.
        DataNode<Number> node5 = new DataNode<>(Double.valueOf(35.8), null);

        // La firma del constructor es:
        // DataNode(Double, DataNode(Double))

        System.out.println(node4.toString());


        // Lo que no podemos hacer es poner como tipo de node4 Integer porque se espera Double.


        // Este problema puede resolverse usando el wildcard
        // Se ha creado la clase DataNodeWildcard y ahora esto si es posible
        DataNodeWildcard<Double> node6 = new DataNodeWildcard<>(20.9, null);
        DataNodeWildcard<Double> node7 = new DataNodeWildcard<>(35.8, node6);
        // Ya es posible poner un node como valor next, puesto que next puede ser cualquier cosa.
        DataNodeWildcard<Number> node8 = new DataNodeWildcard<>(Double.valueOf(35.8), node7);

        System.out.println(node8.toString());

    }
}
