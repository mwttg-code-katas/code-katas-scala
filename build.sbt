name := "code-katas-scala"

version := "0.1"

lazy val commonSettings = Seq(
  scalaVersion := "2.12.8",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

lazy val `kata_2018-12-number-scanner` = (project in file("kata_2018-12-number-scanner"))
  .settings(commonSettings)

lazy val `kata_2019-01-fizz-fuzz-boom` = (project in file("kata_2019-01-fizz-fuzz-boom"))
  .settings(commonSettings)

lazy val `kata_2019-02-moby-dick` = (project in file("kata_2019-02-moby-dick"))
  .settings(commonSettings)

lazy val `kata_2019-03-berlin-clock` = (project in file("kata_2019-03-berlin-clock"))
  .settings(commonSettings)

lazy val `kata_2019-04-word-puzzle` = (project in file("kata_2019-04-word-puzzle"))
  .settings(commonSettings)

lazy val `kata_2019-05-landing-rover` = (project in file("kata_2019-05-landing-rover"))
  .settings(commonSettings)

lazy val `kata_2019-06-staircase-problem` = (project in file("kata_2019-06-staircase-problem"))
  .settings(commonSettings)

lazy val `kata_2019-07-sudoku` = (project in file("kata_2019-07-sudoku"))
  .settings(commonSettings)

lazy val `kata_2019-08-prime-number-puzzles` = (project in file("kata_2019-08-prime-number-puzzles"))
  .settings(commonSettings)

lazy val `kata_2019-09-game-of-life` = (project in file("kata_2019-09-game-of-life"))
  .settings(commonSettings)
