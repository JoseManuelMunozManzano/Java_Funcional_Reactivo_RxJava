package f07_design_patterns.f02_strategy;

import java.util.ArrayList;
import java.util.List;

// Strategy Design Pattern: se usa cuando tenemos múltiples soluciones o algoritmos para resolver una tarea
//   específica y el cliente decide la implementación específica que se va a usar en tiempo de ejecución.
//   Es un patrón de comportamiento.
// La idea es eliminar las sentencias condicionales de la aplicación.
// Un ejemplo sería Collections.sort(List list, Comparator c) en el que basado en las diferentes implementaciones
// de Comparator podemos ordenar el objeto de diferentes formas.
public class StrategyPattern {

    public static void main(String[] args) {

        List<Stock> stockList = new ArrayList<>();

        stockList.add(new Stock("AAPL", 318.65, 10));
        stockList.add(new Stock("MSFT", 166.86, 45));
        stockList.add(new Stock("Google", 99, 12.5));
        stockList.add(new Stock("AMZ", 1866.74, 45));
        stockList.add(new Stock("GOOGL", 1480.20, 3.5));
        stockList.add(new Stock("AAPL", 318.65, 8));
        stockList.add(new Stock("AMZ", 1866.74, 9));

        // Forma sin Functional Programming de montar el patrón Strategy.
        // Especificamos la estrategia a usar en tiempo de ejecución
        System.out.println("Strategy Pattern: Forma tradicional");
        StockFilters.bySymbol(stockList, "AMZ").forEach(System.out::println);

        System.out.println("-----------------------");

        StockFilters.byPriceAbove(stockList, 300).forEach(System.out::println);

        System.out.println("-----------------------");

        // Con Functional Programming, usando lambdas, podemos crear un método que tome la estrategia necesaria
        // en tiempo de ejecución.
        System.out.println("Strategy Pattern: Functional Programming");
        StockFilters.filter(stockList, stock -> stock.getSymbol().equals("AMZ")).forEach(System.out::println);

        System.out.println("-----------------------");

        StockFilters.filter(stockList, stock -> stock.getPrice() > 300).forEach(System.out::println);
    }
}
