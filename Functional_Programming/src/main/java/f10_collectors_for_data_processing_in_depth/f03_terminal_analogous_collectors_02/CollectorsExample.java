package f10_collectors_for_data_processing_in_depth.f03_terminal_analogous_collectors_02;

import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.Employee;
import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// Cuando queremos llevar la data a una colección que no sea una lista o un set, tenemos el método
// Collectors.toCollection(collectionSupplier);
public class CollectorsExample {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)) {

            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeeList = employees.collect(Collectors.toList());

            // TreeSet
            // Queremos obtener los empleados en una estructura donde estos estén ordenados por sus ids.
            // Está implementado en la clase Employee el método compareTo, para que sea comparable.
            TreeSet<Employee> employeesSorted = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet::new));

            employeesSorted.forEach(System.out::println);

            // toMap
            // Queremos como claves los id y como valor los nombres de los empleados
            // Si quisiéramos un map no modificable, tenemos el método:
            // Collectors.toUnmodifiableMap(keyMapper, valueMapper);
            Map<Integer, String> getNameById = employeeList.stream()
                    .collect(Collectors.toMap(Employee::getId, Employee::getName));

            getNameById.forEach((k, v) -> System.out.println(k + " -> " + v));
            System.out.println(getNameById.get(27827));

            // Obtener todos los empleados hombre y mujer trabajando en esta organización
            // Se usa el método Collectors.partitioningBy()
            // Lo que hace es partir la data en dos listas, una que satisface la condición y otra
            // lista que NO satisface la condición
            // Devuelve un Map<Boolean, List<>> con dos entries, con las key true y false
            Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
                    .collect(Collectors.partitioningBy(employee -> employee.getGender() == 'M'));

            System.out.println(partitionedData);

            List<Employee> maleEmployees = partitionedData.get(true);
            List<Employee> femaleEmployees = partitionedData.get(false);

            // Queremos obtener todos los employees agrupados por puesto
            // Se usa el método Collectors.groupingBy(classifier)
            // Lo que hace es agrupar data en múltiples grupos según un clasificador.
            // Devuelve un Map<String, List<>> con tantos entries como elementos distintos encontrados
            // en el clasificador
            Map<String, List<Employee>> getByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(e -> e.getDesignation()));

            System.out.println(getByDesignation);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
