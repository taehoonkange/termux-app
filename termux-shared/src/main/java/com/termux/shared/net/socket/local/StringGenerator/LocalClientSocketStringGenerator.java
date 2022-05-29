package com.termux.shared.net.socket.local.StringGenerator;

import com.termux.shared.net.socket.local.PeerCred;

public class LocalClientSocketStringGenerator extends StringGenerator{
    private PeerCred mPeerCred;

    public LocalClientSocketStringGenerator(PeerCred peerCred) {
        mPeerCred = peerCred;
    }

    @Override
    public void appendLogHeader(StringBuilder logString) {
        logString.append("Client Socket:");
    }

    @Override
    public boolean isLogMultiLine(String label) {
        return false;
    }

    @Override
    public void appendLogFooter(StringBuilder logString) {
        logString.append("\n\n\n");
        logString.append(mPeerCred.getLogString());
    }

    @Override
    public void appendMarkdownHeader(StringBuilder markdownString) {
        markdownString.append("## ").append("Client Socket");
    }

    @Override
    public boolean isMarkdownMultiLine(String label) {
        return label.equals("Cmdline");
    }

    @Override
    public void appendMarkdownFooter(StringBuilder markdownString) {
        markdownString.append("\n\n\n");
        markdownString.append(mPeerCred.getMarkdownString());

    }

}
