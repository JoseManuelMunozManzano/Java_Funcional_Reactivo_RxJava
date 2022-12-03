package f10_collectors_for_data_processing_in_depth.f05_downstream_collectors;

import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.Employee;
import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// Hasta ahora hemos visto Collectors análogos a llamadas terminales, pero también podemos anidar o poner
// en cascada los Collectors para seguir procesando.
// Aquí entra el término downstream, que indica que usamos un collector dentro de un collector
// Se usa, por ejemplo, en el método Collectors.groupingBy(classifier, downstream);
public class DownstreamCollector {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)) {

            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeeList = employees.collect(Collectors.toList());

            // Queremos saber el número de empleados por designación
            Map<String, Long> countByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    e -> e.getDesignation(),
                                    Collectors.counting()
                            )
                    );

            System.out.println(countByDesignation);

            // Queremos buscar la suma de salarios total distribuida entre cada puesto
            Map<String, Double> fundDistribution = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    e -> e.getDesignation(),
                                    Collectors.summingDouble(e -> e.getSalary())
                            )
                    );

            System.out.println(fundDistribution);

            // Queremos saber el empleado con el salario más alto de cada puesto
            Map<String, Optional<Employee>> maxSalaryEmployeesByDesignation = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    e -> e.getDesignation(),
                                    Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))
                            )
                    );

            System.out.println(maxSalaryEmployeesByDesignation);

            // Queremos saber el salario más alto de cada puesto.
            // Para obtener el salario necesitamos un nuevo stream solo con los salarios. Hay que transformar
            // la lista de empleados a una lista de salarios.
            // Se usa el método Collectors.mapping()
            // Este método también tiene un downstream
            //
            // Vemos que se usa el método Function.identity(). Cuando el valor devuelto es el mismo que
            // el valor que se pasa a la lambda, podemos indicar este método. Es lo mismo que decir e -> e
            Map<String, Optional<Double>> maxSalaries = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::getDesignation,
                                    Collectors.mapping(
                                            Employee::getSalary,
                                            Collectors.maxBy(Comparator.comparing(Function.identity()))
                                    )
                            )
                    );

            System.out.println(maxSalaries);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
