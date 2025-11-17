package emitter.c_emitter;

import emitter.Context;
import emitter.Emitter;

import java.util.ArrayList;

public class CContext extends Context {
    private final ArrayList<String> HFileContent;
    private StringBuilder currentHLine;
    private final ArrayList<String> staticImports;
    private final ArrayList<String> dynamicImports;


    public CContext(String dir, String filename, Emitter.ContextKind kind) {
        super(dir, filename, kind);
        this.HFileContent = new ArrayList<>();
        this.staticImports = new ArrayList<>();
        this.dynamicImports = new ArrayList<>();
        this.currentHLine = new StringBuilder();

        this.staticImports.add("stdlib");
        this.staticImports.add("stdio");

    }

    public void writeH(String s) {
        this.currentHLine.append(s);
    }

    public void writeHln(String s) {
        this.currentHLine.append(s);
        this.HFileContent.add(this.currentHLine.toString());
        this.currentHLine = new StringBuilder();
    }

    private void writeImports() {
        for (String importName : this.staticImports) {
            this.writeHln("#include <" + importName + ">");
        }
        this.writeHln("");
        for (String importName : this.dynamicImports) {
            this.writeHln("#include \"" + importName + ".h\"");
        }
        this.writeHln("");
    }

    @Override
    public void writeHeader() {
        writeHln("#ifndef " + this.fileName.toUpperCase() + "_H");
        writeHln("#define " + this.fileName.toUpperCase() + "_H");
        writeHln("");
        writeImports();

        writeln("#include " + this.fileName + ".h");
        writeln("");
        writeln("int main() {");
    }

    @Override
    public void writeFooter() {
        writeHln("#endif");

        writeln("return 0;");
        writeln("}");
    }
}
