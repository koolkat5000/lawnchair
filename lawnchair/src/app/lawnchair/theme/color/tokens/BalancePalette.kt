/*
 * Copyright 2026, Balance Launcher contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.lawnchair.theme.color.tokens

/** Balance's surface palette; accents and app icons continue to use Lawnchair's theme. */
object BalancePalette {
    val Surface = DayNightColorToken(StaticColorToken(0xFFF7F8F4), StaticColorToken(0xFF080D17))
    val Glass = Surface.setAlpha(.93f)
    val Field = DayNightColorToken(StaticColorToken(0xFFF1F3F0), StaticColorToken(0xFF111722))
    val Raised = DayNightColorToken(StaticColorToken(0xFFF5F6F2), StaticColorToken(0xFF141B27))
    val Edge = DayNightColorToken(StaticColorToken(0xB3FFFFFF), StaticColorToken(0x25FFFFFF))
    val GlassHighlight = DayNightColorToken(StaticColorToken(0xF7F7F8F4), StaticColorToken(0xF0141B27))
}

/** Resolve the original token when Balance glass is disabled. */
fun ColorToken.withBalanceSurface(balanceToken: ColorToken): ColorToken = withPreferences { prefs ->
    if (prefs.balanceGlassTheme.get()) balanceToken else this
}
