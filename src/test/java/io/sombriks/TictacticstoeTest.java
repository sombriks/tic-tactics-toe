package io.sombriks;

import org.junit.jupiter.api.Test;

import io.javalin.testtools.JavalinTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TictacticstoeTest {

    private final TictacticstoeMain app = new TictacticstoeMain();

    @Test
    public void shouldCheckStatus() {
        JavalinTest.test(app.server, (server, client) -> {
            var result = client.get("/status");
            assertThat(result.code(), is(200));
            assertThat(result.body().string(), is("ONLINE"));

        });
    }
}
