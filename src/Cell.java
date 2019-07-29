class Cell {
    private boolean alive;

    void kill(){
        this.alive = false;
    }

    void makeAlive(){
        this.alive = true;
    }

    boolean isAlive(){
        return this.alive;
    }
}
