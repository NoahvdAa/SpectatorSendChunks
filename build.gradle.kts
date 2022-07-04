plugins {
  `java-library`
  id("xyz.jpenilla.run-paper") version "1.0.6" // Adds runServer and runMojangMappedServer tasks for testing
  id("net.minecrell.plugin-yml.bukkit") version "0.5.2" // Generates plugin.yml
}

group = "me.noahvdaa.spectatorsendchunks"
version = "1.0.0"
description =
  "SpectatorSendChunks attempts to work around MC-148993 by re-setting the player's spectated entity on a timer."

java {
  // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

repositories {
  maven {
    url = uri("https://repo.papermc.io/repository/maven-public/")
  }
}

tasks {
  compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

    // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
    // See https://openjdk.java.net/jeps/247 for more information.
    options.release.set(17)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  runServer {
    minecraftVersion.set("1.19")
  }
}

// Configure plugin.yml generation
bukkit {
  main = "me.noahvdaa.spectatorsendchunks.SpectatorSendChunks"
  description =
    "SpectatorSendChunks attempts to work around MC-148993 by re-setting the player's spectated entity on a timer."
  website = "https://github.com/NoahvdAa/SpectatorSendChunks"
  apiVersion = "1.13"
  authors = listOf("NoahvdAa")
}
