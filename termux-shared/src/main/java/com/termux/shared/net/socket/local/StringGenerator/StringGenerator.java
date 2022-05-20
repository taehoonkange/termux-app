package com.termux.shared.net.socket.local.StringGenerator;

import android.util.Pair;

import com.termux.shared.logger.Logger;

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

    public abstract String getMarkdownString();


}
