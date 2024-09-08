package io.sombriks;

import io.javalin.Javalin;
import io.sombriks.configs.Database;
import io.sombriks.controllers.*;
import io.sombriks.services.*;
import io.sombriks.templates.layouts.MainLayout;
import io.sombriks.templates.pages.MapsPage;

import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * service entrypoint
 */
public class TictacticstoeMain {
  
  private final Database database = new Database();
  
  private final WorldMapService worldMapService = new WorldMapService(database);
  private final BoardService boardService = new BoardService(database);
  private final ChallengeService challengeService = new ChallengeService(database);
  private final FightService fightService = new FightService(database);
  
  private final PlayerService playerService = new PlayerService(database);
  private final DeckService deckService = new DeckService(database);
  private final SettingsService settingsService = new SettingsService(database);
  
  private final CardService cardService = new CardService(database);
  
  private final WorldMapController worldMapController = new WorldMapController(worldMapService);
  private final BoardController boardController = new BoardController(boardService);
  private final ChallengeController challengeController = new ChallengeController(challengeService);
  private final FightController fightController = new FightController(fightService);
  
  private final PlayerController playerController = new PlayerController(playerService);
  private final DeckController deckController = new DeckController(deckService);
  private final SettingsController settingsController = new SettingsController(settingsService);
  
  private final CardController cardController = new CardController(cardService);
  
  final Javalin server = Javalin.create(config -> {
    config.staticFiles.enableWebjars();
    // our route config
    config.router.apiBuilder(() -> {
      get("/", ctx -> ctx.redirect("/maps"));
      get("/status", ctx -> ctx.result("ONLINE"));
      
      path("/maps", () -> {
        get(worldMapController::index);
        path("/{mapId}", () -> {
          get(worldMapController::find);
          path("/boards", () -> {
            get(boardController::index);
            path("/{boardId}", () -> {
              get(boardController::find);
              path("/challenges", () -> {
                get(challengeController::index);
                path("/{challengeId}", () -> {
                  get(challengeController::find);
                  path("/fights", () -> {
                    get(fightController::index);
                    path("/{fightId}", () -> {
                      get(fightController::find);
                    });
                  });
                });
              });
            });
          });
        });
      });
      path("/players", () -> {
        get(playerController::index);
        path("/{playerId}", () -> {
          get(playerController::find);
          path("/decks", () -> {
            get(deckController::index);
            path("/{deckId}", () -> {
              get(deckController::find);
            });
          });
          path("/settings", () -> {
            get(settingsController::index);
          });
        });
      });
      path("/cards", () -> {
        get(cardController::index);
        path("/{cardId}", () -> {
          get(cardController::find);
        });
      });
    });
  });
  
  public static void main(String[] args) {
    // TODO System.getEnv()
    new TictacticstoeMain().server.start(7070);
  }
}
