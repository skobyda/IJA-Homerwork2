package ija.ija2018.homework2.common;

public interface Figure {
    public void addToHistory();
    public void undo();
    public boolean isWhite();
	public String getState();
    public void setPosition(Field field);
    public boolean move(Field moveTo);

}
