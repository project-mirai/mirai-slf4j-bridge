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

import org.slf4j.IMarkerFactory
import org.slf4j.Marker
import java.util.*

internal object NOPLoggerMarker : IMarkerFactory {
    private class NOPMarker(@JvmField private val name: String) : Marker {
        override fun getName(): String = name

        override fun add(reference: Marker?) {
        }

        override fun remove(reference: Marker?): Boolean = true

        override fun hasChildren(): Boolean = false

        override fun hasReferences(): Boolean = false

        override fun iterator(): MutableIterator<Marker> = Collections.emptyIterator()

        override fun contains(other: Marker?): Boolean = false

        override fun contains(name: String?): Boolean = false
    }

    override fun getMarker(name: String?): Marker = NOPMarker(name ?: "<unknown>")

    override fun exists(name: String?): Boolean = false

    override fun detachMarker(name: String?): Boolean = false

    override fun getDetachedMarker(name: String?): Marker = getMarker(name)
}