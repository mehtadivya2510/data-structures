package multithreading;

import java.util.concurrent.*;

public class AsyncProgramming {
    public static void main(String[] args) throws Exception {

        //callable - runs in a new thread & returns something
        Callable<Double> sum= ()->Math.random()*100+Math.random()*100;
        System.out.println(sum.call());

        //Callable task is submitted to executor & result is retrieved using future.get()
        Callable<String> name = ()->"Divya"+" "+"Mehta";
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future= service.submit(name);
        System.out.println(future.get());

        Future<Double> productFuture= service.submit(()->Math.random()*100*Math.random()*100);
        System.out.println(productFuture.get());

        Future<Double> divisionFuture= service.submit(()->Math.random()*100/0);
        System.out.println(divisionFuture.get());
        service.shutdown();

        //Completable Future- combination of Callable, Future & Executor Service
        CompletableFuture<String> address= CompletableFuture.supplyAsync(()-> "214 Baker Street"+" New York"+" - 345678");
        System.out.println(address.get());

        //Methods - thenCombine, allOf, exceptionally, thenCompose
        CompletableFuture<String> firstName= CompletableFuture.supplyAsync(()->"Gill");
        CompletableFuture<String> lastName= CompletableFuture.supplyAsync(()->"Goodaker");
        CompletableFuture<String> fullName = firstName.thenCombine(lastName, (m1,m2)->m1+" "+m2);
        System.out.println(fullName.get());

        CompletableFuture<Integer> composeFuture =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x * 2)
                        );
        System.out.println("composeFuture: "+composeFuture.get());

        CompletableFuture<Integer> num1= CompletableFuture.supplyAsync(()->10);
        CompletableFuture<Integer> num2= CompletableFuture.supplyAsync(()->20);
        CompletableFuture<Integer> num3= CompletableFuture.supplyAsync(()->30);
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(num1,num2,num3);
        allFuture.join();
        System.out.println(num2.get());

        CompletableFuture<Integer> divisionFut= CompletableFuture.supplyAsync(()->10/0)
                .exceptionally(ex->-1);
        System.out.println("exceptionally: "+divisionFut.get());

        CompletableFuture<CompletableFuture<Integer>> wrong =
                CompletableFuture.supplyAsync(() -> 30)
                        .thenApply(x -> CompletableFuture.supplyAsync(() -> x * 30));
        System.out.println("thenApply: "+wrong.get().get());

        CompletableFuture<Integer> correct =
                CompletableFuture.supplyAsync(() -> 30)
                        .thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 30));
        System.out.println("thenCompose: "+correct.get());

        BlockingQueue<Integer> blockingQueue= new ArrayBlockingQueue<>(5);
    }
}
