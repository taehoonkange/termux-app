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
    public void appendMarkdownHeader(StringBuilder markdownString) {
        markdownString.append("Peer Cred:");
    }

    @Override
    public boolean isMarkdownMultiLine(String label) {
        return label.equals("Cmdline");
    }

    @Override
    public void appendMarkdownFooter(StringBuilder markdownString) {
    }

}
