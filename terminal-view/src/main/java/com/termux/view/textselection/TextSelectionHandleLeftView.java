package com.termux.view.textselection;

import android.graphics.Rect;

import com.termux.view.TerminalView;
import com.termux.view.R;

public class TextSelectionHandleLeftView extends TextSelectionHandleView {
    private boolean isInverse;

    public TextSelectionHandleLeftView(TerminalView terminalView, CursorController cursorController) {
        super(terminalView, cursorController);

        mHandleDrawable = getContext().getDrawable(R.drawable.text_select_handle_left_material);
        setOrientation();
    }

    @Override
    public void setOrientation() {
        isInverse = false;

        int handleWidth = mHandleDrawable.getIntrinsicWidth();
        setCommonOrientation(handleWidth);

        mHotspotX = (handleWidth * 3) / (float) 4;
        mHotspotY = 0;
        invalidate();
    }

    private void setInverseOrientation() {
        isInverse = true;
        int handleWidth = mHandleDrawable.getIntrinsicWidth();
        setCommonOrientation(handleWidth);

        mHotspotX = handleWidth / (float) 4;
        mHotspotY = 0;
        invalidate();
    }

    @Override
    public void changeOrientation(int posX, final Rect clip) {
        if (posX - mHandleWidth < clip.left) {
            if(!isInverse) setInverseOrientation();
        } else {
            if(isInverse) setOrientation();
        }
    }
}
