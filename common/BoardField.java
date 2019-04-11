package ija.ija2018.homework2.common;

public class BoardField implements Field {
	protected int col;
	protected int row;
	protected boolean hasDisk;
	protected Figure disk;
	protected Field Dfield;
	protected Field Lfield;
	protected Field LDfield;
	protected Field LUfield;
	protected Field Rfield;
	protected Field RDfield;
	protected Field RUfield;
	protected Field Ufield;

	public BoardField(int col, int row) {
        this.col = col;
        this.row = row;
    }

	public int[] getPosition() {
        int[] position = {row, col};
        return position;
    }

	public boolean put(Figure newdisk) {
        if (hasDisk) {
            if (disk.isWhite() == newdisk.isWhite())
                return false;
            else
                disk.setPosition(null);
                disk.destroyed(hasDisk);
        }

        this.disk = newdisk;
        this.hasDisk = true;
        disk.addToHistory();
        disk.setPosition(this);
        return true;
    }

	public Figure get() {
        if (!hasDisk)
            return null;

        return disk;
    }

	public boolean isEmpty() {
        return !hasDisk;
    }

	public boolean remove(Figure disk) {
        if (this.disk.equals(disk)) {
            this.disk = null;
            this.hasDisk = false;
            return true;
        }
        return false;
    }

    public void addNextField(Field.Direction dirs, Field field) {
        switch(dirs) {
            case D:
                this.Dfield = field;
                break;
            case L:
                this.Lfield = field;
                break;
            case LD:
                this.LDfield = field;
                break;
            case LU:
                this.LUfield = field;
                break;
            case R:
                this.Rfield = field;
                break;
            case RD:
                this.RDfield = field;
                break;
            case RU:
                this.RUfield = field;
                break;
            case U:
                this.Ufield = field;
                break;
        }
    }

    public Field nextField(Field.Direction dirs) {
        switch(dirs) {
            case D:
                return Dfield;
            case L:
                return Lfield;
            case LD:
                return LDfield;
            case LU:
                return LUfield;
            case R:
                return Rfield;
            case RD:
                return RDfield;
            case RU:
                return RUfield;
            case U:
                return Ufield;
        }

        return null;
    }
}
