package mill
package playlib

import mill.define.Target
import mill.scalalib._

private[playlib] trait Version extends Module{
  def playVersion: T[String]

  private[playlib] def playMinorVersion: T[String] = T {
    playVersion().split("\\.").take(2).mkString("", ".", ".0")
  }

  private[playlib] def component(id: String): Target[Dep] = T{
    ivy"com.typesafe.play::$id::${playVersion()}"
  }
}
