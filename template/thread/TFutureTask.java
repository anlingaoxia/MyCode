package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TFutureTask {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        };
        FutureTask<Integer> task = new FutureTask<Integer>(callable) {
            @Override
            protected void done() {
                super.done();
            }
        };


    }


}
