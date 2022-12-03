package f07_design_patterns.f02_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Distintas estrategias de ordenación
public class StockFilters {

    // Sin usar FP
    public static List<Stock> bySymbol(List<Stock> list, String symbol) {
        List<Stock> filteredData = new ArrayList<>();

        for (Stock stock : list) {
            if (stock.getSymbol().equals(symbol)) {
                filteredData.add(stock);
            }
        }

        return filteredData;
    }

    public static List<Stock> byPriceAbove(List<Stock> list, double price) {
        List<Stock> filteredData = new ArrayList<>();

        for (Stock stock : list) {
            if (stock.getPrice() > price) {
                filteredData.add(stock);
            }
        }

        return filteredData;
    }

    // Usando FP
    public static List<Stock> filter(List<Stock> list, Predicate<Stock> p) {
        List<Stock> filteredData = new ArrayList<>();

        for (Stock stock : list) {
            if (p.test(stock)) {
                filteredData.add(stock);
            }
        }

        return filteredData;
    }
}
