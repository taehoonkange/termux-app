package com.termux.shared.data.StringBuilder;

import com.termux.shared.logger.Logger;

public class LogStringBuilder implements ObjectStringBuilder{
    private StringBuilder builder = new StringBuilder();

    @Override
    public void append(String string) {
        builder.append(string);
    }

    @Override
    public void appendTitle(String title) {
        builder.append(title);
    }

    @Override
    public void appendSLEntry(String label, Object object) {
        builder.append("\n").append(Logger.getSingleLineLogStringEntry(label, object, "-"));
    }

    @Override
    public void appendMLEntry(String label, Object object) {
        builder.append("\n").append(Logger.getMultiLineLogStringEntry(label, object, "-"));
    }

    @Override
    public String getString() {
        return builder.toString();
    }
}
