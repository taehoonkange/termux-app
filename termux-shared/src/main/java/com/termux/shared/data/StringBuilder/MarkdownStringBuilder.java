package com.termux.shared.data.StringBuilder;

import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;

public class MarkdownStringBuilder implements ObjectStringBuilder {
    private StringBuilder builder = new StringBuilder();

    @Override
    public void append(String string) {
        builder.append(string);
    }

    @Override
    public void appendTitle(String title) {
        builder.append("## ").append(title);
    }

    @Override
    public void appendSLEntry(String label, Object object) {
        builder.append("\n").append(MarkdownUtils.getSingleLineMarkdownStringEntry(label, object, "-"));
    }

    @Override
    public void appendMLEntry(String label, Object object) {
        builder.append("\n").append(MarkdownUtils.getMultiLineMarkdownStringEntry(label, object, "-"));
    }

    @Override
    public String getString() {
        return builder.toString();
    }
}
