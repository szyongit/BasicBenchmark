package at.szyon.basicbenchmark.console;

public enum ConsoleChannel {
    ERROR("Error: "), OUTPUT(""), INPUT(""), CPU("CPU: "), RAM("RAM: ");

    private final String outputText;

    ConsoleChannel(String outputText) {
        this.outputText = outputText;
    }

    public final String getOutputText() {
        return this.outputText;
    }
}
