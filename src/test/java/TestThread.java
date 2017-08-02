/**
 * Created by zhiyongliu3 on 2017/8/2.
 */
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

    private static final String base = "0123456789abcdef";
    private static final Random random = new Random();
    private static ThreadLocal<StringBuilder> local = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public static String generate(int length) {
        StringBuilder sb = local.get();
        for (int i = 0; i < length; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(generate(16));
                }
            });

        }
    }
}