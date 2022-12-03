package f10_collectors_for_data_processing_in_depth.f04_terminal_analogous_collectors_3;

import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.Employee;
import f10_collectors_for_data_processing_in_depth.f02_terminal_analogous_collectors_01.EmployeeSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsExample {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources/EmployeeData.txt");
        try (Stream<String> lines = Files.lines(path)) {

            Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            EmployeeSpliterator employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);

            List<Employee> employeeList = employees.collect(Collectors.toList());

            // No siempre necesitamos que un Collectors nos devuelve una colección o un map.
            // A veces necesitamos un sencillo String que, por ejemplo, contenga el nombre de todos
            // los empleados separados por comas.
            // Es decir, el valor de retorno es un String. Para esto tenemos el método
            // Collectors.joining(delimeter);

            String employeeNamesString = employeeList.stream()
                    .map(e -> e.getName())
                    .collect(Collectors.joining(", "));

            System.out.println(employeeNamesString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
