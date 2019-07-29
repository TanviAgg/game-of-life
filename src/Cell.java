// Represents the state of one square in the grid
class Cell {
    private State state;

    Cell() {
        this.state = State.DEAD;
    }

    void kill(){
        this.state = State.DEAD;
    }

    void makeAlive(){
        this.state = State.LIVE;
    }

    boolean isAlive(){
        return this.state == State.LIVE;
    }
}
