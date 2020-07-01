package com.ea.Framework.Controls.api;
/*
 * Internal Page Factory modification to align with the framework
 */


import com.ea.Framework.Controls.internals.ControlBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementedBy {
    Class<?> value() default ControlBase.class;
}
