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

import net.mamoe.mirai.utils.MiraiLogger
import org.apache.logging.log4j.message.ParameterizedMessage
import org.slf4j.Logger
import org.slf4j.Marker
import java.text.MessageFormat
import java.util.regex.Pattern

@Suppress("RemoveRedundantSpreadOperator")
internal class MiraiLoggerSlf4jBridge(
    private val logger: MiraiLogger
) : Logger {
    // Copied from Log4J
    private companion object {
        private const val FORMAT_SPECIFIER = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])"
        private val MSG_PATTERN = Pattern.compile(FORMAT_SPECIFIER)

        private fun String.format1(vararg arguments: Any?): String = format2(arguments)
        private fun String.format2(args: Array<out Any?>): String {
            // Copied from Log4J
            kotlin.runCatching {
                return MessageFormat(this).format(args)
            }
            kotlin.runCatching {
                if (MSG_PATTERN.matcher(this).find()) {
                    return String.format(this, *args)
                }
            }
            kotlin.runCatching {
                // Try format with Log4J
                return ParameterizedMessage(this, *args).formattedMessage
            }
            return this
        }
    }

    //////////////////////////////////////////////////////////////////
    // Mirai Logger not supported level enabled
    override fun isTraceEnabled(): Boolean = true
    override fun isTraceEnabled(marker: Marker?): Boolean = true
    override fun isDebugEnabled(): Boolean = true
    override fun isDebugEnabled(marker: Marker?): Boolean = true
    override fun isInfoEnabled(): Boolean = true
    override fun isInfoEnabled(marker: Marker?): Boolean = true
    override fun isWarnEnabled(): Boolean = true
    override fun isWarnEnabled(marker: Marker?): Boolean = true
    override fun isErrorEnabled(): Boolean = true
    override fun isErrorEnabled(marker: Marker?): Boolean = true
    //////////////////////////////////////////////////////////////////

    override fun getName(): String = logger.identity ?: "<unknown>"

    //////////////////////////////////////////////////////////////////

    override fun trace(msg: String?) {
        logger.verbose(msg)
    }

    override fun trace(msg: String?, t: Throwable?) {
        logger.verbose(msg, t)
    }

    override fun trace(format: String, arg: Any?) = trace(format.format1(arg))
    override fun trace(format: String, arg1: Any?, arg2: Any?) = trace(format.format1(arg1, arg2))
    override fun trace(format: String, arguments: Array<out Any?>) = trace(format.format2(arguments))

    override fun trace(marker: Marker?, msg: String?) = trace(msg)
    override fun trace(marker: Marker?, format: String, arg: Any?) = trace(format, arg)
    override fun trace(marker: Marker?, format: String, arg1: Any?, arg2: Any?) = trace(format, arg1, arg2)
    override fun trace(marker: Marker?, format: String, argArray: Array<out Any?>) = trace(format, argArray)
    override fun trace(marker: Marker?, msg: String?, t: Throwable?) = trace(msg, t)

    //////////////////////////////////////////////////////////////////

    override fun debug(msg: String?) {
        logger.debug(msg)
    }

    override fun debug(msg: String?, t: Throwable?) {
        logger.debug(msg, t)
    }

    override fun debug(format: String, arg: Any?) = debug(format.format1(arg))
    override fun debug(format: String, arg1: Any?, arg2: Any?) = debug(format.format1(arg1, arg2))
    override fun debug(format: String, arguments: Array<out Any?>) = debug(format.format2(arguments))

    override fun debug(marker: Marker?, msg: String?) = debug(msg)
    override fun debug(marker: Marker?, format: String, arg: Any?) = debug(format, arg)
    override fun debug(marker: Marker?, format: String, arg1: Any?, arg2: Any?) = debug(format, arg1, arg2)
    override fun debug(marker: Marker?, format: String, arguments: Array<out Any?>) = debug(format, arguments)
    override fun debug(marker: Marker?, msg: String?, t: Throwable?) = debug(msg, t)

    //////////////////////////////////////////////////////////////////

    override fun info(msg: String?) {
        logger.info(msg)
    }

    override fun info(msg: String?, t: Throwable?) {
        logger.info(msg, t)
    }

    override fun info(format: String, arg: Any?) = info(format.format1(arg))
    override fun info(format: String, arg1: Any?, arg2: Any?) = info(format.format1(arg1, arg2))
    override fun info(format: String, arguments: Array<out Any?>) = info(format.format2(arguments))

    override fun info(marker: Marker?, msg: String?) = info(msg)
    override fun info(marker: Marker?, format: String, arg: Any?) = info(format, arg)
    override fun info(marker: Marker?, format: String, arg1: Any?, arg2: Any?) = info(format, arg1, arg2)
    override fun info(marker: Marker?, format: String, arguments: Array<out Any?>) = info(format, arguments)
    override fun info(marker: Marker?, msg: String?, t: Throwable?) = info(msg, t)

    //////////////////////////////////////////////////////////////////

    override fun warn(msg: String?) {
        logger.warning(msg)
    }

    override fun warn(msg: String?, t: Throwable?) {
        logger.warning(msg, t)
    }

    override fun warn(format: String, arg: Any?) = warn(format.format1(arg))
    override fun warn(format: String, arguments: Array<out Any?>) = warn(format.format2(arguments))
    override fun warn(format: String, arg1: Any?, arg2: Any?) = warn(format.format1(arg1, arg2))

    override fun warn(marker: Marker?, msg: String?) = warn(msg)
    override fun warn(marker: Marker?, format: String, arg: Any?) = warn(format, arg)
    override fun warn(marker: Marker?, format: String, arg1: Any?, arg2: Any?) = warn(format, arg1, arg2)
    override fun warn(marker: Marker?, format: String, arguments: Array<out Any?>) = warn(format, arguments)
    override fun warn(marker: Marker?, msg: String?, t: Throwable?) = warn(msg, t)

    //////////////////////////////////////////////////////////////////

    override fun error(msg: String?) {
        logger.error(msg)
    }

    override fun error(msg: String?, t: Throwable?) {
        logger.error(msg, t)
    }

    override fun error(format: String, arg: Any?) = error(format.format1(arg))
    override fun error(format: String, arg1: Any?, arg2: Any?) = error(format.format1(arg1, arg2))
    override fun error(format: String, arguments: Array<out Any?>) = error(format.format2(arguments))

    override fun error(marker: Marker?, msg: String?) = error(msg)
    override fun error(marker: Marker?, format: String, arg: Any?) = error(format, arg)
    override fun error(marker: Marker?, format: String, arg1: Any?, arg2: Any?) = error(format, arg1, arg2)
    override fun error(marker: Marker?, format: String, arguments: Array<out Any?>) = error(format, arguments)
    override fun error(marker: Marker?, msg: String?, t: Throwable?) = error(msg, t)

}