import sbt._, Keys._

object Dependencies {
  lazy val MetaVersion     = "1.8.0"
  lazy val ParadiseVersion = "3.0.0-M10"
  lazy val scala212        = "2.12.3"
  lazy val scalameta       = "org.scalameta" %% "scalameta" % MetaVersion
  lazy val contrib         = "org.scalameta" %% "contrib" % MetaVersion
  lazy val testkit         = "org.scalameta" %% "testkit" % MetaVersion
  lazy val paradise        = "org.scalameta" % "paradise" % ParadiseVersion cross CrossVersion.full
}