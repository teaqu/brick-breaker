package game.layout;

import city.cs.engine.UserView;
import game.controller.BoardController;
import game.controller.GameController;
import game.level.GameLevel;
import game.mouse.GiveFocus;
import game.mouse.MouseHandler;

import java.awt.*;

/**
 * Game layout is our level viewer. It shows the current level,
 * stats at the bottom and map on the right hand side.
 * <p>
 * It's basically a container for GameView
 */
public class GameLayout extends ImagePanel {
    private final UserView mapView;
    private final GameView gameView;
    private final BottomMenu bottomMenu;
    private final BoardController boardController;

    public GameLayout(GameLevel level) {
        // Set default background if none given
        super("data/images/background.png");

        // Make a view
        gameView = new GameView(level, 600, 600);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        gameView.addMouseListener(new MouseHandler(level, gameView));

        // Add board controller to game view
        boardController = new BoardController(level.getBoard());
        gameView.addKeyListener(boardController);

        // Add game controller to game view
        GameController gameController = new GameController(level.getGame());
        gameView.addKeyListener(gameController);

        // Listen for the mouse
        gameView.addMouseListener(new GiveFocus(gameView));

        // Set border layout
        setLayout(new BorderLayout());

        // Add game view center
        gameView.setZoom(20);
        add(gameView);

        // Add a map to the right
        mapView = new UserView(level, 100, 100);
        mapView.setZoom(3);
        mapView.setOpaque(false);
        add(mapView, BorderLayout.EAST);

        // Add our bottom menu
        bottomMenu = new BottomMenu(level, level.getStats());
        add(bottomMenu.getMainPanel(), BorderLayout.SOUTH);

        // Setup the layout for this level
        setupLevelLayout(level);
    }

    /**
     * Change the level shown in this layout
     *
     * @param level
     */
    public void changeLevel(GameLevel level) {
        // Setup the layout for this level
        setupLevelLayout(level);

        // Change level shown in game view
        gameView.setWorld(level);

        // Update the board listener
        boardController.updateBoard(level.getBoard());

        // Update the map to reflect the new level
        mapView.setWorld(level);
        mapView.setZoom(3);
    }

    /**
     * Setup the layout for the given level
     * @param level
     */
    private void setupLevelLayout(GameLevel level) {
        // If we have a level background, show that
        if (level.getBackground() != null) {
            setBackground(level.getBackground());
        }

        // If we have custom text level colours, set those.
        if (level.getTextColour() != null) {
            bottomMenu.setTextColour(level.getTextColour());
        }
    }

    public GameView getGameView() {
        return gameView;
    }
}
