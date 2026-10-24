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

package app.lawnchair.theme.drawable

import android.graphics.drawable.GradientDrawable
import app.lawnchair.preferences.PreferenceManager
import app.lawnchair.theme.color.tokens.BalancePalette
import kotlin.math.roundToInt

/** Decorate existing sheet shapes without changing their corners, bounds or touch areas. */
fun <T : GradientDrawable> DrawableToken<T>.withBalanceGlass() = mutate { context, scheme, uiColorMode ->
    if (PreferenceManager.getInstance(context).balanceGlassTheme.get()) {
        mutate()
        gradientType = GradientDrawable.LINEAR_GRADIENT
        orientation = GradientDrawable.Orientation.TL_BR
        colors = intArrayOf(
            BalancePalette.GlassHighlight.resolveColor(context, scheme, uiColorMode),
            BalancePalette.Glass.resolveColor(context, scheme, uiColorMode),
        )
        val edgeWidth = context.resources.displayMetrics.density.roundToInt().coerceAtLeast(1)
        setStroke(edgeWidth, BalancePalette.Edge.resolveColor(context, scheme, uiColorMode))
    }
}
