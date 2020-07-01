package com.ea.Framework.Controls.elements;

import com.ea.Framework.Controls.api.ImplementedBy;
import com.ea.Framework.Controls.internals.Control;
@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {
    public void EnterText(String text);
    public String GetTextValue();

}
