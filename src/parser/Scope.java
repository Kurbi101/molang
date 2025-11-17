package parser;

import types.Type;
import java.util.HashMap;

public class Scope {
    //TODO: should probably just be a map of String to types, might change later
    private final HashMap<String, Symbol> symbols;
    private final HashMap<Symbol, Type> types;
    private final Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
        this.symbols = new HashMap<>();
        this.types = new HashMap<>();
    }

    public void define(String name, Type type) {
        if (resolveSymbol(name) != null) {
            Symbol symbol = new Symbol();
            this.symbols.put(name, symbol);
            this.types.put(symbol, type);
        } else {
            throw new RuntimeException("Symbol " + name + " already defined in this scope");
        }
    }

    public Symbol resolveSymbol(String name) {
        Scope current = this;
        while (current != null) {
            if (current.symbols.containsKey(name)) {
                return current.symbols.get(name);
            }
            current = current.parent;
        }
        return null;
    }

    public Type resolveType(String name) {
        Scope current = this;
        while (current != null) {
            if (current.symbols.containsKey(name)) {
                    return current.types.get(current.symbols.get(name));
            }
            current = current.parent;
        }
        return null;
    }

}