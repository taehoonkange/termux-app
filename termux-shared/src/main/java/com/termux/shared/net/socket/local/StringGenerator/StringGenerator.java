package com.termux.shared.net.socket.local.StringGenerator;

import android.util.Pair;

import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;

import java.util.List;

// Singleton 적용하기
public abstract class StringGenerator {
    private List<Pair<String, Object>> logVariableList = null;

    public void setLogVariableList(List<Pair<String, Object>> logVariableList) {
        this.logVariableList = logVariableList;
    }

    public List<Pair<String, Object>> getLogVariableList() {
        return logVariableList;
    }

    public String getLogString() {
        StringBuilder logString = new StringBuilder();

        appendLogHeader(logString);

        for(Pair<String, Object> logVar: getLogVariableList()) {
            String label = logVar.first;
            Object object = logVar.second;
            if (isLogMultiLine(label))
                logString.append("\n").append(Logger.getMultiLineLogStringEntry(label, object, "-"));
            else
                logString.append("\n").append(Logger.getSingleLineLogStringEntry(label, object, "-"));
        }

        appendLogFooter(logString);

        return logString.toString();
    }

    public abstract void appendLogHeader(StringBuilder logString);
    public abstract boolean isLogMultiLine(String label);
    public abstract void appendLogFooter(StringBuilder logString);

    public String getMarkdownString() {
        StringBuilder markdownString = new StringBuilder();

        appendMarkdownHeader(markdownString);

        for (Pair<String, Object> logVar: getLogVariableList()) {
            String label = logVar.first;
            Object object = logVar.second;
            if (isMarkdownMultiLine(label))
                markdownString.append("\n").append(MarkdownUtils.getMultiLineMarkdownStringEntry(label, object, "-"));
            else
                markdownString.append("\n").append(MarkdownUtils.getSingleLineMarkdownStringEntry(label, object, "-"));
        }

        appendMarkdownFooter(markdownString);

        return markdownString.toString();
    }

    public abstract void appendMarkdownHeader(StringBuilder logString);
    public abstract boolean isMarkdownMultiLine(String label);
    public abstract void appendMarkdownFooter(StringBuilder logString);

}
