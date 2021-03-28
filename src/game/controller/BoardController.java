package game.controller;

import game.model.body.Board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Control the board (player)
 */
public class BoardController implements KeyListener {

    private Board board;

    public BoardController(Board board){
        this.board = board;
    }

    public void updateBoard(Board board) {
        this.board = board;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // Move left on a
        if (code == KeyEvent.VK_A) {
            board.left = true;
        } else if (code == KeyEvent.VK_D) {
            // Move right on d
            board.right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            // Stop moving left
            board.left = false;
        } else if (code == KeyEvent.VK_D) {
            // Stop moving right
            board.right = false;
        }
    }
}
