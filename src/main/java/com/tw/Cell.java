package com.tw;

import java.util.Objects;

public class Cell {
    public int status;
    public Cell(int status){
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return status == cell.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return String.valueOf(status);
    }
}
