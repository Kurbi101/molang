package emitter;

public interface Emitter {

    void emit(String s);

    default void emitln(String s) {
        emit(s + "\n");
    }

}
