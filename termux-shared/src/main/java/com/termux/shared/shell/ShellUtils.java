package com.termux.shared.shell;

import com.termux.shared.file.FileUtils;
import com.termux.shared.view.ViewUtils;
import com.termux.terminal.TerminalBuffer;
import com.termux.terminal.TerminalEmulator;
import com.termux.terminal.TerminalSession;

import java.lang.reflect.Field;

public class ShellUtils {

    private ShellUtils() {}
    // initialization on demand holder idiom
    private static class ShellUtilsHolderIdiom {
        private static final ShellUtils instance = new ShellUtils();
    }
    // instance getter of singleton pattern
    public static ShellUtils getInstance() {
        return ShellUtils.ShellUtilsHolderIdiom.instance;
    }

    public int getPid(Process p) {
        int invalid = -1;
        try {
            Field f = p.getClass().getDeclaredField("pid");
            f.setAccessible(true);
            try {
                return f.getInt(p);
            } finally {
                f.setAccessible(false);
            }
        } catch (Throwable e) {
            return invalid;
        }
    }

    public String getExecutableBasename(String executable) {
        return FileUtils.getFileBasename(executable);
    }

    public String getTerminalSessionTranscriptText(TerminalSession terminalSession, boolean linesJoined, boolean trim) {
        if (terminalSession == null) return null;

        TerminalEmulator terminalEmulator = terminalSession.getEmulator();
        if (terminalEmulator == null) return null;

        TerminalBuffer terminalBuffer = terminalEmulator.getScreen();
        if (terminalBuffer == null) return null;

        String transcriptText;

        if (linesJoined)
            transcriptText = terminalBuffer.getTranscriptTextWithFullLinesJoined();
        else
            transcriptText = terminalBuffer.getTranscriptTextWithoutJoinedLines();

        if (transcriptText == null) return null;

        if (trim)
            transcriptText = transcriptText.trim();

        return transcriptText;
    }

}
