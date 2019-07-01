package cc.bunnies.pocketsnacks.util;

/**
 * 用于函数返回多个值
 * @param <T>
 */
public class MultiResult<T> {
    public String message;
    public T data;

    public MultiResult() {

    }

    public MultiResult(String message, T data) {
        this.message = message;
        this.data = data;
    }
}