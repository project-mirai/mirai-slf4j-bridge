/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE version 3 license that can be found via the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 *
 */

package net.mamoe.mirai.logger.bridge.slf4j

import org.slf4j.Logger
import org.slf4j.helpers.NOPLoggerFactory

internal object MiraiLoggerSlf4jFactoryNOP : NOPLoggerFactory() {
    override fun getLogger(name: String?): Logger = MiraiLoggerSlf4jFactory.getLogger(name)
}