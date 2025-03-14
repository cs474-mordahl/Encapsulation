val scala3Version = "3.6.4"

lazy val root = project
  .in(file("."))
  .settings(
    name              := "Encapsulation",
    version           := "0.1.0-SNAPSHOT",
    scalaVersion      := scala3Version,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions ++= Seq(
      "-Wunused:all"
    ),

    /* Uncomment the next two lines if you want scalafmt and scalafix to run
     * whenever your code is compiled.
     *
     * I would suggest keeping it on for scalaFix, but enabling "format on save"
     * in your IDE instead of using scalafmtOnCompile */
    // scalafmtOnCompile := true,
    scalafixOnCompile := true,

    // Test Dependencies
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
