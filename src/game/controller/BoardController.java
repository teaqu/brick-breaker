package game.controller;

import game.model.body.Board;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            board.left = true;
        } else if (code == KeyEvent.VK_D) {
            board.right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            board.left = false;
        } else if (code == KeyEvent.VK_D) {
            board.right = false;
        }
    }
}
