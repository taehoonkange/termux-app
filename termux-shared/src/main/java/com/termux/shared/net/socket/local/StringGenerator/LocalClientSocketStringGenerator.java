package com.termux.shared.net.socket.local.StringGenerator;

import android.util.Pair;

import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;
import com.termux.shared.net.socket.local.PeerCred;

public class LocalClientSocketStringGenerator extends StringGenerator{
    private PeerCred mPeerCred;

    public LocalClientSocketStringGenerator(PeerCred peerCred) {
        mPeerCred = peerCred;
    }

    @Override
    public String getLogString() {
        StringBuilder logString = new StringBuilder();

        logString.append("Client Socket:");

        for (Pair<String, Object> logVar: getLogVariableList()) {
            String label = logVar.first;
            Object object = logVar.second;
            logString.append("\n").append(Logger.getSingleLineLogStringEntry(label, object, "-"));
        }

        logString.append("\n\n\n");

        logString.append(mPeerCred.getLogString());

        return logString.toString();
    }

    @Override
    public String getMarkdownString() {
        StringBuilder markdownString = new StringBuilder();

        markdownString.append("## ").append("Client Socket");

        for (Pair<String, Object> logVar: getLogVariableList()) {
            String label = logVar.first;
            Object object = logVar.second;
            markdownString.append("\n").append(MarkdownUtils.getSingleLineMarkdownStringEntry(label, object, "-"));
        }

        markdownString.append("\n\n\n");

        markdownString.append(mPeerCred.getMarkdownString());

        return markdownString.toString();
    }
}
