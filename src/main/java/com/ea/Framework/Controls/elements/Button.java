package com.ea.Framework.Controls.elements;

import com.ea.Framework.Controls.api.ImplementedBy;
import com.ea.Framework.Controls.internals.Control;
@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

     void PerformClick();
     String GetButtonText();
     void PerformSubmit();

}
