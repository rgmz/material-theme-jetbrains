/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chrisrm.idea.ui;

import com.intellij.ide.ui.laf.darcula.ui.DarculaScrollBarUI;
import com.intellij.openapi.util.SystemInfo;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

import static com.intellij.util.ReflectionUtil.newInstance;

/**
 * @author Konstantin Bulenkov
 */
@Deprecated
public class MTScrollBarUI extends DarculaScrollBarUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        try {
            return (ComponentUI) newInstance(Class.forName(SystemInfo.isMac
                                                           ? "com.intellij.ui.components.MacScrollBarUI"
                                                           : "com.intellij.ui.components.DefaultScrollBarUI"));
        }
        catch (Exception ignore) {
        }
        return new MTScrollBarUI();
    }
}
