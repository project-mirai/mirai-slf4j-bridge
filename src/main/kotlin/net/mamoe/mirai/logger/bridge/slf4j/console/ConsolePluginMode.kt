/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE version 3 license that can be found via the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 *
 */

package net.mamoe.mirai.logger.bridge.slf4j.console

import com.google.auto.service.AutoService
import io.github.karlatemp.unsafeaccessor.Root
import io.github.karlatemp.unsafeaccessor.Unsafe
import net.mamoe.mirai.console.plugin.jvm.JvmPlugin
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.logger.bridge.slf4j.MiraiLoggerSlf4jFactoryNOP
import org.slf4j.LoggerFactory

@Suppress("LocalVariableName")
@AutoService(JvmPlugin::class)
internal object ConsolePluginMode : KotlinPlugin(
    // JvmPluginDescriptionBuilder 在 1.0-M4 到 1.0-RC-dev? 都工作
    JvmPluginDescriptionBuilder(name = "mirai-slf4j-bridge", version = "1.0.0")
        .id("net.mamoe.mirai.mirai-slf4j-bridge")
        .author("Karlatemp")
        .build()
) {
    init {
        kotlin.runCatching {
            Class.forName("android.view.View")
            // Unsafe 100% 无法在 Android 平台工作
            logger.error("Mirai Logger Binding Slf4j with Console Plugin mode NOT SUPPORTED on Android")
        }.onFailure {
            // 如果不使用 Unsafe, 将无法修改 static final 字段
            val unsafe = Unsafe.getUnsafe()
            val LF = LoggerFactory::class.java
            unsafe.ensureClassInitialized(LF)
            val field = LF.getDeclaredField("NOP_FALLBACK_FACTORY")
            val LFBase = unsafe.staticFieldBase(field)
            val LFOffset = unsafe.staticFieldOffset(field)
            unsafe.putReference(LFBase, LFOffset, MiraiLoggerSlf4jFactoryNOP)

            val INITIALIZATION_STATE = LF.getDeclaredField("INITIALIZATION_STATE")
            val NOP_FALLBACK_INITIALIZATION = LF.getDeclaredField("NOP_FALLBACK_INITIALIZATION")
            Root.openAccess(INITIALIZATION_STATE)
            Root.openAccess(NOP_FALLBACK_INITIALIZATION)
            INITIALIZATION_STATE.setInt(null, NOP_FALLBACK_INITIALIZATION.getInt(null))
            logger.debug("SLF4J LOGGER FACTORY = " + LoggerFactory.getILoggerFactory())
        }
    }
}
