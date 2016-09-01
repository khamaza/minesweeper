package com.miner;

public class BaseAction implements UserAction {
    private final GeneratorBoard generatorBoard;
    private final Board board;
    private final MinerLogic minerLogic;

    public BaseAction(final GeneratorBoard generatorBoard, final Board board, final MinerLogic minerLogic) {
        this.generatorBoard = generatorBoard;
        this.board = board;
        this.minerLogic = minerLogic;
    }

    @Override
    public void initGame() {
        final Cell[][] cells = generatorBoard.generate(
                minerLogic.getRowNumber(),
                minerLogic.getColumnNumber(),
                minerLogic.getBombNumber()
        );
        this.board.setCells(cells);
        this.minerLogic.loadBoard(cells);
    }

    @Override
    public void select(int x, int y, Constants.SUGGESTION suggestion) {
        this.minerLogic.suggest(x, y, suggestion);
        board.redraw();
        if (this.minerLogic.shouldBang(x, y)) {
            this.board.drawGameOver();
            this.initGame();
        }
        if (this.minerLogic.finish()) {
            this.board.drawCongratulate();
            this.initGame();
        }
    }
}
