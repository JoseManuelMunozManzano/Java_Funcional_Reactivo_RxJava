package f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");
        try(Stream<String> lines = Files.lines(path)) {

            // No se puede usar Arrays.of() en este caso para obtener el stream.
            // Queremos construir un stream de todos los elementos presentes en el array.
            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));

            // Ahora se usa un spliterator
            Spliterator<String> wordSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            // Este es el stream sobre el que vamos a operar
            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeeList = employees.collect(Collectors.toList());

            // Nombres de los empleados
            // Si quisiéramos llevarlos a una lista no modificable, a partir de Java 10 existe el método
            // Collectors.toUnmodifiableList()
            List<String> employeeNames = employeeList.stream()
                    .map(employee -> employee.getName())
                    .collect(Collectors.toList());
            employeeNames.forEach(System.out::println);

            // Obtener distintas designaciones de los empleados
            // Si quisiéramos llevarlos a un set no modificable, a partir de Java 10 existe el método
            // Collectors.toUnmodifiableSet()
            Set<String> designations = employeeList.stream()
                    .map(employee -> employee.getDesignation())
                    .collect(Collectors.toSet());
            designations.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
