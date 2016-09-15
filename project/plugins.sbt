
resolvers ++= Seq(
  Resolver.mavenLocal,
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "jgit-repo" at "http://download.eclipse.org/jgit/maven",
  "Twitter Repository" at "http://maven.twttr.com/",
  "SBT Plugin Releases" at "http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases"
)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.6")
