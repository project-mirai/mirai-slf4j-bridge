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

import net.mamoe.mirai.logger.bridge.slf4j.NOPLoggerMarker;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MarkerFactoryBinder;

/**
 * SLF4J MarkerFactoryBinder implementation using Log4j. This class is part of the required classes used to specify an
 * SLF4J logging provider implementation.
 */
public final class StaticMarkerBinder implements MarkerFactoryBinder {

    /**
     * The unique instance of this class.
     */
    public static final StaticMarkerBinder SINGLETON = new StaticMarkerBinder();


    @Override
    public IMarkerFactory getMarkerFactory() {
        return NOPLoggerMarker.INSTANCE;
    }

    @Override
    public String getMarkerFactoryClassStr() {
        return NOPLoggerMarker.class.getName();
    }
}
