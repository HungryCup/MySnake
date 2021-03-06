package SnakeGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller {
    static GraphicsContext gc;
    static Game game;

    public static void refresh() {
        gc.clearRect(0, 0, 800, 600);
        for (int i = 0; i < game.getField().getHeight(); i++) {
            for (int j = 0; j < game.getField().getWidth(); j++) {
                if (game.getField().get(i, j) != 0) { //если что-то есть
                    switch (game.getField().get(i, j)) {
                        case 1:
                            gc.setFill(Color.valueOf("#aaaaaa")); //змейка
                            break;
                        case 2:
                            gc.setFill(Color.valueOf("#fc4e4e")); //голова
                            break;
                        case 3:
                            gc.setFill(Color.valueOf("#8eff84")); //еда
                            break;
                        case 4:
                            gc.setFill(Color.valueOf("#4e82fc")); //преграда
                    }
                    gc.fillRect(j * 20, i * 20, 20, 20);
                }
            }
        }
        if (game.isGameOver()) {
            gc.setFill(Color.RED);
            gc.setFont(new Font(60));
            gc.fillText("GAME OVER!", 200, 270);
        } else if (game.isWin()) {
            gc.setFill(Color.LIGHTGREEN);
            gc.setFont(new Font(60));
            gc.fillText("YOU WIN!", 240, 270);
        }
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(20));
        gc.fillText(game.getScore().toString(),0,20);
    }
}
