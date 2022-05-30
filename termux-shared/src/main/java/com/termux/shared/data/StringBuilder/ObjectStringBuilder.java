package com.termux.shared.data.StringBuilder;

public interface ObjectStringBuilder {
    public void append(String string);
    public void appendTitle(String title);
    public void appendSLEntry(String label, Object object);
    public void appendMLEntry(String label, Object object);
    public String getString();
}
