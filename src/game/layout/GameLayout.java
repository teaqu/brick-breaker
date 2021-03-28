package game.layout;

import city.cs.engine.UserView;
import game.controller.BoardController;
import game.controller.GameController;
import game.level.GameLevel;
import game.level.Level2;
import game.mouse.GiveFocus;
import game.mouse.MouseHandler;

import java.awt.*;

public class GameLayout extends ImagePanel {
    private UserView mapView;
    private GameView gameView;
    private BottomMenu bottomMenu;
    private BoardController boardController;
    private GameController gameController;

    public GameLayout(GameLevel level) {
        super("data/images/background.png");
        // make a view
        gameView = new GameView(level, 600, 600);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        gameView.addMouseListener(new MouseHandler(level, gameView));

        boardController = new BoardController(level.getBoard());
        gameView.addKeyListener(boardController);

        gameController = new GameController(level.getGame());
        gameView.addKeyListener(gameController);

        gameView.addMouseListener(new GiveFocus(gameView));

        gameView.setZoom(20);
        setLayout(new BorderLayout());
        add(gameView);

        mapView = new UserView(level, 100, 100);
        mapView.setZoom(3);
        mapView.setOpaque(false);
        add(mapView, BorderLayout.EAST);

        bottomMenu = new BottomMenu(level, level.getStats());
        add(bottomMenu.getMainPanel(), BorderLayout.SOUTH);
        setupLevelLayout(level);
    }

    public void changeLevel(GameLevel level) {
        setupLevelLayout(level);
        gameView.setWorld(level);
        boardController.updateBoard(level.getBoard());
        mapView.setWorld(level);
        mapView.setZoom(3);
    }

    private void setupLevelLayout(GameLevel level) {
        if (level.getBackground() != null) {
            setBackground(level.getBackground());
        }
        if (level.getTextColour() != null) {
            bottomMenu.setTextColour(level.getTextColour());
        }
    }

    public GameView getGameView() {
        return gameView;
    }
}
