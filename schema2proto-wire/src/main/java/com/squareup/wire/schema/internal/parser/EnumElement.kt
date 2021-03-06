/*
 * Copyright (C) 2013 Square, Inc.
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
package com.squareup.wire.schema.internal.parser

import com.squareup.wire.schema.Location
import com.squareup.wire.schema.internal.Util.appendDocumentation
import com.squareup.wire.schema.internal.Util.appendIndented

data class EnumElement(
        override val location: Location,
        override val name: String,
        override val documentation: String = "",
        override val options: List<OptionElement> = emptyList(),
        val constants: List<EnumConstantElement> = emptyList()
) : TypeElement {
    // Enums do not allow nested type declarations.
    override val nestedTypes: List<TypeElement> = emptyList()

    override fun toSchema() = buildString {
        appendDocumentation(this, documentation)
        append("enum $name {")

        if (options.isNotEmpty()) {
            append('\n')
            for (option in options) {
                appendIndented(this, option.toSchemaDeclaration())
            }
        }
        if (constants.isNotEmpty()) {
            append('\n')
            for (constant in constants) {
                appendIndented(this, constant.toSchema())
            }
        }
        append("}\n")
    }
}
