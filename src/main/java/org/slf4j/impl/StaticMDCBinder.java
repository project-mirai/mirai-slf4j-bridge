/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE version 3 license that can be found via the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 *
 */

package org.slf4j.impl;

import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.spi.MDCAdapter;

public final class StaticMDCBinder {

    /**
     * The unique instance of this class.
     */
    public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

    public static StaticMDCBinder getSingleton() {
        return SINGLETON;
    }

    private StaticMDCBinder() {
    }

    /**
     * Currently this method always returns an instance of {@link StaticMDCBinder}.
     *
     * @return an MDC adapter
     */
    public MDCAdapter getMDCA() {
        return new BasicMDCAdapter();
    }

    /**
     * Retrieve the adapter class name.
     *
     * @return The adapter class name.
     */
    public String getMDCAdapterClassStr() {
        return BasicMDCAdapter.class.getName();
    }
}
