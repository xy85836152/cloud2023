import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xy
 * @Date: 2023/4/14 17:38
 * @Description: 测试
 * @Version: v1.0
 */
public class CASTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean result =  atomicInteger.compareAndSet(5,2019);
        System.out.println(result+"\t"+atomicInteger.get());

        result =  atomicInteger.compareAndSet(5,2048);
        System.out.println(result+"\t"+atomicInteger.get());
    }
}
