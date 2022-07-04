## SpectatorSendChunks

SpectatorSendChunks attempts to work around [MC-148993](https://bugs.mojang.com/browse/MC-148993) by re-setting the
player's spectated entity on a timer.

Please keep in mind that this plugin should only be used as a last resort, since it has several side effects (documented
below).
If you can, you should use a client mod like [Spectater](https://github.com/LazuriteMC/Spectater)
or [thorium](https://github.com/PotassiumMC/thorium/).

### Side effects

- When spectating a mob that has some kind of shader (creeper, enderman or spider), it will also be active when in third
  person view.
- The `PlayerStartSpectatingEntityEvent` or `PlayerStopSpectatingEntityEvent` will be triggered quite often, so plugins
  doing intensive calculations in those events may cause lag.
- This plugin will not work properly if another plugin cancels one of the events mentioned above.
