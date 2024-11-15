package com.practice.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * -> The problem with multithreading was runnable interface run method. we can
 * write some
 * code and execute in that but it will not return anything and even we cant
 * even throw
 * exception back to caller method.
 *
 * ex: public void run(){}
 *
 * -> To tackle this java introduced one interface that is called callable. This
 * will return
 * some value and can able to handle exception. But you can only create Thread
 * with Runnable not Callable.
 * For Callable run like Runnable you have to submit the Callable to
 * ExecutorService
 * ExecutorService service = Executors.newSingleThreadExecutor();
 * Future<> submit = executorService.submit(callable);
 *
 * This is callable example
 * public interface Callable<V> {
 * V call() throws Exception;
 * }
 *
 *
 * -> Even though callable is there it cannot handle asynchronous execution
 * still it needs
 * executor service and future to work.
 *
 * -> So that's why future introduced to solve problems which is there in
 * multithreading.
 * 1. Once thread start executing task we cannot cancel it but in future we can
 * do it.
 * 2. We can check whether the thread completes it's execution or not.But in
 * future API we can do it using isDOne().
 * 3.In older multithreading there is no simple way to impose timeout on the
 * waiting threads
 * but in future we can do like this easily Future.get(long timeout, TimeUnit
 * unit) and it will
 * throw timeout exception.
 * 4. In multithreading there is no ways to collect the result but in future
 * there is get()
 * to get tge output.
 *
 *
 * -> In java 5 future Api was introduced to promote asynchronous programming.
 * - we cannot chain the multiple futures.
 * - we cannot combine the multiple futures.
 * - we cannot manually complete the future
 * - It can't handle Exception.
 * - It will blocks the main thread until response comeback
 * - we cannot attach callback to future.
 *
 * And other thing like if we call some external entity that is done then future
 * will
 * until the response comeback. with this some times we need to wait infinite
 * time. if we do future.get() -> after this line got executed main thread will
 * wait until it
 * returns the output.
 *
 * Because of this reasons completable future introduced in JAVA 8
 *
 *
 */
public class Future_Example {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // we can create completable future in two ways
        /**
         * this is using run async which take runnable interface and will not return any
         * value.
         */
        System.out.println("Main Thread " + Thread.currentThread().getName());
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println("Future Thread " + Thread.currentThread().getName());
        });

        future1.get();

        /**
         * this is using supplyAsync it will take supplier interface and return some
         * value.
         */
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            return "Future Thread " + Thread.currentThread().getName();
        });

        System.out.println(future2.get());

        // Adding callbacks to the completable future
        /**
         * thenApply() -> takes function interface and return value.
         * thenAccept() -> takes consumer interface and not returns any value.
         * thenRun() -> It will not take output from previous callback. It's just
         * executes when previous call back is done
         *
         * Like this way we can chain the operation.
         */
        CompletableFuture.supplyAsync(() -> "Like and")
                .thenApply(supplyResult -> supplyResult + " subscribe to")
                .thenApply((supplyResult) -> supplyResult + " Geekfic")
                .thenAccept((supplyResult) -> System.out.println(supplyResult + "  THANKS!!!"))
                .thenRun(() -> System.out.println("I am just printing once prev callback execution is done"))
                .get();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        /**
         * This how we can handle exception in completable future Using handle() and
         * exceptionally().
         * 
         * If we not handle the exception then callbacks below exception will not execute 
         * and if we call get() then this will thrown the exception.
         * we can handle exception in two ways in below way handle() method will receive
         * both result and exception. we can write our logic based on that.
         */
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Starting async task...");
            if (true)
                throw new RuntimeException("Something went wrong in the task!");
            return "Task completed";
        })
                .handle((result, ex) -> {
                    // Handle both the result and exception
                    if (ex != null) {
                        System.out.println("Caught exception: " + ex.getMessage());
                        return "Fallback result due to exception";
                    } else {
                        return result;
                    }
                })
                .thenApply(result -> result + " -> Continuing with next step")
                .thenAccept(finalResult -> System.out.println("Final output: " + finalResult))
                .get();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        /**
         * This will handle exception and will return some fallback result.
         */

        CompletableFuture.supplyAsync(() -> "Step 1")
                .thenApply(result -> result + " -> Step 2")
                .thenApply(result -> {
                    if (true)
                        throw new RuntimeException("Error in Step 3");
                    return result + " -> Step 3";
                })
                .exceptionally(ex -> {
                System.out.println("Handling error in Step 3: " + ex.getMessage());
                return "Recovered from Step 3"; // Recovery specific to Step 3
                })
                .thenApply(result -> result + " -> Step 4")
                .thenAccept(result -> System.out.println("Final result: " + result))
                .get();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        // we can use complete() to complete the future
        CompletableFuture<String> future3 = new CompletableFuture<>();
        future3.complete("It's done");
        System.out.println(future3.get());

        /**
         * If we want to execute the callbacks in different thread then we can use
         * async variations method
         */

        CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " | ")
                .thenApplyAsync((supplyResult) -> supplyResult + Thread.currentThread().getName() + " | ")
                .thenAcceptAsync(
                        (acceptResult) -> System.out.println(acceptResult + " " + Thread.currentThread().getName()))
                .get();

    }

}
