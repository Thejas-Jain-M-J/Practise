package com.practice.object;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Transaction_Main {

    static List<Transaction> transaction = new ArrayList<>();

    public static void main(String[] args) {

        transaction.add(new Transaction(UUID.randomUUID(), "170", LocalDate.of(2024, 10, 11), "Amazon", "Electronics"));
        transaction.add(new Transaction(UUID.randomUUID(), "210", LocalDate.of(2024, 9, 13), "Amazon", "Electronics"));
        transaction.add(new Transaction(UUID.randomUUID(), "370", LocalDate.of(2024, 10, 12), "Flipcart", "Fashion"));
        transaction.add(new Transaction(UUID.randomUUID(), "760", LocalDate.of(2024, 9, 16), "Amazon", "Electronics"));
        transaction.add(new Transaction(UUID.randomUUID(), "179", LocalDate.of(2024, 10, 18), "Flipcart", "Fashion"));

        testCategorySearch();
    }

    static void testCategorySearch()
    {
     SearchData searchData = new SearchData();
     searchData.category = "Fashion";

     List<Transaction> filteredTransaction = SearchTransactions.search(searchData);
     System.out.println(filteredTransaction);

    }

    static class SearchTransactions {

        public static List<Transaction> search(SearchData searchData) {

            List filteredTransaction = transaction.stream()
                    .filter(transaction -> (searchData.starDate == null
                            || transaction.transactionDate.isAfter(searchData.starDate)))
                    .filter(transaction -> (searchData.endDate == null
                            || transaction.transactionDate.isBefore(searchData.endDate)))
                    .filter(transaction -> (transaction.vendor == null
                            || transaction.vendor.equalsIgnoreCase(searchData.vendor)))
                    .filter(transaction -> (transaction.category == null
                            || transaction.category.equalsIgnoreCase(searchData.category)))
                    .collect(Collectors.toList());

            return filteredTransaction;

        }
    }

    static class Transaction {

        UUID transactionId;
        LocalDate transactionDate;
        String category;
        String vendor;
        String amount;

        Transaction(UUID transactionId, String amount, LocalDate date, String vendor,String category) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.transactionDate = date;
            this.category = category;
            this.vendor = vendor;

        }

    }

    static class SearchData {
        LocalDate starDate;
        LocalDate endDate;
        String vendor;
        String category;

    }

}
