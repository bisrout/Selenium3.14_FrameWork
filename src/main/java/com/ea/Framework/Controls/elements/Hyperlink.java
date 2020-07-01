package com.ea.Framework.Controls.elements;

import com.ea.Framework.Controls.api.ImplementedBy;
import com.ea.Framework.Controls.internals.Control;

@ImplementedBy(HyperlinkBase.class)
public interface Hyperlink extends Control {
    void ClickLink();
    String GetUrlText();
    boolean CheckUrlTextContains(String containsText);
}
