package com.termux.shared.net.socket.local;

import android.content.Context;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.termux.shared.android.ProcessUtils;
import com.termux.shared.android.UserUtils;
import com.termux.shared.data.StringBuilder.LogStringBuilder;
import com.termux.shared.data.StringBuilder.MarkdownStringBuilder;
import com.termux.shared.data.StringBuilder.ObjectStringBuilder;
import com.termux.shared.logger.Logger;
import com.termux.shared.markdown.MarkdownUtils;

/** The {@link PeerCred} of the {@link LocalClientSocket} containing info of client/peer. */
@Keep
public class PeerCred {

    public static final String LOG_TAG = "PeerCred";

    /** Process Id. */
    public int pid;
    /** Process Name. */
    public String pname;

    /** User Id. */
    public int uid;
    /** User name. */
    public String uname;

    /** Group Id. */
    public int gid;
    /** Group name. */
    public String gname;

    /** Command line that started the process. */
    public String cmdline;

    PeerCred() {
        // Initialize to -1 instead of 0 in case a failed getPeerCred()/getsockopt() call somehow doesn't report failure and returns the uid of root
        pid = -1; uid = -1; gid = -1;
    }

    /** Set data that was not set by JNI. */
    public void fillPeerCred(@NonNull Context context) {
        fillUnameAndGname(context);
        fillPname(context);
    }

    /** Set {@link #uname} and {@link #gname} if not set. */
    public void fillUnameAndGname(@NonNull Context context) {
        uname = UserUtils.getNameForUid(context, uid);

        if (gid != uid)
            gname = UserUtils.getNameForUid(context, gid);
        else
            gname = uname;
    }

    /** Set {@link #pname} if not set. */
    public void fillPname(@NonNull Context context) {
        // If jni did not set process name since it wouldn't be able to access /proc/<pid> of other
        // users/apps, then try to see if any app has that pid, but this wouldn't check child
        // processes of the app.
        if (pid > 0 && pname == null)
            pname = ProcessUtils.getAppProcessNameForPid(context, pid);
    }

    /**
     * Get a log {@link String} for {@link PeerCred}.
     *
     * @param peerCred The {@link PeerCred} to get info of.
     * @return Returns the log {@link String}.
     */
    @NonNull
    public static String getPeerCredLogString(final PeerCred peerCred) {
        if (peerCred == null) return "null";
        return peerCred.getLogString();
    }

    /** Get a log {@link String} by {@link LogStringBuilder} for the {@link PeerCred}. */
    @NonNull
    public String getLogString() {
        return getObjectString(new LogStringBuilder());
    }

    /**
     * Get a markdown {@link String} for {@link PeerCred}.
     *
     * @param peerCred The {@link PeerCred} to get info of.
     * @return Returns the markdown {@link String}.
     */
    public static String getPeerCredMarkdownString(final PeerCred peerCred) {
        if (peerCred == null) return "null";
        return peerCred.getMarkdownString();
    }

    /** Get a markdown {@link String} by {@link MarkdownStringBuilder} for the {@link PeerCred}. */
    @NonNull
    public String getMarkdownString() {
        return getObjectString(new MarkdownStringBuilder());
    }

    /** Get a log {@link String} by the type of {@link ObjectStringBuilder} for the {@link PeerCred}. */
    @NonNull
    public String getObjectString(ObjectStringBuilder builder) {
        builder.appendTitle("Peer Cred");
        builder.appendSLEntry("Process", getProcessString());
        builder.appendSLEntry("User", getUserString());
        builder.appendSLEntry("Group", getGroupString());

        if (cmdline != null)
            builder.appendMLEntry("Cmdline", cmdline);

        return builder.getString();
    }

    @NonNull
    public String getMinimalString() {
        return "process=" + getProcessString() + ", user=" + getUserString() + ", group=" + getGroupString();
    }

    @NonNull
    public String getProcessString() {
        return pname != null && !pname.isEmpty() ? pid + " (" + pname + ")" : String.valueOf(pid);
    }

    @NonNull
    public String getUserString() {
        return uname != null ? uid + " (" + uname + ")" : String.valueOf(uid);
    }

    @NonNull
    public String getGroupString() {
        return gname != null ? gid + " (" + gname + ")" : String.valueOf(gid);
    }

}
