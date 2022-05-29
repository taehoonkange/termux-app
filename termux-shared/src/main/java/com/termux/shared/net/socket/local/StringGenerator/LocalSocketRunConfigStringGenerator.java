package com.termux.shared.net.socket.local.StringGenerator;

import android.util.Pair;

import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;

public class LocalSocketRunConfigStringGenerator extends StringGenerator{
    private String mTitle;

    public LocalSocketRunConfigStringGenerator(String title) {
        mTitle = title;
    }

    @Override
    public void appendLogHeader(StringBuilder logString) {
        logString.append(mTitle).append(" Socket Server Run Config:");
    }

    @Override
    public boolean isLogMultiLine(String label) {
        return false;
    }

    @Override
    public void appendLogFooter(StringBuilder logString) {
    }

    @Override
    public void appendMarkdownHeader(StringBuilder markdownString) {
        markdownString.append("## ").append(mTitle).append(" Socket Server Run Config");
    }

    @Override
    public boolean isMarkdownMultiLine(String label) {
        return label.equals("Cmdline");
    }

    @Override
    public void appendMarkdownFooter(StringBuilder markdownString) {
    }

}
