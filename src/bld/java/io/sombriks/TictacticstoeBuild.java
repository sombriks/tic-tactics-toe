package io.sombriks;

import rife.bld.Project;

import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;

public class TictacticstoeBuild extends Project {
    public TictacticstoeBuild() {
        pkg = "io.sombriks";
        name = "Tictacticstoe";
        mainClass = "io.sombriks.TictacticstoeMain";
        version = version(0, 1, 0);

        downloadSources = true;
        repositories = List.of(MAVEN_CENTRAL, RIFE2_RELEASES);

        scope(compile)
                .include(dependency("org.slf4j:slf4j-simple:2.0.16"))
                .include(dependency("io.javalin:javalin:6.3.0"));

        scope(test)
                .include(dependency("org.hamcrest:hamcrest:3.0"))
                .include(dependency("io.javalin:javalin-testtools:6.3.0"))
                .include(dependency("org.junit.jupiter", "junit-jupiter", version(5, 11, 0)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 11, 0)));
    }

    public static void main(String[] args) {
        new TictacticstoeBuild().start(args);
    }
}