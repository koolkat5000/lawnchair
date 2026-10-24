# Balance theme for Lawnchair 16

This branch starts from Lawnchair's `16-dev` at
`793ac98db2d4339ba07bf7cfede23b469479e965`. It keeps the upstream launcher
structure and applies Balance's surface styling in small steps.

## First appearance pass

- Warm pale surfaces in light mode (`#F7F8F4`) and blue-black surfaces in dark
  mode (`#080D17`), drawn from the Balance app.
- The app drawer starts at 93% opacity on a new installation. Its existing
  opacity slider and custom background colour continue to work.
- Floating menus use the Balance palette. Widget sheets gain a subtle diagonal
  light falloff and a thin translucent edge, using their existing shapes.
- **Settings → General → Colours → Balance glass** switches the surface palette.
  Switching it does not reset the user's drawer opacity or custom colours.

The app drawer remains a solid-colour translucent scrim so Lawnchair's header
protection, text contrast and system-bar handling can continue to work. Glass
gradients are applied only to supported sheet drawables. There is no extra blur
or continuous rendering loop in this pass.

Icons, grid sizes, widgets, long-press actions, swipe gestures, drawer scrolling
and scrollbar handling retain Lawnchair's implementation. The original Balance
Launcher's custom scroll mechanics have not been ported.

## Preview build

The **Balance theme preview** Actions workflow checks Kotlin formatting and
builds `assembleLawnWithQuickstepGithubDebug` on pushes to `balance-theme`.
The APK uses Lawnchair's existing debug package, `app.lawnchair.debug`, so it
can be tested alongside the earlier standalone Balance Launcher. It is a
development build rather than a release package.

## Next visual steps

Check the drawer, menus and widget sheet on the target OxygenOS 16 device in
both light and dark modes. Tune opacity and surface highlights from those
screenshots before changing geometry. Balance's moving atmosphere background
and further texture work are follow-up changes; they are not included here.

Upstream Apache 2.0 licensing and attribution are retained. Modified source
files identify the Balance surface changes beside the relevant implementation.
