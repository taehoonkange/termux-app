package com.termux.shared.net.socket.local.StringGenerator;

import android.util.Pair;

import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;

import java.util.List;

public class PeerCredStringGenerator extends StringGenerator{
    @Override
    public void appendLogHeader(StringBuilder logString) {
        logString.append("Peer Cred:");
    }

    @Override
    public boolean isLogMultiLine(String label) {
        return label.equals("Cmdline");
    }

    @Override
    public void appendLogFooter(StringBuilder logString) {
    }

    @Override
    public String getMarkdownString() {
        StringBuilder markdownString = new StringBuilder();

        markdownString.append("## ").append("Peer Cred");

        for (Pair<String, Object> logVar: getLogVariableList()) {
            String label = logVar.first;
            Object object = logVar.second;
            switch(label) {
                case "Cmdline":
                    if (label != null) markdownString.append("\n").append(MarkdownUtils.getMultiLineMarkdownStringEntry(label, object, "-"));
                    break;
                default:
                    markdownString.append("\n").append(MarkdownUtils.getSingleLineMarkdownStringEntry(label, object, "-"));
            }
        }

        return markdownString.toString();
    }
}
