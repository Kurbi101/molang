package parser;

import types.Type;
import java.util.HashMap;

public class Scope {
    private final HashMap<String, Type> types;
    private final Scope parent;


    public Scope(Scope parent) {
        this.parent = parent;
        this.types = new HashMap<>();
    }

    public void define(String name, Type type) {
        if (resolveType(name) != null) {
            this.types.put(name, type);
        } else {
            throw new RuntimeException("Symbol " + name + " already defined in this scope");
        }
    }

    public Type resolveType(String name) {
        Scope current = this;
        while (current != null) {
            if (current.types.containsKey(name)) {
                    return current.types.get(name);
            }
            current = current.parent;
        }
        return null;
    }

}